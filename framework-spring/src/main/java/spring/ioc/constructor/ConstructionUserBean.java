package spring.ioc.constructor;

/**
 * @auther 陈郑游
 * @create 2016-12-01-21:56
 * @功能描述 有参构造注入
 * @公司地址
 */

public class ConstructionUserBean {

	private String name;

	public ConstructionUserBean(String name) {
		this.name = name;
	}

	public void beanTest(){
		System.out.println("UserBean注入值："+name);
	}

}
