package org.chenzhengyou.com.mvc.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @auther 陈郑游
 * @create 2016/12/29 0029
 * @功能  SpringMVC是一个基于DispatcherServlet的MVC框架，每一个请求最先访问的都是DispatcherServlet，
 *          DispatcherServlet负责转发每一个Request请求给相应的Handler，Handler处理以后再返回相应的视图(View)和模型(Model)，
 *          返回的视图和模型都可以不指定，即可以只返回Model或只返回View或都不返回。在使用注解的SpringMVC中，处理器Handler是
 *          基于@Controller和@RequestMapping这两个注解的，@Controller声明一个处理器类，
 *          @RequestMapping声明对应请求的映射关系，这样就可以提供一个非常灵活的匹配和处理方式。
 *
 *
 * @URL地址
 * @进度描述
 */
@Controller
//@SessionAttributes({"serssionValue1","serssionValue2"})
public class JspController {

    /**说明：使用@Autowired时，如果找到多个同一类型的bean，则会抛异常，此时可以使用 @Qualifier("beanName")，
            明确指定bean的名称进行注入，此时与 @Resource指定name属性作用相同。
     @Autowired
     @Qualifier ("指定某个注入的 beanName")
     private String string;

     */


    /**
     *  //@required 负责检查一个bean在初始化时其声明的set方法是否被执行，当某个被标注了 @Required的 Setter方法没有被调用，
     *      则 Spring在解析的时候会抛出异常，以提醒开发者对相应属性进行设置。 @Required注解只能标注在 Setter方法之上。
     *      因为依赖注入的本质是检查 Setter方法是否被调用了，而不是真的去检查属性是否赋值了以及赋了什么样的值。
     *      如果将该注解标注在非 setXxxx()类型的方法则被忽略。
     *
     * */


    /** jsp模板的Controller*/
    /**
     *
     *  @params http://localhost:8081/jsp?paramsReg=11
     *
     *  @RequestParam(required=false)： 参数不是必须的，默认为true
     *  请求处理方法入参的可选类型 • Java基本数据类型和String
     *  默认情况下将按名称匹配的方式绑定到URL参数上，可以通过@RequestParam注解改变默认的绑定规则.
     *
     *  @Scope: 在使用XML定义Bean时，可以通过bean的scope 属性来定义一个Bean的作用范围，同样可以通过@Scope注解来完成。
     *  @Scope中可以指定如下值：
     *      base.dataStructure.singleton:定义bean的范围为每个spring容器一个实例（默认值）
     *      prototype:定义bean可以被多次实例化（使用一次就创建一次）
     *      request:定义bean的范围是http请求（springMVC中有效）
     *      session:定义bean的范围是http会话（springMVC中有效）
     *      global-session:定义bean的范围是全局http会话（portlet中有效）
     *
     *  @ResponseBody
    　　　　 这个注解可以直接放在方法上，表示返回类型将会直接作为HTTP响应字节。
            流输出(不被放置在Model，也不被拦截为视图页面名称)。可以用于ajax。
     * */
    @RequestMapping(value="/jsp",method={RequestMethod.GET},params = "paramsReg")
    public ModelAndView getJsp(HttpServletRequest request, String paramsReg,Model model
//                               @ModelAttribute("serssionValue2")String serssionValue,
//                               ModelMap map
    ) {
//        System.out.println("sessionValue:"+serssionValue);
//        map.addAttribute("serssionValue2","kobe");
        ModelAndView andView = new ModelAndView();
        andView.addObject("message1", "切换到jsp模板、");
        andView.addObject("message2", "My First Spring Mvc");
        andView.addObject("paramsReg",paramsReg);
        andView.setViewName("mvc/hello/hello");
        return andView;
    }


    //处理局部异常（Controller内）
    @ExceptionHandler
    public ModelAndView exceptionHandler(Exception ex){
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("exception", ex);
        System.out.println("in testExceptionHandler");
        return mv;
    }
    @RequestMapping("/error")
    public String error(){
        int i = 5/0;
        return "hello";
    }

}
