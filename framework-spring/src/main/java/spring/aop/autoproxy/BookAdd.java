package spring.aop.autoproxy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;


/**
 * @auther 陈郑游
 * @create 2016-12-03-10:51
 * @功能描述 注解AOP操作
 * @公司地址
 */

@Aspect
public class BookAdd {

	//前置
	@Before(value = "execution(* spring.aop.autoproxy.Book.*(..))")
	public void beforeAdd(){
		System.out.println("前置增强........!");
	}

	//后置
    @After(value = "execution(* spring.aop.autoproxy.Book.*(..))")
	public void afterAdd(){
		System.out.println("后置增强........!");
	}

    //环绕
    @Around(value = "execution(* spring.aop.autoproxy.Book.*(..))")
    public void aroundAdd(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        System.out.println("环绕方法之前........!");
        //执行方法
        proceedingJoinPoint.proceed();
        System.out.println("环绕方法之后........!");

    }


}
