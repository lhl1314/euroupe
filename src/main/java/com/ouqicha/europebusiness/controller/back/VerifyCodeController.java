package com.ouqicha.europebusiness.controller.back;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 验证码生成与校验
 */
@Controller
@RequestMapping(value = "/login")
public class VerifyCodeController {

    /**
     * 生成验证码
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/authCode")
    public void getAuthCode(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int width = 63;
        int height = 37;
        Random random = new Random();
        //设置response头信息
        //禁止缓存
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        //生成缓冲区image类
        BufferedImage image = new BufferedImage(width, height, 1);
        //产生image类的Graphics用于绘制操作
        Graphics g = image.getGraphics();
        //Graphics类的样式
        g.setColor(this.getRandColor(200, 250));
        g.setFont(new Font("Times New Roman", 0, 28));
        g.fillRect(0, 0, width, height);
        //绘制干扰线
        int line = 40;
        for (int i = 0; i < line; i++) {
            g.setColor(this.getRandColor(130, 200));
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int x1 = random.nextInt(12);
            int y1 = random.nextInt(12);
            g.drawLine(x, y, x + x1, y + y1);
        }
        int charNumber = 4;
        //绘制字符
        String strCode = "";
        for (int i = 0; i < charNumber; i++) {
            String rand = String.valueOf(random.nextInt(10));
            strCode = strCode + rand;
            g.setColor(
                    new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
            g.drawString(rand, 13 * i + 6, 28);
        }
        //将字符保存到session中用于前端的验证
        request.getSession().setAttribute("strCode",strCode);

        g.dispose();

        ImageIO.write(image, "JPEG", response.getOutputStream());
        response.getOutputStream().flush();
    }

    /**
     * //创建颜色
     */
    Color getRandColor(int fc, int bc) {
        Random random = new Random();
        int color = 255;
        if (fc > color) {
            fc = 255;
        }
        if (bc > color) {
            bc = 255;
        }
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }

    /**
     * 校验验证码是否正确
     *
     * @param value
     * @param request
     * @return
     */
    @RequestMapping(value = "/validate")
    @ResponseBody
    public String validate(String value, HttpServletRequest request) {
        String valueCode = (String) request.getSession().getAttribute("strCode");

        if (valueCode != null) {
            if (valueCode.equals(value)) {
                return String.valueOf(1);//验证码正确
            }
        }
        return String.valueOf(-1);//验证码错误
    }
}
