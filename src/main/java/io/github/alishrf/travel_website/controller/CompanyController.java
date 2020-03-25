package io.github.alishrf.travel_website.controller;



import io.github.alishrf.travel_website.model.CompanyEntity;
import io.github.alishrf.travel_website.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CompanyController {
    public enum da{WINTER};


    @Autowired
    CompanyService companyService;


    @GetMapping("/companies")
    public List<CompanyEntity> getAllCompanies(){
        return companyService.getAllCompanies();
    }

    @GetMapping("/companies/{id}")
    public CompanyEntity getCompanyBuId(@PathVariable(value = "id") Long id){

        return companyService.getCompanyById(id);
    }


    @PostMapping("/companies")
    @Consumes("img/jpg")
    public CompanyEntity createCompany(@RequestParam @Valid CompanyEntity companyEntity){

        return companyService.createCompany(companyEntity);
    }

    @DeleteMapping("/companies/{id}")
    public ResponseEntity<?> deleteCompany(@PathVariable(value = "id")Long id){
        return companyService.deleteCompany(id);

    }
    



}
