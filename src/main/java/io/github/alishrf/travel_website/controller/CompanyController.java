package io.github.alishrf.travel_website.controller;


import io.github.alishrf.travel_website.model.Company;
import io.github.alishrf.travel_website.repository.CompanyRepository;
import io.github.alishrf.travel_website.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CompanyController {
    @Autowired
    CompanyRepository companyRepository;

    CompanyService companyService = new CompanyService();


    @GetMapping("/companies")
    public List<Company> getAllCompanies(){

        return companyService.getAllCompanies(companyRepository);
    }

    @GetMapping("/companies/{id}")
    public Company getCompanyBuId(@PathVariable(value = "id") Long id){
        return companyService.getCompanyById(id,companyRepository);
    }


    @PostMapping("/companies")
    public Company createCompany(@Valid  @RequestBody Company company){
        return companyService.CreateCompany(company,companyRepository);
    }

    @DeleteMapping("/companies/{id}")
    public ResponseEntity<?> deleteCompany(@PathVariable(value = "id")Long id){
        return companyService.deleteCompany(id,companyRepository);

    }
    



}
