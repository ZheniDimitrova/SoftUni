package com.likebookapp.model.entity;

import com.likebookapp.model.entity.enums.MoodNameEnum;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "moods")
public class Mood extends BaseEntity{
    @Column
    @Enumerated(EnumType.STRING)
    private MoodNameEnum moodName;
    @Column
    private String description;
    @OneToMany(mappedBy = "mood")
    private Set<Post> posts;

    public Mood() {
    }

    public MoodNameEnum getMoodName() {
        return moodName;
    }

    public void setMoodName(MoodNameEnum moodName) {
        this.moodName = moodName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }
}
