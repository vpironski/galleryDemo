package com.gallery.galleryDemo.repository;

import com.gallery.galleryDemo.model.Painting;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaintingRepo extends MongoRepository<Painting, String> {

}
