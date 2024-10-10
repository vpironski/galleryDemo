package com.gallery.galleryDemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaintingDto {
    private String id;
    private String name;
    private String artist;
    private String description;
}