package io.github.alishrf.travel_website.service;


import io.github.alishrf.travel_website.model.CompanyEntity;
import io.github.alishrf.travel_website.repository.CompanyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


@Service
public class CompanyService {

    private Logger logger =Logger.getLogger("My Company Service");

    @Autowired
    private CompanyRepository companyRepository;


    public List<CompanyEntity> getAllCompanies(){
        List<CompanyEntity> companies = companyRepository.findAll();
        if(companies == null){
            companies = new ArrayList<>();
        }
        logger.info("Show All Companies");
        return companies ;
    }

    public CompanyEntity getCompanyById(Long id){
        CompanyEntity companyEntity = companyRepository.findById(id).orElse(null);
        if(companyEntity == null){
            logger.warning("Your Company Id Is Not Available");
            //handle error & throw ex
        }
        return companyEntity;


    }

    public CompanyEntity createCompany(CompanyEntity companyEntity) {
        if(companyRepository.findByNameContaining(companyEntity.getName()) != null){
            logger.warning("This Company name is already available");
            return null;
        }
        if(companyEntity.getName().length()<2 || companyEntity.getName().length() >50){
            logger.warning("Company name is too short or too long");
            return null;
        }
        if(companyEntity.getDescription() == null){
            companyEntity.setDescription("");
        }



        return companyRepository.save(companyEntity);
    }


    public ResponseEntity<?> deleteCompany(Long id){
        CompanyEntity companyEntity = companyRepository.findById(id).orElse(null);
        if(companyEntity == null){
            logger.warning("Your Company Id Is Not Available");
            //handle error & throw ex
        }
        companyRepository.delete(companyEntity);
        return ResponseEntity.status(200).build();
    }

}
