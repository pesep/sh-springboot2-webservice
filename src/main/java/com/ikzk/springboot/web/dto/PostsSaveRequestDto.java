package com.ikzk.springboot.web.dto;

import com.ikzk.springboot.domain.posts.Posts;

public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public PostsSaveRequestDto() {
    }

    public static PostsSaveRequestDtoBuilder builder() {
        return new PostsSaveRequestDtoBuilder();
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
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

    public static class PostsSaveRequestDtoBuilder {
        private String title;
        private String content;
        private String author;

        PostsSaveRequestDtoBuilder() {
        }

        public PostsSaveRequestDtoBuilder title(String title) {
            this.title = title;
            return this;
        }

        public PostsSaveRequestDtoBuilder content(String content) {
            this.content = content;
            return this;
        }

        public PostsSaveRequestDtoBuilder author(String author) {
            this.author = author;
            return this;
        }

        public PostsSaveRequestDto build() {
            return new PostsSaveRequestDto(title, content, author);
        }

        public String toString() {
            return "PostsSaveRequestDto.PostsSaveRequestDtoBuilder(title=" + this.title + ", content=" + this.content + ", author=" + this.author + ")";
        }
    }
}
