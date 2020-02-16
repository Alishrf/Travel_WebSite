package io.github.alishrf.travel_website.controller;


import io.github.alishrf.travel_website.model.CompanyEntity;
import io.github.alishrf.travel_website.service.ImageLogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/companies/")
public class CompanyImageLogoController {
    @Autowired
    ImageLogoService imageLogoService;

    @PostMapping("{id}/uploadimagelogo")
    public CompanyEntity saveCompanyImageLogo(@PathVariable("id") Long id,
                                              @RequestBody MultipartFile multipartFile){

        return imageLogoService.setImageLogoToBusTrip(id,multipartFile);
    }
}
