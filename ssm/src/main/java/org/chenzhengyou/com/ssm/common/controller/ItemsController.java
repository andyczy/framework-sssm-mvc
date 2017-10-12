package org.chenzhengyou.com.ssm.common.controller;

import org.chenzhengyou.com.ssm.common.pojo.ItemsCustom;
import org.chenzhengyou.com.ssm.common.pojo.ItemsQueryVo;
import org.chenzhengyou.com.ssm.common.service.ItemsService;
import org.chenzhengyou.com.ssm.common.utils.exceptionData.CustomException;
import org.chenzhengyou.com.ssm.common.utils.validation.Validation01;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * Title: ItemsController
 * Description:商品的controller
 * <p>
 *1、基本操作
 *2、restful架构
 */
//为了对url进行分类管理 ，可以在这里定义根路径，最终访问url是根路径+子路径
//比如：商品列表：/items/queryItems.action
@Controller
@RequestMapping("/items")
public class ItemsController {

    @Autowired
    private ItemsService itemsService ;

    // 商品查询
    @RequestMapping("/queryItems")
    public ModelAndView queryItems(ItemsQueryVo itemsQueryVo) throws Exception {


        // 调用service查找 数据库，查询商品列表
        List<ItemsCustom> itemsList = itemsService.findItemsList(itemsQueryVo);

        // 返回ModelAndView
        ModelAndView modelAndView = new ModelAndView();
        // 相当 于request的setAttribut，在jsp页面中通过itemsList取数据
        modelAndView.addObject("itemsList", itemsList);

        // 指定视图
        // 下边的路径，如果在视图解析器中配置jsp路径的前缀和jsp路径的后缀，修改为
        // modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp");
        // 上边的路径配置可以不在程序中指定jsp路径的前缀和jsp路径的后缀
        modelAndView.setViewName("items/itemsList");

        return modelAndView;

    }


    /**
    * @RequestParam里边指定request传入参数名称和形参进行绑定。
    * 通过required属性指定参数是否必须要传入
    * 通过defaultValue可以设置默认值，如果id参数没有传入，将默认值和形参绑定。
    * */
    @RequestMapping(value = "/editItems", method = {RequestMethod.POST, RequestMethod.GET})
    public String editItems(Model model, @RequestParam(value = "id", required = true) Integer items_id)
            throws Exception {

        //调用service根据商品id查询商品信息
        ItemsCustom itemsCustom = itemsService.findItemsById(items_id);

        /**
         * 异常处理
         */
        if (itemsCustom == null) {
            throw new CustomException("修改的商品信息不存在!");
        }
        //通过形参中的model将model数据传到页面
        //相当于modelAndView.addObject方法
        model.addAttribute("itemsCustom", itemsCustom);

        return "items/editItems";
    }


    // 商品信息修改提交
    // 1、在需要校验的pojo前边添加@Validated，在需要校验的pojo后边添加BindingResult
    // bindingResult接收校验出错信息
    // 注意：@Validated和BindingResult bindingResult是配对出现，并且形参顺序是固定的（一前一后）。
    // value={ValidGroup1.class}指定使用ValidGroup1 分组的校验
    // validated:没有获取到对应的错误信息、键值对的问题
    // 2、@ModelAttribute可以指定pojo回显到页面在request中的key
    // 3、Exception处理
    /**
     * @param model
     * @param bindingResult  校验
     * @param id
     * @param items_pic      图片参数
     * @param itemsCustom
     * */
    @RequestMapping("/updateItemsSubmit")
    public String updateItemsSubmit(Model model,
                                    Integer id,
                                    @Validated(value = {Validation01.class}) ItemsCustom itemsCustom,
                                    BindingResult bindingResult,
                                    MultipartFile items_pic) throws Exception {

        // 获取校验错误信息、异常处理
        if (bindingResult.hasErrors()) {
            // 输出错误信息
            List<ObjectError> allErrors = bindingResult.getAllErrors();

            for (ObjectError objectError : allErrors) {
                // 输出错误信息
                System.out.println("输出错误信息:" + objectError.getDefaultMessage());
            }
            // 将错误信息传到页面
            model.addAttribute("allErrors", allErrors);
            // 出错重新到商品修改页面
            return "items/editItems";
        }


        //原始的名字
        String fileName = items_pic.getOriginalFilename();

        //图片上传
        if(items_pic !=null && fileName !=null && fileName.length()>0){
            //获取物理路径（已经配置好、在tomcat的service.xml文件）
            String path_pic = "E:\\JavaEE_develop_img\\udpload\\temp\\";
            //新的名字
            String new_fileName = UUID.randomUUID() + fileName.substring(fileName.lastIndexOf("."));
            //新图片
            File file = new File(path_pic + new_fileName);
            //将内存中的数据写入磁盘
            items_pic.transferTo(file);
            //将新图片名称写到itemsCustom中
            itemsCustom.setPic(new_fileName);
        }

        //调用service更新商品信息，页面需要将商品信息传到此方法
        itemsService.updateItems(id, itemsCustom);
        return "items/success";
    }


    /* 批量删除商品信息   ----还没实现 */
    /* 批量删除是页面选择多个参数id、成一个数组 */
    @RequestMapping("/deleteItems")
    public String deleteItems(Integer[] items_id) throws Exception {

        //调用service、还没写
        itemsService.deleteItems(items_id);
        return "items/success";
    }


    /*
    * 批量修改、显示（商品查询）
    * */
    @RequestMapping(value = "/editItemsQueryItems", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView editItemsQueryItems(ItemsQueryVo itemsQueryVo) throws Exception {

        // 调用service查找 数据库，查询商品列表
        List<ItemsCustom> itemsList = itemsService.findItemsList(itemsQueryVo);

        // 返回ModelAndView
        ModelAndView modelAndView = new ModelAndView();
        // 相当 于request的setAttribut，在jsp页面中通过itemsList取数据
        modelAndView.addObject("itemsList", itemsList);
        modelAndView.setViewName("items/editItemsQueryItems");

        return modelAndView;

    }

    //批量修改、提交        controller写完、内部还没实现----还没实现
    @RequestMapping("/editItemsAllSubmit")
    public String editItemsAllSubmit(ItemsQueryVo itemsQueryVo) throws Exception {

//        itemsService.
        return "items/success";
    }

	//很麻烦、一般不用吧！
    /*RESTful架构，就是目前最流行的一种互联网软件架构。它结构清晰、符合标准、易于理解、扩展方便，所以正得到越来越多网站的采用。*/
	//RESTful:查询商品信息，输出json
	///itemsView/{id}里边的{id}表示占位符，通过@PathVariable获取占位符中的参数，
	//如果占位符中的名称和形参名一致，在@PathVariable可以不指定名称
	//url路径：http://localhost:8080/SSmvc-M/items/itemsView/1
	@RequestMapping("/itemsView/{id}")
	public @ResponseBody
	ItemsCustom itemsView(@PathVariable("id") Integer id)throws Exception{

		//调用service查询商品信息
		ItemsCustom itemsCustom = itemsService.findItemsById(id);
		return itemsCustom;
	}
}
