package com.example.catalogservice.service;

import com.example.catalogservice.dto.CatalogDto;
import com.example.catalogservice.entity.CatalogEntity;
import com.example.catalogservice.vo.ResponseCatalog;

import java.util.List;

public interface CatalogService {

    List<ResponseCatalog> getAllCatalogs();
}
