package io.github.alishrf.travel_website.service;

import io.github.alishrf.travel_website.exception.ResourceNotFoundException;
import io.github.alishrf.travel_website.model.DFileEntity;
import io.github.alishrf.travel_website.repository.DFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class DFileService {
    @Autowired
    private DFileRepository repository;


    public DFileEntity save(MultipartFile file) throws IOException {

        DFileEntity dFileEntity = new DFileEntity();
        dFileEntity.setData(file.getBytes());
        dFileEntity.setFileName(file.getName());
        dFileEntity.setFileType(file.getContentType());
        return repository.save(dFileEntity);
    }

    public DFileEntity findById(Long fid) {
        Optional<DFileEntity> byId = repository.findById(fid);
        return byId.orElseThrow(() -> new ResourceNotFoundException("File", "id", fid));
    }


}
