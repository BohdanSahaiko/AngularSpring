package com.Entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by bohdan on 11.03.17.
 */
@Entity
@Table(name = "new_table")
public class Publication implements Serializable{
    private static final long serialVersionUID = 1976570422585664137L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    long id;
    @Column(name="tittle")
    String tittle;
    @Column(name="author")
    String author;
    @Column(name="pages")
    String pages;
    @Column(name="year")
    String year;
    @Column(name="point")
    String point;
    @Column(name="words")
    String words;
    @Column(name="link")
    String link;
    @Column(name="thems")
    String thema;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getThema() {
        return thema;
    }

    public void setThema(String thema) {
        this.thema = thema;
    }

    public Publication(String tittle, String author, String pages, String year, String point, String words, String link, String thema) {
        this.tittle = tittle;
        this.author = author;
        this.pages = pages;
        this.year = year;
        this.point = point;
        this.words = words;
        this.link = link;
        this.thema = thema;
    }

    @Override
    public String toString() {
        return "Publication{" +
                "id=" + id +
                ", tittle='" + tittle + '\'' +
                ", author='" + author + '\'' +
                ", pages='" + pages + '\'' +
                ", year='" + year + '\'' +
                ", point='" + point + '\'' +
                ", words='" + words + '\'' +
                ", link='" + link + '\'' +
                ", thema='" + thema + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publication that = (Publication) o;

        if (id != that.id) return false;
        if (!tittle.equals(that.tittle)) return false;
        if (!author.equals(that.author)) return false;
        if (!pages.equals(that.pages)) return false;
        if (!year.equals(that.year)) return false;
        if (!point.equals(that.point)) return false;
        if (!words.equals(that.words)) return false;
        if (!link.equals(that.link)) return false;
        return thema.equals(that.thema);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + tittle.hashCode();
        result = 31 * result + author.hashCode();
        result = 31 * result + pages.hashCode();
        result = 31 * result + year.hashCode();
        result = 31 * result + point.hashCode();
        result = 31 * result + words.hashCode();
        result = 31 * result + link.hashCode();
        result = 31 * result + thema.hashCode();
        return result;
    }

    public Publication() {
    }
}
