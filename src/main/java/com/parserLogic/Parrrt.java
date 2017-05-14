package com.parserLogic;

/**
 * Created by bohdan on 14/05/17.
 */
public class Parrrt {
    String tiitle;
    String author;
    String pages;
    String them;
    String link;
    String year;
    String keyss;

    public String getTiitle() {
        return tiitle;
    }

    public void setTiitle(String tiitle) {
        this.tiitle = tiitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getThem() {
        return them;
    }

    public void setThem(String them) {
        this.them = them;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getKeyss() {
        return keyss;
    }

    public void setKeyss(String keyss) {
        this.keyss = keyss;
    }

    public Parrrt(String tiitle, String author, String pages, String them, String link, String year, String keyss) {
        this.tiitle = tiitle;
        this.author = author;
        this.pages = pages;
        this.them = them;
        this.link = link;
        this.year = year;
        this.keyss = keyss;
    }

    @Override
    public String toString() {
        return "Part{" +
                "tiitle='" + tiitle + '\'' +
                ", author='" + author + '\'' +
                ", pages='" + pages + '\'' +
                ", them='" + them + '\'' +
                ", link='" + link + '\'' +
                ", year='" + year + '\'' +
                ", keyss='" + keyss + '\'' +
                '}';
    }

    public Parrrt() {

    }
}