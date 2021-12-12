package com.demo;

import java.util.Scanner;

public class Review {
    private String reviewId, reviewContent, reviewPublishDate;
    Scanner sc = new Scanner(System.in);

    Review(String reviewId, String reviewContent, String reviewPublishDate) {
        this.reviewId = reviewId;
        this.reviewContent = reviewContent;
        this.reviewPublishDate = reviewPublishDate;
    }

    Review() {

    }

    // Setter

    void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    void setReviewPublishDate(String reviewPublishDate) {
        this.reviewPublishDate = reviewPublishDate;
    }

    void setReview() {
        System.out.print("Nhap ");
    }

    // Getter

    public String getReviewId() {
        return reviewId;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public String getReviewPublishDate() {
        return reviewPublishDate;
    }
}
