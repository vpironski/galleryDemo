package com.gallery.galleryDemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Getter
@Setter
@AllArgsConstructor
@Document(collection = "paintings")
public class Painting {
    @Id
    private String id;
    private String name;
    private String artist;
    private String description;

}

