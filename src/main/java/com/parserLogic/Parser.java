package com.parserLogic;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//http://nltu.edu.ua/nv/Archive/2016/26_5/index26_5.htm http://nltu.edu.ua/nv/Archive/2015/25_10/index25_10.htm "http://nltu.edu.ua/nv/Archive/2015/25_5/index25_5.htm" "http://nltu.edu.ua/nv/Archive/2015/25_3/index25_3.htm"
public class Parser {

    public static List<Parrrt> lister(String parser) throws IOException {
        PdfReader reader;
        String link = parser;
        String forPdf = link.substring(0, link.length() - 13);
        String[] parts = link.split("/");
        String year = parts[5];
        String part = parts[6];
        List<Parrrt> list = new ArrayList<>();
        List<String> titles;
        List<String> links = new ArrayList<>();
        List<String> themes = new ArrayList<>();
        List<String> pages;
        List<String> authors;
        List<String> kayWords = new ArrayList<>();
        Document doc = Jsoup.connect(link).get();
        //Logic
        //
        titles = Logic.funkForName(link);
        authors = Logic.funkForAuthors(link);
        pages = Logic.funkForPages(link);

        int itemCount = titles.size();
        for (int i = 3; i < itemCount + 3; i++) {
            links.add(forPdf + Integer.toString(i) + ".pdf");
        }

        //Pdf
        try {//index26_8,7,,4,3,2,1  index25_9,8,7,6,4,2,1
            for (String text : links
                    ) {
                kayWords.size();
                reader = new PdfReader(text);
                boolean some = false;
                String textFromPage = PdfTextExtractor.getTextFromPage(reader, 2);
                if ((textFromPage.contains("Ключові") || textFromPage.contains("Słowa kluczowe:") || textFromPage.contains("Ключевые"))) {
                    String pars[];
                    pars = text.split("\\r?\\n");
                    for (int i = 0; i < pars.length; i++) {
                        if (pars[i].contains("Ключов") || pars[i].contains("Słowa kluczowe:") || pars[i].contains("Ключевые")) {
                            int petro = pars[i].indexOf("Ключов");
                            int slavik = pars[i].indexOf("Słowa kluczowe:");
                            int misha = pars[i].indexOf("Ключов");
                            int k = petro > -1 ? petro : slavik > -1 ? slavik : misha > -1 ? misha : -1;
                            if (k > -1) {
                                String sub = pars[i].substring(k, pars[i].length());
                                if (sub.contains(".")) {
                                    kayWords.add(sub);
                                } else {
                                    kayWords.add(sub + pars[i + 2]);
                                }
                                some = true;
                                reader.close();
                                break;
                            }
                        }
                    }
                } else if (!(textFromPage.contains("Ключові") || textFromPage.contains("Słowa kluczowe:") || textFromPage.contains("Ключевые"))) {
                    textFromPage = PdfTextExtractor.getTextFromPage(reader, 1);
                    String pars[];
                    pars = textFromPage.split("\\r?\\n");
                    for (int i = 0; i < pars.length; i++) {
                        if (pars[i].contains("Ключов") || pars[i].contains("Słowa kluczowe") || pars[i].contains("Ключевые")) {
                            if (pars[i].contains("Ключов") || pars[i].contains("Słowa kluczowe:") || pars[i].contains("Ключевые")) {
                                int aaaaaaaa;
                                int petro = pars[i].indexOf("Ключов");
                                int slavik = pars[i].indexOf("Słowa kluczowe:");
                                int misha = pars[i].indexOf("Ключов");
                                int k = petro > -1 ? petro : slavik > -1 ? slavik : misha > -1 ? misha : -1;
                                if (k > -1) {
                                    String sub = pars[i].substring(k, pars[i].length());
                                    if (sub.contains(".")) {
                                        kayWords.add(sub);
                                    } else {
                                        kayWords.add(sub + pars[i + 2]);
                                    }
                                    some = true;
                                    reader.close();
                                    break;
                                }

                            }
                        }
                    }

                }
                if (!some) kayWords.add("Ключові слова: undefined");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        for (int i = 0; i < authors.size(); i++) {
            String lk = links.get(i);
            String tit = titles.get(i);
            String at = authors.get(i);
            String pgs = pages.get(i);
            String yr = year;
            String the = part;
            String kk = kayWords.get(i);
           list.add(new Parrrt(tit, at, pgs, the, lk, yr, kk));
        }
        return list;
        }

    }

       // EКОЛОГІЯ ДОВКІЛЛЯ ТЕХНОЛОГІЯ ТА УСТАТКУВАННЯ ЛІСОВИРОБНИЧОГО КОМПЛЕКСУ