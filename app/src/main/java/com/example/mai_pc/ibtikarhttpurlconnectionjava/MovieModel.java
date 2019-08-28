package com.example.mai_pc.ibtikarhttpurlconnectionjava;

public class MovieModel {

    private String title;
    private int vote_count;
    private float popularity;
    private String original_language;

    @Override
    public String toString()
    {
        return "ClassPojo [ original_language = "+original_language+", title = "+title+", popularity = "+popularity+", vote_count = "+vote_count+"]";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    public float getPopularity() {
        return popularity;
    }

    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }
}









//            "release_date": "1995-10-20"

