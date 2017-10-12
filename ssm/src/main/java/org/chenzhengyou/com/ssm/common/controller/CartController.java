package org.chenzhengyou.com.ssm.common.controller;

import org.chenzhengyou.com.ssm.common.pojo.cart.Cart;
import org.chenzhengyou.com.ssm.common.pojo.cart.CartItem;
import org.chenzhengyou.com.ssm.common.pojo.ItemsCustom;
import org.chenzhengyou.com.ssm.common.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by czy on 2016/10/24.
 * 购物车例子
 *
 *
 * http://localhost:8081/SSmvc-M/cart/addIndex.action
 *
 *
 */

@RequestMapping(value = "/cart")
@Controller
public class CartController {


    @Autowired
    private ItemsService itemsService;

    @org.junit.Test
    public void test(){
        System.out.println(itemsService);
    }



    /*购物车例子测试*/
    //商品信息家加入购物车
    @RequestMapping("/addIndex")
    public String addIndex(HttpServletRequest request) throws Exception {
        //测试案例：只要访问这个方法就给一个购物车
        //最好是用户登录就给、但是我还是算了。
        request.getSession().setAttribute("cart", new Cart());
        return "items/index";
    }


    //商品信息家加入购物车
    @RequestMapping(value = "/addcartList" ,method = {RequestMethod.GET,RequestMethod.POST})
    public String addcartList(HttpServletRequest request) throws Exception {
        /*
         * 1. 得到车
		 * 2. 得到条目（得到图书和数量）
		 * 3. 把条目添加到车中
		 */
        /*
         * 1. 得到车
		 */
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        /*
         * 表单传递的只有id和数量
		 * 2. 得到条目
		 *   > 得到图书和数量
		 *   > 先得到id，然后我们需要通过id查询数据库得到商品
		 *   > 数量表单中有
		 */
        int id = Integer.parseInt(request.getParameter("id"));
        //根据id查询加载（显示）商品
        ItemsCustom itemsCustom = itemsService.findItemsById(id);
        int count = 1;
//        System.out.println("测试count:" + request.getParameter("count"));

        CartItem cartItem = new CartItem();
        cartItem.setItemsCustom(itemsCustom);
        cartItem.setCount(count);
		//3. 把条目添加到车中
        cart.add(cartItem);

        return "items/addcartList";
    }


    /**
     * 清空购物条目
     *  @param request
     *  @param model
     *  @return
     *  @throws Exception
     *
     */
    @RequestMapping(value = "deleteClear")
    public String deleteClear(Model model, HttpServletRequest request) throws Exception {
        /**
         * 1. 得到车
         * 2. 设置车的clear
         */
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        cart.clear();

        // 调用service查找 数据库，查询商品列表
        List<ItemsCustom> itemsList = itemsService.findItemsList(null);
        model.addAttribute("itemsList", itemsList);

        return "items/addcartList";
    }

    /**
     * 删除购物条目
     * @param model
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "deleteCart")
    public String delete(Model model, HttpServletRequest request) throws Exception {
        /*
         * 1. 得到车
		 * 2. 得到要删除的id
		 */
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        String id = request.getParameter("id");
        cart.delete(id);

        // 调用service查找 数据库，查询商品列表
        List<ItemsCustom> itemsList = itemsService.findItemsList(null);
        model.addAttribute("itemsList", itemsList);

        return "items/addcartList";
    }
}
