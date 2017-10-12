package org.chenzhengyou.com.ssm.common.springmvc.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther 陈郑游
 * @Data 2017/8/12 0012
 * @Description:
 * @CSDN:http://blog.csdn.net/javawebrookie
 * @GITHUB:https://github.com/AndyCZY
 */

@Controller
public class FreemarkerController {

    //http://127.0.0.1:8081/welcomeFreemarker
    /**Freemarker模板的Controller*/
    @RequestMapping(value="/welcomeFreemarker",method={RequestMethod.GET})
    public ModelAndView getFirstPage(HttpServletRequest request) {
        //welcom就是视图的名称（welcom.ftl）
        ModelAndView mv = new ModelAndView("welcome");
        mv.addObject("name", "My First Spring Mvc and Freemarker !");
        return mv;
    }
}
