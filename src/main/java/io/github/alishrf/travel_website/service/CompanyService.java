package io.github.alishrf.travel_website.service;

import io.github.alishrf.travel_website.model.Company;
import io.github.alishrf.travel_website.repository.CompanyRepository;

import org.springframework.http.ResponseEntity;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;



public class CompanyService {

    private Logger logger =Logger.getLogger("My Company Service");

    public List<Company> getAllCompanies(CompanyRepository companyRepository){
        List<Company> companies = companyRepository.findAll();
        if(companies == null){
            companies = new ArrayList<>();
        }
        logger.info("Show All Companies");
        return companies ;
    }

    public Company getCompanyById(Long id,CompanyRepository companyRepository){
        Company company = companyRepository.findById(id).orElse(null);
        if(company == null){
            logger.warning("Your Company Id Is Not Available");
            //handle error & throw ex
        }
        return company;


    }

    public Company CreateCompany(Company company,CompanyRepository companyRepository){
        if(companyRepository.findByNameContaining(company.getName()) != null){
            logger.warning("This Company name is already available");
            return null;
        }
        if(company.getName().length()<2 || company.getName().length() >50){
            logger.warning("Company name is too short or too long");
            return null;
        }
        if(company.getDescription() == null){
            company.setDescription("");
        }
        if(company.getImgLogo()==null){
            logger.warning("Company logo is null");
            return null;
        }
        return companyRepository.save(company);
    }


    public ResponseEntity<?> deleteCompany(Long id, CompanyRepository companyRepository){
        Company company = companyRepository.findById(id).orElse(null);
        if(company == null){
            logger.warning("Your Company Id Is Not Available");
            //handle error & throw ex
        }
        companyRepository.delete(company);
        return ResponseEntity.status(200).build();
    }

}
