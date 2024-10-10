package com.gallery.galleryDemo.service;

import com.gallery.galleryDemo.config.PaintingMapper;
import com.gallery.galleryDemo.dto.PaintingDto;
import com.gallery.galleryDemo.model.Painting;
import com.gallery.galleryDemo.repository.PaintingRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaintingService {
    @Autowired
    private final MongoTemplate mongoTemplate;

    private final PaintingRepo repo;

    public List<PaintingDto> getAllPaintings() {
        List<Painting> paintings = mongoTemplate.findAll(Painting.class, "paintings");
        List<PaintingDto> paintingDTOs = paintings.stream()
                .map(painting -> PaintingMapper.INSTANCE.paintingToPaintingDto(painting))
                .collect(Collectors.toList());
        System.out.println(paintings);
        return paintingDTOs;
    }

    public PaintingDto getPaintingDto(String id) {
        Painting painting = mongoTemplate.findById(id,Painting.class);
        return PaintingMapper.INSTANCE.paintingToPaintingDto(painting);
    }

    public Painting createPainting(Painting painting) {
        return mongoTemplate.save(painting);
    }

    public Painting deletePainting(String id){
        Query query = new Query(Criteria.where("id").is(id));
        Painting painting = mongoTemplate.findOne(query, Painting.class);
        if (painting != null) {
            mongoTemplate.remove(painting);
        }
        return painting;
    }

    public Painting updatePainting(Painting newPainting){
        Query query = new Query(Criteria.where("id").is(newPainting.getId()));
        Update update = new Update()
                .set("name",newPainting.getName())
                .set("artist",newPainting.getArtist())
                .set("description",newPainting.getDescription());

        mongoTemplate.updateFirst(query, update, Painting.class);
        return newPainting;

    }
}
