package com.smallprojects.quote_generator.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Quote {
    int id;
    String content;
    String author;

    public Quote(int id, String content,String author){
        this.id= id;
        this.content = content;
        this.author = author;
    }

    public int getId() {
        return id;
    }
    public String getContent() {
        return content;
    }
    public String getAuthor() {
        return author;
    }
}
