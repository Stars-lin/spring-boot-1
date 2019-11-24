package com.dzkj.service.imp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dzkj.mapper.ICommodityMapper;
import com.dzkj.pojo.Commodity;
import com.dzkj.service.ICommodityService;
import com.github.pagehelper.PageHelper;

@Service
@Transactional
public class CommodityService implements ICommodityService{
    @Autowired
    ICommodityMapper commodityMapper;

    //搜索框查询所有
	@Override
	public List<Commodity> findbylike(Map<String, Object> map) {
		Object like = map.get("like");
		if(like != null) {
			map.put("like", "%"+like+"%");
		}
		return commodityMapper.find(map);
	}

	//搜索栏分页
	@Override
	public List<Commodity> findbylike_page(Map<String, Object> map, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return commodityMapper.find(map);
	}

	//根据二级id查商品
	@Override
	public List<Commodity> findByTwo(Integer id) {
		return commodityMapper.findByTwo(id);
	}

	//根据id查商品
	@Override
	public Commodity findById(Integer s_id) {
		return commodityMapper.selectByPrimaryKey(s_id);
	}

	@Override
	public List<Commodity> findByThreeId(Integer s_three_id) {
		return commodityMapper.findByThreeId(s_three_id);
	}

	@Override
	public boolean updbyid(Commodity commodity) {
		return commodityMapper.updateByPrimaryKey(commodity)>0;
	}

	@Override
	public List<Commodity> findbysale() {
		return commodityMapper.findbysale();
	}
    
}
