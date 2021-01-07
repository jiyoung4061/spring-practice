package com.markany.aoptest.service;

import org.springframework.stereotype.Service;

import com.markany.aoptest.main.ProductVo;

@Service
public class ProductService {
	
	public ProductVo find(String name) {
		System.out.println("[ProductService] finding...");
		
		return new ProductVo(name);
	}
}
