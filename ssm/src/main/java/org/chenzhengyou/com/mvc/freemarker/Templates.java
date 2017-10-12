package org.chenzhengyou.com.mvc.freemarker;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;


import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * @auther 陈郑游
 * @create 2016/12/28 0028
 * @功能 freemarker学习
 * @问题
 * @说明
 * @URL地址
 * @进度描述
 */
public class Templates {


    @Test
    public void hello() {
        try {

            //创建Freemarker配置实例
            Configuration cfg = new Configuration();
            //加载目录
//            cfg.setDirectoryForTemplateLoading(new File("hello"));
            cfg.setObjectWrapper(new DefaultObjectWrapper());
            cfg.setTemplateLoader(new ClassTemplateLoader(Templates.class, "/freemarker"));
            //创建数据模型
            Map map = new HashMap();
            map.put("user", "andyCZY");

            //加载模板文件
            Template templates = cfg.getTemplate("index.ftl");

            //显示生成的数据,将合并后的数据打印到控制台
            Writer out = new OutputStreamWriter(System.out);
            templates.process(map, out);
            out.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }

    }
}
