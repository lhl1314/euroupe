package com.ouqicha.europebusiness.util;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.dozer.Mapper;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * @author Administrator   sk9TbyJ3y/ZNZdLyO1Oigg==

 */
public class Utils {
    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        System.out.println(encoderByMd5("abc"));
        System.out.println(encoderByMd5("1234"));
    }
    public static String getUUID() {
        //随机生成UUID
        return UUID.randomUUID().toString().replace("-", "");
    }
    public static String encoderByMd5(String str)
            throws NoSuchAlgorithmException, UnsupportedEncodingException {
        //确定计算方法
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        //加密后的字符串
        String result = base64en.encode(md5.digest(str.getBytes("utf-8")));
        return result;
    }




    /**
     * 上传单个文件方法
     * @param request
     * @param file
     * @return
     * @throws IOException
     */
    public static boolean uploadOneFile(HttpServletRequest request, @RequestParam("file") MultipartFile file) throws IOException {
        if (!file.isEmpty()) { //如果文件不为空，写入上传路径
            String path = request.getSession().getServletContext().getRealPath("/images/upload"); //上传文件路径
            //文件原始名字
            String filename = file.getOriginalFilename();
            String suffixLast = filename.substring(filename.lastIndexOf("."));  //获取文件后缀
            String newFileName = Utils.getUUID()+suffixLast;     //文件新名字
            File filepath = new File(path, newFileName);
            ////判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            //将上传文件保存到一个目标文件当中
            file.transferTo(new File(path + File.separator + newFileName));
            String imageUrl="/images/upload/"+newFileName;
            request.getSession().setAttribute("imageUploadUrl",imageUrl);
            return true;
        }
        return false;
    }
    /**
     * 上传多个文件方法
     * @param request
     * @param files
     * @return
     */
    public static boolean uploadManyFiles(
            HttpServletRequest request,
            @RequestParam("files") MultipartFile[] files){
        String path = request.getSession().getServletContext().getRealPath("/images/upload");
        try {
//            System.out.println("上传数组图片的长度是"+files.length);
            if (files.length!=0){
                String s="";
                for (int i = 0; i < files.length; i++) {
                    /**
                     * 必须进行判断，否则数组会越界
                     */
                    if (files[i].isEmpty()){
                        return false;
                    }
                    //文件原始名字
                    String filename = files[i].getOriginalFilename();
                    //获取文件后缀
                    String suffixLast = filename.substring(filename.lastIndexOf("."));

                    //文件新名字
                    String newFileName = Utils.getUUID()+suffixLast;
                    File filepath = new File(path, newFileName);
                    if (!filepath.getParentFile().exists()) {
                        filepath.getParentFile().mkdirs();
                    }
                    files[i].transferTo(new File(path + File.separator + newFileName));
                    s+="/images/upload/"+newFileName+"-";
                }
                System.out.println("这是我的图片拼接成的数组字符"+s);
                request.getSession().setAttribute("imageUploadUrl",s);
                return true;
            }
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 正则校验是否是邮箱格式的字符串
     * @param email
     * @return
     */
    public static boolean checkEmail(String email)
    {
        try{
            String regex1 = "[a-zA-Z_0-9]+@[a-zA-Z_0-9]{2,6}(\\.[a-zA-Z_0-9]{2,3})+";
            return email.matches(regex1);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    /***
     * 生成六位数的随机数
     * @return
     */
    public static String getRandNumbers() {
        Random random = new Random();
        String result = "";
        int number = 6;
        for (int i = 0; i < number; i++) {
            result += random.nextInt(10);
        }
        return result;
    }

    /**
     * 封装dozer处理集合的方法：List<S> --> List<T>
     */
    public static <T, S> List<T> setDozerList(final Mapper mapper, List<S> sourceList, Class<T> targetObjectClass) {
        List<T> targetList = new ArrayList<T>();
        for (S s : sourceList) {
            T vo = mapper.map(s, targetObjectClass);
            targetList.add(vo);
        }
        return targetList;
    }


//    public void getShiroSession(String sessionId){
//        Subject subject = SecurityUtils.getSubject();
//        Serializable id = subject.getSession().getId();
//        if (id.toString().equals(sessionId)){
//            //返回数据。如果没有
//        }else {
//            //看数据库中有没有，是否是过期，有，获取账户，后台登录
//        }
//    }
}
