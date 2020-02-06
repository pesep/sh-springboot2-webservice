package com.ikzk.springboot.domain.posts;

import com.ikzk.springboot.domain.BaseTimeEntity;

import javax.persistence.*;

@Entity
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts() {
    }

    public static PostsBuilder builder() {
        return new PostsBuilder();
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }

    public String getAuthor() {
        return this.author;
    }

    public static class PostsBuilder {
        private String title;
        private String content;
        private String author;

        PostsBuilder() {
        }

        public PostsBuilder title(String title) {
            this.title = title;
            return this;
        }

        public PostsBuilder content(String content) {
            this.content = content;
            return this;
        }

        public PostsBuilder author(String author) {
            this.author = author;
            return this;
        }

        public Posts build() {
            return new Posts(title, content, author);
        }

        public String toString() {
            return "Posts.PostsBuilder(title=" + this.title + ", content=" + this.content + ", author=" + this.author + ")";
        }
    }
}
