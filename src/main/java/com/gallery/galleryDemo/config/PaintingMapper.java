package com.gallery.galleryDemo.config;

import com.gallery.galleryDemo.dto.PaintingDto;
import com.gallery.galleryDemo.model.Painting;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PaintingMapper {
    PaintingMapper INSTANCE = Mappers.getMapper(PaintingMapper.class);

    PaintingDto paintingToPaintingDto(Painting painting);
    Painting paintingDtoToPainting(PaintingDto paintingDto);
}
