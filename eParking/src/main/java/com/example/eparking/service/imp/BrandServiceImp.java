package com.example.eparking.service.imp;

import com.example.eparking.model.Brand;
import com.example.eparking.repository.BrandRepository;
import com.example.eparking.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImp implements BrandService {

    @Autowired
    BrandRepository brandRepository;

    @Override
    public List<Brand> getListBrand() {
        return brandRepository.findAll();
    }
}
