package spring.aop.autoproxy;

import org.springframework.stereotype.Component;

/**
 * @auther 陈郑游
 * @create 2016-12-03-12:00
 * @功能描述 注解开发aop
 * @公司地址
 */
@Component
public class Book {

	public void add(){
		System.out.println("正常逻辑.......book!");
	}
}
