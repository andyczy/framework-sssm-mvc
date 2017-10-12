package cn.com.czy.mybatis.one.mapper;


/**
 * 总结：
 * 1、mapper代理方式、理解mapper开发规范 
 * 2、mapper文件是userMapper.xml
 * 3、了解动态sql、别名、sql代码片、
 * 4、了解  resultMap
 * 
 * <p>Title: UserQueryVo</p>
 * <p>Description:包装类型 </p>
 */
public class UserQueryVo {

	//在这里包装所需要的查询条件
	//用户查询条件
	private UserCustom userCustom;

	public UserCustom getUserCustom() {
		return userCustom;
	}

	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}

	//可以包装其它的查询条件，订单、商品
	//....
}
