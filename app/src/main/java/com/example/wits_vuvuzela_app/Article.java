package com.example.wits_vuvuzela_app;

import android.media.Image;

import java.util.ArrayList;
import java.util.Date;

public class Article {

    private String ArticleImage = "no Image";
    private String ArticleTitle = " No Title";
    private String ArticleAutherName = "No Auther";
    private String ArticleComments = "User1-comment/User2-Comment";
    private String ArticleDateUploaded = "NoDate";
    private String ArticleLink = "No lInk";
    private String ArticleLikes = "0";
    private String ArticleDislikes = "0";
    private String ArticleLikedList = "User1/User2";
    private String ArticleDislikedList = "User1/User2";
    private String RateStatus = "none";

    public String getArticleLikes() {
        return ArticleLikes;
    }

    public void setArticleLikes(String articleLikes) {
        ArticleLikes = articleLikes;
    }

    public String getArticleDislikes() {
        return ArticleDislikes;
    }

    public void setArticleDislikes(String articleDislikes) {
        ArticleDislikes = articleDislikes;
    }

    public String getArticleComments() {
        return ArticleComments;
    }

    public void setArticleComments(String articleComments) {
        ArticleComments = articleComments;
    }

    public String getArticleLink() {
        return ArticleLink;
    }

    public void setArticleLink(String articleLink) {
        ArticleLink = articleLink;
    }

    public String getArticleImage() {
        return ArticleImage;
    }

    public void setArticleImage(String articleImage) {
        ArticleImage = articleImage;
    }

    public String getArticleTitle() {
        return ArticleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        ArticleTitle = articleTitle;
    }

    public String getArticleAutherName() {
        return ArticleAutherName;
    }

    public String getRateStatus() {
        return RateStatus;
    }

    public void setRateStatus(String rateStatus) {
        RateStatus = rateStatus;
    }

    public void setArticleAutherName(String articleAutherName) {
        ArticleAutherName = articleAutherName;
    }

    public String getArticleLikedList() {
        return ArticleLikedList;
    }

    public void setArticleLikedList(String articleLikedList) {
        ArticleLikedList = articleLikedList;
    }

    public String getArticleDislikedList() {
        return ArticleDislikedList;
    }

    public void setArticleDislikedList(String articleDislikedList) {
        ArticleDislikedList = articleDislikedList;
    }

    public String getArticleDateUploaded() {
        return ArticleDateUploaded;
    }

    public void setArticleDateUploaded(String articleDateUploaded) {
        ArticleDateUploaded = articleDateUploaded;
    }

    public void AddComment(String NewComment, String User) {

        if (ArticleComments.equals("")) {
            ArticleComments = User + "-" + NewComment;
        } else {
            ArticleComments = ArticleComments + "/" + User + "-" + NewComment;
        }
    }

    public boolean ArticleAlreadyLiked(String User) {

        String[] LikedArticle = ArticleLikedList.split("/");

        for (int i = 0; i < LikedArticle.length; ++i) {
            if (User.equals(LikedArticle[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean ArticleAlreadyDisliked(String User) {

        String[] DislikedArticle = ArticleDislikedList.split("/");

        for (int i = 0; i < DislikedArticle.length; ++i) {
            if (User.equals(DislikedArticle[i])) {
                return true;
            }
        }
        return false;
    }

    public void RemoveUserFromLikedArticleList(String User) {

        String[] LikedArticle = ArticleLikedList.split("/");

        String NewList = "User";

        for (int i = 0; i < LikedArticle.length; ++i) {
            if (User.equals(LikedArticle[i])) {
                continue;
            }

            NewList += ("/" + LikedArticle[i]);
        }

        ArticleLikedList = NewList;
    }

    public void RemoveUserFromDislikedArticleList(String User) {

        String[] DislikedArticle = ArticleDislikedList.split("/");

        String NewList = "User1";

        for (int i = 0; i < DislikedArticle.length; ++i) {
            if (User.equals(DislikedArticle[i])) {
                continue;
            }

            NewList += ("/" + DislikedArticle[i]);
        }

        ArticleDislikedList = NewList;
    }


    public void AddUserToLikedList(String User) {
        if(ArticleLikedList.equals("")){
            ArticleLikedList+=User;
        }
        else {
            ArticleLikedList = ArticleLikedList + "/" + User;
        }
    }

    public void AddUserToDislikedList(String User) {
        if (ArticleDislikedList.equals("")) {
            ArticleDislikedList += User;
        }
        else {
            ArticleDislikedList = ArticleDislikedList + "/" + User;
        }
    }

    public void LikeAnArticle(String User) {

        int NumLikes = Integer.parseInt(ArticleLikes);
        int NumDislikes = Integer.parseInt(ArticleDislikes);

        if(!ArticleAlreadyLiked(User) && !ArticleAlreadyDisliked(User)){
            NumLikes+=1;
            AddUserToLikedList(User);
            ArticleLikes = String.valueOf(NumLikes);
        }

        else if(ArticleAlreadyLiked(User)){

            if(ArticleLikes.equals("0")){
                ArticleLikes = String.valueOf(NumLikes);
            }

            else {
                NumLikes -= 1;
                ArticleLikes = String.valueOf(NumLikes);
                RemoveUserFromLikedArticleList(User);
            }
        }

        else if(ArticleAlreadyDisliked(User)){

            NumLikes+=1;
            NumDislikes-=1;
            ArticleLikes = String.valueOf(NumLikes);
            ArticleDislikes = String.valueOf(NumDislikes);
            AddUserToLikedList(User);
            RemoveUserFromDislikedArticleList(User);
        }
    }

    public void DislikeAnArticle(String User){

        int NumLikes = Integer.parseInt(ArticleLikes);
        int NumDislikes = Integer.parseInt(ArticleDislikes);

        if(!ArticleAlreadyLiked(User) && !ArticleAlreadyDisliked(User)){
            NumDislikes+=1;
            ArticleDislikes = String.valueOf(NumDislikes);
            AddUserToDislikedList(User);
        }

        else if(ArticleAlreadyDisliked(User)){

            if(ArticleDislikes.equals("0")){
                ArticleDislikes = String.valueOf(NumDislikes);
            }
            else {
                NumDislikes -= 1;
                ArticleDislikes = String.valueOf(NumDislikes);
                RemoveUserFromDislikedArticleList(User);
            }
        }

        else if(ArticleAlreadyLiked(User)){

            NumLikes -= 1;
            NumDislikes += 1;
            ArticleLikes = String.valueOf(NumLikes);
            ArticleDislikes = String.valueOf(NumDislikes);
            AddUserToDislikedList(User);
            RemoveUserFromLikedArticleList(User);
        }
    }
}
