package org.chenzhengyou.com.ssm.common.utils.InterceptorLogin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by czy on 2016/11/5.
 * 登陆认证拦截器
 */

@Controller
public class LoginContrller {



	@RequestMapping("/logintest")
	public String login(){
		return "login/login";
	}


    // 登陆
    @RequestMapping("/login")
    public String login(HttpSession session, String username, String password)
            throws Exception {

        // 调用service进行用户身份验证
        // ...

        // 在session中保存用户身份信息
        session.setAttribute("username", username);
        // 重定向到商品列表页面
        return "redirect:/items/queryItems.action";
    }

    // 退出
    @RequestMapping("/logout")
    public String logout(HttpSession session) throws Exception {

        // 清除session
        session.invalidate();

        // 重定向到商品列表页面
        return "redirect:/items/queryItems.action";
    }
}
