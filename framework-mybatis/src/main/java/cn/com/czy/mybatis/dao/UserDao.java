package cn.com.czy.mybatis.dao;

import cn.com.czy.mybatis.pojo.User;

import java.util.List;


/**
 * 总结：
 * 1、原始的DAO处理方式
 * 2、mapper文件是userFirst.xml
 * 
 * <p>Title: UserDao</p>
 * <p>Description: dao接口，用户管理</p>
 *
 *
 * 问题总结：
 *  1、dao接口实现类方法中存在大量模板方法，设想能否将这些代码提取出来，大大减轻程序员的工作量。
 *  2、调用sqlsession方法时将statement的id硬编码了
 *  3、调用sqlsession方法时传入的变量，由于sqlsession方法使用泛型，即使变量类型传入错误，在编译阶段也不报错，不利于程序员开发。
 */
public interface UserDao {
	
	//根据id查询用户信息
	public User findUserById(int id) throws Exception;
	
	//根据用户名列查询用户列表
	public List<User> findUserByName(String name) throws Exception;
	
	//添加用户信息
	public void insertUser(User user) throws Exception;
	
	//删除用户信息
	public void deleteUser(int id) throws Exception;

}
