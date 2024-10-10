package com.gallery.galleryDemo.controller;

import com.gallery.galleryDemo.dto.PaintingDto;
import com.gallery.galleryDemo.model.Painting;
import com.gallery.galleryDemo.service.PaintingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class PaintingController {

    @Autowired
    private final PaintingService service;

    @GetMapping("/get")
    public List<PaintingDto> getAllPaintings(){
        return service.getAllPaintings();
    }

    @GetMapping("/get/{id}")
    public PaintingDto getPainting(@PathVariable String id) {
        return service.getPaintingDto(id);
    }

    @PostMapping("/post")
    public Painting createPainting(@RequestBody Painting painting) {
        return service.createPainting(painting);
    }

    @DeleteMapping("/delete/{id}")
    public Painting deletePainting(@PathVariable String id) {
        return service.deletePainting(id);
    }

    @PutMapping("/update/{id}")
    public Painting updatePainting(@PathVariable String id, @RequestBody Painting painting) {
        // Ensure the ID in the request body matches the path variable ID
        if (!id.equals(painting.getId())) {
            throw new IllegalArgumentException("ID in path does not match ID in request body");
        }
        return service.updatePainting(painting);
    }

}
