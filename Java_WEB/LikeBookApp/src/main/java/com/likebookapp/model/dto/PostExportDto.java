package com.likebookapp.model.dto;

public class PostExportDto {

    private String mood;
    private int likes;

    private String content;

    public PostExportDto(String mood, int likes, String content) {
        this.mood = mood;
        this.likes = likes;
        this.content = content;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
