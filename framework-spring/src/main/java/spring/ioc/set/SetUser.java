package spring.ioc.set;

/**
 * @auther 陈郑游
 * @create 2016-12-01-22:01
 * @功能描述 set注入
 * @公司地址
 */

public class SetUser {

	private String name;

	public void setName(String name) {
		this.name = name;
	}

	public void userSetTest(){
		System.out.println("UserSet注入值："+name);
	}

}
