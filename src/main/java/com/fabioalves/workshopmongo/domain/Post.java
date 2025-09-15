package com.fabioalves.workshopmongo.domain;

import com.fabioalves.workshopmongo.dto.AuthorDTO;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@NoArgsConstructor
@AllArgsConstructor
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
}
