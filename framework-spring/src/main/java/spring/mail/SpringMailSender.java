package spring.mail;

import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.velocity.VelocityEngineFactoryBean;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @auther 陈郑游
 * @时间 2017/5/23 0023
 * @功能
 * @问题
 * @博客地址：http://blog.csdn.net/javawebrookie
 * @GitHub地址：https://github.com/AndyCZY
 * @GitBook地址：https://www.gitbook.com/@chenzhengyou
 */
public class SpringMailSender {

    // Spring的邮件工具类，实现了MailSender和JavaMailSender接口
    private JavaMailSenderImpl mailSender;




    /**
     * 创建邮件发送器
     */
    public SpringMailSender() {
        // 初始化JavaMailSenderImpl，当然推荐在spring配置文件中配置，这里是为了简单
        mailSender = new JavaMailSenderImpl();
        // 设置参数
        mailSender.setHost("smtp.qq.com");
        mailSender.setUsername("649954910@qq.com");
        mailSender.setPassword("czy940726");
    }

    /**
     * 方法名: simpleSend
     * 方法作用: TODO 简单邮件发送
     *
     * @param @throws Exception
     *                返回值类型： void
     * @throws
     */
    public void simpleSend() throws Exception {
        // 构建简单邮件对象
        //SimpleMailMessages实现了MimeMessageHelper，为普通邮件模板，支持文本。
        SimpleMailMessage smm = new SimpleMailMessage();
        // 设定邮件参数
        smm.setFrom(mailSender.getUsername());
        smm.setTo("chenzyou@163.com");
        smm.setSubject("Hello world");
        smm.setText("this is test spring mail !");
        // 发送邮件
        mailSender.send(smm);
    }




    /**
     * 方法名: attachedSend
     * 方法作用: TODO 带附件的邮件发送
     *
     * @param @throws MessagingException
     *                返回值类型： void
     * @throws
     */
    public void attachedSend() throws MessagingException {
        //使用JavaMail的MimeMessage，支付更加复杂的邮件格式和内容
        //MimeMessages为复杂邮件模板，支持文本、附件、html、图片等。
        MimeMessage msg = mailSender.createMimeMessage();
        //创建MimeMessageHelper对象，处理MimeMessage的辅助类
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        //使用辅助类MimeMessage设定参数
        helper.setFrom(mailSender.getUsername());
        helper.setTo("234567890@qq.com");
        helper.setSubject("Hello Attachment");
        helper.setText("This is a mail with attachment");
        //加载文件资源，作为附件
        //文件地址相对应src目录
        ClassPathResource file = new ClassPathResource("ehcache.xsd");
        //加入附件
        helper.addAttachment("ehcache.xsd", file);

        //发送邮件
        mailSender.send(msg);
    }

    /**
     * 方法名: richContentSend
     * 方法作用: TODO 发送富文本邮件
     *
     * @param @throws MessagingException
     *                返回值类型： void
     * @throws
     */
    public void richContentSend() throws MessagingException {
        MimeMessage msg = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(msg, true);

        helper.setFrom(mailSender.getUsername());
        helper.setTo("234567890@qq.com");
        helper.setSubject("邮件标题");
        //第二个参数true，表示text的内容为html，然后注意<img/>标签，src='cid:file'，'cid'是contentId的缩写，'file'是一个标记，
        //需要在后面的代码中调用MimeMessageHelper的addInline方法替代成文件
        helper.setText(
                "<body><p style='color:red;'>Hello Html Email</p><img src='cid:file'/></body>",
                true);
        //文件地址相对应src目录
        ClassPathResource file = new ClassPathResource("logo.png");
        //文件地址对应系统目录
//        FileSystemResource file = new FileSystemResource("C:\\Users\\HIYOUNG\\Desktop\\logo.png");
        helper.addInline("file", file);

        mailSender.send(msg);
    }


}
