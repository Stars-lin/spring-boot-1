package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.dzkj.App;
import com.dzkj.pojo.Commodity;
import com.dzkj.service.ICommodityService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class ApplicationTest {
	
	@Autowired
	ICommodityService commo; 
	@Autowired
	Map<String, Object> map;
	
	Random rd = new Random();
	
    @Before
    public void init() {
    	System.out.println("开始测试");
    }
    
    @Test
    public void test() {
    	//第一层商品显示
  	  List<Commodity> commodities1 = commo.findByTwo(1);
  	  List<Commodity> arr_one = new ArrayList<Commodity>();
  	  arr_one.add(commodities1.get(rd.nextInt(commodities1.size()-1)));
  	  while (true) {
  		  Commodity commodity = commodities1.get(rd.nextInt(commodities1.size()-1));
			for (int i = 0; i < arr_one.size(); i++) {
				if (commodity.getS_id() == arr_one.get(i).getS_id()) {
					break;
				}
				if (i == arr_one.size()-1) {
					arr_one.add(commodity);
				}
			}
			if (arr_one.size()>=6) {
				break;
			  }
		}
  	  System.out.println(arr_one);
    }
    
    @After
    public void after() {
    	System.out.println("测试结束");
    }
}
