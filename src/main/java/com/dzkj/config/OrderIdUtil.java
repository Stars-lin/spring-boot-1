package com.dzkj.config;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

/**
 * 订单生成类
 * @author 29433
 *
 */

@Component
public class OrderIdUtil {
	
	
	public String getOrderId() {
		SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMDDHHmmssSSS");
		String date = sdf.format(new Date());
		return date+(int)(Math.random()*9+1)*1000;
	}
	
	/**
	 * 获取当前时间
	 * @return
	 */
	public String getdate() {
		  //得到long类型当前时间
        long l = System.currentTimeMillis();
        //new日期对象
        Date date = new Date(l);
        //转换提日期输出格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
	}
	
}
