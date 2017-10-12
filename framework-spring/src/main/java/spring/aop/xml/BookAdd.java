package spring.aop.xml;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @auther 陈郑游
 * @create 2016-12-03-10:51
 * @功能描述 AOP操作
 * @公司地址
 */

public class BookAdd {

	//前置
	public void beforeAdd(){
		System.out.println("前置增强........!");
	}

	//后置
	public void afterAdd(){
		System.out.println("后置增强........!");
	}


	//环绕
	public void aroundAdd(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

		System.out.println("环绕方法之前........!");

		//执行方法
		proceedingJoinPoint.proceed();

		System.out.println("环绕方法之后........!");
	}
}
