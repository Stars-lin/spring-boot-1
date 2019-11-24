package com.dzkj.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dzkj.pojo.Commodity;
import com.dzkj.service.ICommodityService;
import com.dzkj.service.ISTopThreeService;

@Controller
public class SearchController {

	@Autowired
	ICommodityService commodityService;
	@Autowired
	ISTopThreeService isTopThreeService;

	// 三级导航条查询
	@RequestMapping("/classify")
	public String findbyclass(Map<String, Object> map,
			@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
			@RequestParam(name = "s_three_id", required = false) Integer s_three_id,
			@RequestParam(name = "index_none_header_sysc", required = false) String like) {
		// 查询总数
		List<Commodity> arr_total;
		// 分页查询数据
		List<Commodity> arr;
        //查询根据
		map.put("s_three_id", s_three_id);
		map.put("like", like);
		
		if ("".equals(like)) {
			map.put("like", null);
		}
		if (s_three_id != null) {
			map.put("like", isTopThreeService.findById(s_three_id).getS_three_name());
		}
		arr_total = commodityService.findbylike(map);
		// 页码数据量
		Integer pageSize = 12;
		// 总页数
		Integer number_tatol = 0;
		// 判断总页数是否够放
		if (arr_total.size() % pageSize == 0) {
			number_tatol = arr_total.size()/pageSize;
		} else {
			number_tatol = arr_total.size()/pageSize + 1;
		}
		// 判断页码是否越界
		if (pageNum < 1)
			pageNum = 1;
		if (pageNum > number_tatol)
			pageNum = number_tatol;

		// 分页
		arr = commodityService.findbylike_page(map, pageNum, pageSize);
		map.put("arr", arr);
		map.put("pageNum", pageNum);
		map.put("number_tatol", number_tatol);
		return "home/search";
	}

}
