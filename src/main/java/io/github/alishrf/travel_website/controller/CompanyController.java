package io.github.alishrf.travel_website.controller;


import io.github.alishrf.travel_website.model.Company;
import io.github.alishrf.travel_website.repository.CompanyRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CompanyController {
    CompanyRepository companyRepository;

    @GetMapping("/")
    public List<Company> getAllCompanies(){
        companyRepository.findAll().
    }



}
