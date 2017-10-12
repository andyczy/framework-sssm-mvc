package cn.com.czy.mybatis.one.mapper;

import cn.com.czy.mybatis.pojo.User;

import java.util.List;

/**
 * 总结：
 * 1、mapper代理方式、理解mapper开发规范 
 * 2、mapper文件是userMapper.xml
 * 3、了解动态sql、别名、sql代码片、
 * 4、了解  resultMap
 * 
 * <p>
 * Title: UserMapper
 * </p>
 * <p>
 * Description: mapper接口，相当于dao接口，用户管理
 * </p>
 */
public interface UserMapper {

	// 根据id查询用户信息
	public User findUserById(int id) throws Exception;

	// 根据用户名列查询用户列表
	public List<User> findUserByName(String name) throws Exception;

	// 根据id查询用户信息，使用resultMap输出
	public User findUserByIdResultMap(int id) throws Exception;

	// 用户信息综合查询
	public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;

	// 用户信息综合查询总数
	public int findUserCount(UserQueryVo userQueryVo) throws Exception;

	// 插入用户
	public void insertUser(User user) throws Exception;

	// 删除用户
	public void deleteUser(int id) throws Exception;

}
