package com.dzkj.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dzkj.mapper.IProductImageMapper;
import com.dzkj.pojo.Productimage;
import com.dzkj.service.IProductImageService;

@Service
@Transactional
public class ProductImageService implements IProductImageService{
	
	@Autowired
	IProductImageMapper imagemapper;

	@Override
	public Productimage findByS_id(Integer s_id) {
		Productimage pImage = new Productimage();
		pImage.setS_id(s_id);
		return imagemapper.selectOne(pImage);
	}

}
