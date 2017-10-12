package spring.annotation.util;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @auther 陈郑游
 * @create 2016-12-02-23:05
 * @功能描述 注解开发
 */


@Service
//@PropertySource({"classpath:config/title.properties"})
//有它就不能加载properties配置文件
public class UserServiceImp implements UserService {
	
	@Value("${title}")
	private String title;
	
	@Override
	public void getPritn() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("spring注解开发"+title);
	}	

}
