package spring.annotation.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @auther 陈郑游
 * @create 2016-12-02-23:24
 * @功能描述
 * @公司地址
 */

@Service(value ="userServiceDao" )
public class UserServiceDao {

	@Autowired
	private UserDao userDao;

	public void add(){

		System.out.println("UserServiceDao.........add!");

		userDao.addDao();
	}
}
