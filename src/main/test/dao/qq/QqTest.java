package dao.qq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.MimeMessage;
import javax.mail.search.FlagTerm;
import java.io.File;
import java.io.IOException;
import java.security.Security;
import java.util.Enumeration;
import java.util.Properties;

import static org.apache.commons.fileupload.util.mime.MimeUtility.decodeText;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/2/18 0018
 * Time:13:21
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:qq_send_mail.xml")
public class QqTest {
    @Autowired
    JavaMailSender javaMailSender;

    /**
     * 发送带有html格式的QQ邮件
     */
    @Test
    public void sendHtml() {
        /**
         * 带html格式的qq，必须采用内联样式
         */
//        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        //发送带格式的邮件
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(message, true, "utf-8");

            helper.setFrom("1694190210@qq.com");
            helper.setTo("1694190210@qq.com");
            helper.setSubject("温州电子信息研究院科研注册");
            String text = "\t<h1 align=\"center\" style=\"color: bisque;font-size: 30px;font-weight: bold;\">欢迎注册</h1>\n" +
                    "\t\t<div style=\"width: 600px;height: 400px;line-height:250px;margin:0px auto;background: black;color: white;font-weight: bold;\">\n" +
                    "\t\t\t<h3 align=\"center\">欢迎你----欢迎你</h3>\n" +
                    "\t\t</div>";
            String text2 = "\t\t<div style=\"width: 600px;height: 400px;margin:0px auto;background: black;color: white;font-weight: bold;\">\n" +
                    "\t\t\t<h3 align=\"center\" style=\"color: darkorange;font-weight: bold;font-size: 25px;padding-top: 30px;\">欢迎来到温州电子信息研究院注册</h3>\n" +
                    "\t\t\t<ul style=\"float: left;margin-left: 100px;\">\n" +
                    "\t\t\t\t<style>\n" +
                    "\t\t\t\t\tul li{\n" +
                    "\t\t\t\t\t\theight: 40px;\n" +
                    "\t\t\t\t\t\tlist-style-type: none;\n" +
                    "\t\t\t\t\t}\n" +
                    "\t\t\t\t</style>\n" +
                    "\t\t\t\t<li>文件</li>\n" +
                    "\t\t\t\t<li>编辑</li>\n" +
                    "\t\t\t\t<li>插入</li>\n" +
                    "\t\t\t\t<li>转入</li>\n" +
                    "\t\t\t</ul>\n" +
                    "\t\t\t<ul style=\"list-style: none;float: right;margin-right: 100px;\">\n" +
                    "\t\t\t\t<li>文件</li>\n" +
                    "\t\t\t\t<li>编辑</li>\n" +
                    "\t\t\t\t<li>插入</li>\n" +
                    "\t\t\t\t<li>转入</li>\n" +
                    "\t\t\t</ul>\n" +
                    "\t\t</div>";

            String text3 = "\t\t\t\t<!-- 新 Bootstrap 核心 CSS 文件 -->\n" +
                    "\t\t<link href=\"https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css\" rel=\"stylesheet\">\n" +
                    "\n" +
                    "\t\t<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->\n" +
                    "\t\t<script src=\"https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js\"></script>\n" +
                    "\n" +
                    "\t\t<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->\n" +
                    "\t\t<script src=\"https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n" +
                    "\n" +
                    "<h2>创建模态框（Modal）</h2>\n" +
                    "<!-- 按钮触发模态框 -->\n" +
                    "<button class=\"btn btn-primary btn-lg\" data-toggle=\"modal\" data-target=\"#myModal\">\n" +
                    "\t开始演示模态框\n" +
                    "</button>\n" +
                    "<!-- 模态框（Modal） -->\n" +
                    "<div class=\"modal fade\" id=\"myModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\n" +
                    "\t<div class=\"modal-dialog\">\n" +
                    "\t\t<div class=\"modal-content\">\n" +
                    "\t\t\t<div class=\"modal-header\">\n" +
                    "\t\t\t\t<button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">\n" +
                    "\t\t\t\t\t&times;\n" +
                    "\t\t\t\t</button>\n" +
                    "\t\t\t\t<h4 class=\"modal-title\" id=\"myModalLabel\">\n" +
                    "\t\t\t\t\t模态框（Modal）标题\n" +
                    "\t\t\t\t</h4>\n" +
                    "\t\t\t</div>\n" +
                    "\t\t\t<div class=\"modal-body\">\n" +
                    "\t\t\t\t在这里添加一些文本\n" +
                    "\t\t\t</div>\n" +
                    "\t\t\t<div class=\"modal-footer\">\n" +
                    "\t\t\t\t<button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">关闭\n" +
                    "\t\t\t\t</button>\n" +
                    "\t\t\t\t<button type=\"button\" class=\"btn btn-primary\">\n" +
                    "\t\t\t\t\t提交更改\n" +
                    "\t\t\t\t</button>\n" +
                    "\t\t\t</div>\n" +
                    "\t\t</div><!-- /.modal-content -->\n" +
                    "\t</div><!-- /.modal -->\n" +
                    "</div>\n" +
                    "\t\t";
            helper.setText(text2, true);   //内容 带浮动的html，只要内联样式都可以
//            helper.setText(text3,true);//引入外部css失败，样式显示失败
            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public void sendEmail(String sendTo,String subject,String content){
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(message, true, "utf-8");
            helper.setFrom("1694190210@qq.com");
            helper.setTo(sendTo);
            helper.setSubject(subject);
            helper.setText(content, true);   //内容 带浮动的html，只要内联样式都可以
            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
