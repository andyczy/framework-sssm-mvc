package spring.annotation.user;

import org.springframework.stereotype.Component;

/**
 * @auther 陈郑游
 * @create 2016-12-02-23:05
 * @功能描述 注解开发
 * @公司地址 @Component(value = "user")
 */

@Component(value = "user")
public class User {
	public void add(){
		System.out.println("annotation.........add!");
	}
}
