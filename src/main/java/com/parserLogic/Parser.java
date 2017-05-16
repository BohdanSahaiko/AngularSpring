package com.parserLogic;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    public static List<NoEntityObject> lister(String parser) throws IOException {
        PdfReader reader;
        String link = parser;
        String forPdf = link.substring(0, link.length() - 13);
        String[] parts = link.split("/");
        String year = parts[5];
        String part = parts[6];
        List<NoEntityObject> list = new ArrayList<>();
        List<String> titles;
        List<String> links = new ArrayList<>();
        List<String> themes = new ArrayList<>();
        List<String> pages;
        List<String> authors;
        List<String> kayWords = new ArrayList<>();
        //Logic
        titles = Logic.funkForName(link);
        authors = Logic.funkForAuthors();
        pages = Logic.funkForPages();

        int itemCount = titles.size();
        for (int i = 3; i < itemCount + 3; i++) {
            links.add(forPdf + Integer.toString(i) + ".pdf");
        }

        //Pdf
        try {
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
                            int ukr = pars[i].indexOf("Ключов");
                            int pol = pars[i].indexOf("Słowa kluczowe:");
                            int mos = pars[i].indexOf("Ключов");
                            int k = ukr > -1 ? ukr : pol > -1 ? pol : mos > -1 ? mos : -1;
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
                                int uk = pars[i].indexOf("Ключов");
                                int pol = pars[i].indexOf("Słowa kluczowe:");
                                int mos = pars[i].indexOf("Ключов");
                                int k = uk > -1 ? uk : pol > -1 ? pol : mos > -1 ? mos : -1;
                                if (k > -1) {
                                    String sub = pars[i].substring(k, pars[i].length());
                                    if (sub.contains(".")) {
                                        kayWords.add(sub);
                                        int y;
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
           list.add(new NoEntityObject(tit, at, pgs, the, lk, yr, kk));
        }
        return list;
        }
}
