package com.company;

public class Reviews {

    private String author_id;
    private String title;
    private String rating;
    private String lang;
    private String content;
    private String date;
    private String app_version;

    public String getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(String author_id) {
        this.author_id = author_id;
    }

    public String getApp_version() {
        return app_version;
    }

    public void setApp_version(String app_version) {
        this.app_version = app_version;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Reviews{" +
                "author_id='" + author_id + '\'' +
                ", title='" + title + '\'' +
                ", rating='" + rating + '\'' +
                ", lang='" + lang + '\'' +
                ", content='" + content + '\'' +
                ", date='" + date + '\'' +
                ", app_version='" + app_version + '\'' +
                '}';
    }
}
