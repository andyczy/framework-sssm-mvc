package org.chenzhengyou.com.ssm.common.utils.exceptionData;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by czy on 2016/10/29.<br>
 * Spring的处理器异常解析器 HandlerExceptionResolver 接口的实现负责处理各类控制器执行过
 * 程中出现的异常。<br>
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {

    /**
     * @param httpServletRequest
     * @param httpServletResponse
     * @param e
     * @param o
     * <br>复写父类方法
     */
    public ModelAndView resolveException(HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse,
                                         Object o, Exception e) {

        //解析出异常类型
        //如果该 异常类型是系统 自定义的异常，直接取出异常信息，在错误页面展示
        CustomException customException = null;
        if (e instanceof CustomException) {
            customException = (CustomException) e;
        } else {
            //如果该异常类型不是系统、自定义的异常，构造一个自定义的异常类型（信息为“未知错误”）
            customException = new CustomException("未知异常信息！");
        }

        //错误信息
        String message = customException.getMessage();
        ModelAndView modelAndView = new ModelAndView();
        //将错误信息传到页面
        modelAndView.addObject("message", message);
        //指向错误页面
        modelAndView.setViewName("items-jsp/error");
        return modelAndView;
    }
}
