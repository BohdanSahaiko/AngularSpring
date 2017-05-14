package com.parserLogic;

import com.itextpdf.text.pdf.PdfReader;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Logic {
    static Document doc;
    static PdfReader reader;
    static List<String> funkForName(String link) throws IOException {
        List<String> titles = new ArrayList<>();
        doc = Jsoup.connect(link).get();
        Elements titlesElements = doc.getElementsByAttributeValue("class", "o3");
        titlesElements.forEach(myElement -> {
            Element elements = myElement.child(0);
            String name = elements.text();
            if (name.length() > 7)
                titles.add(name);
        });
        return titles;
    }
    static List<String> funkForAuthors(String link) throws IOException {
        List<String> titles = new ArrayList<>();
        Elements authorsElements = doc.select(".o2");
        for (Element elements : authorsElements) {
            String name = elements.text();
            if (!name.equals("Summary") && name.length() >= 6) {
                titles.add(name);
            }
        }
        return titles;
    }
    static List<String> funkForPages(String link) throws IOException {
        List<String> titles = new ArrayList<>();
        Elements pagesElements = doc.getElementsByAttributeValue("class", "o4");
        pagesElements.forEach(myElement -> {
            Element elements = myElement.child(0);
            String name = elements.text();
            try {
                Integer.parseInt(name);
                titles.add(name);
            } catch (Exception e) {
            }
        });
        return titles;
    }


}
