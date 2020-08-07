package io.github.alishrf.travel_website.controller;


import io.github.alishrf.travel_website.model.DFileEntity;
import io.github.alishrf.travel_website.service.DFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController("/api")
public class UploadFileController {
    @Autowired
    private DFileService dFileService;


    @PostMapping("/uploadFile")
    public String saveFile(@RequestBody MultipartFile file){
        DFileEntity fileEntity = new DFileEntity();
        try {
            fileEntity = dFileService.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "localhost:8080/api/files/"+fileEntity.getId();
    }

    @GetMapping("/files/{fid}")
    public ResponseEntity<Resource> downloadFile(@PathVariable("fid")Long fid) {
        DFileEntity fileEntity = new DFileEntity();
        fileEntity = dFileService.findById(fid);

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE,"image/png").body(new ByteArrayResource(fileEntity.getData()));
    }

}
