package io.github.alishrf.travel_website.service;

import io.github.alishrf.travel_website.exception.ResourceNotFoundException;
import io.github.alishrf.travel_website.model.BusTripEntity;
import io.github.alishrf.travel_website.model.CompanyEntity;
import io.github.alishrf.travel_website.model.ImageLogoEntity;
import io.github.alishrf.travel_website.repository.BusTripRepository;
import io.github.alishrf.travel_website.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

@Service
public class ImageLogoService {

    @Autowired
    CompanyRepository companyRepository;

    Logger logger =Logger.getLogger("Image Logo Service");

    public CompanyEntity setImageLogoToBusTrip(Long id, MultipartFile multipartFile) {
        CompanyEntity companyEntity =companyRepository.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException("busTripeEntity","id",id);
        });
        if(multipartFile==null){
            logger.warning("Company logo is null");
            return null;
        }
        ImageLogoEntity imageLogoEntity = new ImageLogoEntity();
        Path path = Paths.get(Paths.get("").toAbsolutePath()+
                "/src/main/resources/static/photos/companies/"+
                companyEntity.getName()+".png");
        try {
            imageLogoEntity.setBytes(multipartFile.getBytes());
            imageLogoEntity.setPath(path.toString());
            companyEntity.setImageLogoEntity(imageLogoEntity);
            Files.write(path,imageLogoEntity.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return companyRepository.save(companyEntity);
    }
}
