package com.company;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class DTO {

    private String trackId;
    private String trackCensoredName;
    private List<Reviews> reviews;
    @JsonIgnore private  String sellerName;
    @JsonIgnore private  int userRatingCount;
    private  double averageUserRating;
    @JsonIgnore private  String artworkUrl512;
    @JsonIgnore private  String artworkUrl100;
    @JsonIgnore private  String trackViewUrl;
    @JsonIgnore private  String formattedPrice;
    @JsonIgnore private  String start_date;
    @JsonIgnore private  String end_date;
    @JsonIgnore private  String number_reviews;
    @JsonIgnore private  String total_reviews;
    @JsonIgnore private int page;
    @JsonIgnore private int limit;
    @JsonIgnore private int total_pages;



    public String getTrackId() {
        return trackId;
    }

    public void setTrackId(String trackId) {
        this.trackId = trackId;
    }

    public String getTrackCensoredName() {
        return trackCensoredName;
    }

    public void setTrackCensoredName(String trackCensoredName) {
        this.trackCensoredName = trackCensoredName;
    }

    public List<Reviews> getReviews() {
        return reviews;
    }

    public void setReviews(List<Reviews> reviews) {
        this.reviews = reviews;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public int getUserRatingCount() {
        return userRatingCount;
    }

    public void setUserRatingCount(int userRatingCount) {
        this.userRatingCount = userRatingCount;
    }

    public double getAverageUserRating() {
        return averageUserRating;
    }

    public void setAverageUserRating(double averageUserRating) {
        this.averageUserRating = averageUserRating;
    }

    public String getArtworkUrl512() {
        return artworkUrl512;
    }

    public void setArtworkUrl512(String artworkUrl512) {
        this.artworkUrl512 = artworkUrl512;
    }

    public String getArtworkUrl100() {
        return artworkUrl100;
    }

    public void setArtworkUrl100(String artworkUrl100) {
        this.artworkUrl100 = artworkUrl100;
    }

    public String getTrackViewUrl() {
        return trackViewUrl;
    }

    public void setTrackViewUrl(String trackViewUrl) {
        this.trackViewUrl = trackViewUrl;
    }

    public String getFormattedPrice() {
        return formattedPrice;
    }

    public void setFormattedPrice(String formattedPrice) {
        this.formattedPrice = formattedPrice;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getNumber_reviews() {
        return number_reviews;
    }

    public void setNumber_reviews(String number_reviews) {
        this.number_reviews = number_reviews;
    }

    public String getTotal_reviews() {
        return total_reviews;
    }

    public void setTotal_reviews(String total_reviews) {
        this.total_reviews = total_reviews;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    @Override
    public String toString() {
        return "DTO{" +
                "trackId='" + trackId + '\'' +
                ", trackCensoredName='" + trackCensoredName + '\'' +
                ", reviews=" + reviews +
                ", sellerName='" + sellerName + '\'' +
                ", userRatingCount=" + userRatingCount +
                ", averageUserRating=" + averageUserRating +
                ", artworkUrl512='" + artworkUrl512 + '\'' +
                ", artworkUrl100='" + artworkUrl100 + '\'' +
                ", trackViewUrl='" + trackViewUrl + '\'' +
                ", formattedPrice='" + formattedPrice + '\'' +
                ", start_date='" + start_date + '\'' +
                ", end_date='" + end_date + '\'' +
                ", number_reviews='" + number_reviews + '\'' +
                ", total_reviews='" + total_reviews + '\'' +
                ", page=" + page +
                ", limit=" + limit +
                ", total_pages=" + total_pages +
                '}';
    }
}

