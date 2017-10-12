package spring.mail;

/**
 * @auther 陈郑游
 * @时间 2017/5/23 0023
 * @功能
 * @问题
 * @博客地址：http://blog.csdn.net/javawebrookie
 * @GitHub地址：https://github.com/AndyCZY
 * @GitBook地址：https://www.gitbook.com/@chenzhengyou
 */
public class SpringMailSenderTest {

    public static void main(String[] args) throws Exception {
        SpringMailSender m = new SpringMailSender();
        m.richContentSend();
        System.out.println("发送成功!");
    }
}
