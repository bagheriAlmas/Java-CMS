package com.example.javacms.controller;
import com.example.javacms.entity.dto.MediaRequestDto;
import com.example.javacms.entity.dto.MediaResponseDto;
import com.example.javacms.service.MediaService;
import com.example.javacms.service.MediaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/media")
@RequiredArgsConstructor
public class MediaController {

    private final MediaService mediaService;

    @GetMapping
    ResponseEntity<List<MediaResponseDto>> getAllMedias() {
        return ResponseEntity.status(HttpStatus.OK).body(mediaService.findAll());
    }

    @GetMapping("{id}")
    ResponseEntity<MediaResponseDto> getMediaById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(mediaService.findById(id));
    }

    @PostMapping
    ResponseEntity<Void> insertMedia(@RequestBody @Valid MediaRequestDto requestDto) {
        mediaService.save(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("{id}")
    ResponseEntity<Void> updateMedia(@PathVariable("id") Long id, @RequestBody @Valid MediaRequestDto requestDto) {
        mediaService.update(id, requestDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("{id}")
    ResponseEntity<Void> deleteMedia(@PathVariable("id") Long id) {
        mediaService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
