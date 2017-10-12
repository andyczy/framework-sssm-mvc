package spring.annotation.user;

import org.springframework.stereotype.Component;

/**
 * @auther 陈郑游
 * @create 2016-12-02-23:18
 * @功能描述 注解方式
 * @公司地址
 */

@Component(value = "userdao")
public class UserDao {

	public void addDao(){
		System.out.println("userdao............add!");

	}
}
