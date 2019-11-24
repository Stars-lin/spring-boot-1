package com.dzkj.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dzkj.mapper.IShopcarMapper;
import com.dzkj.pojo.Shopcart;
import com.dzkj.service.IShopcarService;

@Service
@Transactional
public class ShopcarService implements IShopcarService{
    
	@Autowired
	IShopcarMapper shopcarMapper;

	@Override
	public boolean add(Shopcart shopcart) {
		return shopcarMapper.add(shopcart)>0;
	}

	@Override
	public Shopcart findone(Shopcart shopcart) {
		return shopcarMapper.findone(shopcart);
	}

	@Override
	public boolean upd(Shopcart shopcart) {
		return shopcarMapper.upd(shopcart)>0;
	}

	@Override
	public List<Shopcart> findall(Integer u_id) {
		return shopcarMapper.findall(u_id);
	}

	@Override
	public boolean delone(Integer id) {
		return shopcarMapper.delone(id)>0;
	}
	//删除多条
	@Override
	public boolean delarr(List<Integer> items) {
			for (int j = 0; j < items.size(); j++) {
					if (shopcarMapper.delone(items.get(j))<1) {
						return false;
					}
				}
		return true;
	}

	@Override
	public Shopcart findbyid(Shopcart shopcart) {
		return shopcarMapper.findbyid(shopcart.getId());
	}
	
}
