package com.fabioalves.workshopmongo.domain;

import com.fabioalves.workshopmongo.dto.AuthorDTO;
import com.fabioalves.workshopmongo.dto.CommentDTO;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Post {

    @Id
    private String id;
    private Date date;
    private String title;
    private String body;

    private AuthorDTO author;
    private List<CommentDTO> comments = new ArrayList<>();

    public Post(String id, Date date, String title, String body, AuthorDTO author) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
        this.author = author;
    }
}
