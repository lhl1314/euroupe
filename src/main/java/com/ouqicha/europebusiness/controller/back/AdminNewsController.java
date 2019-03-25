package com.ouqicha.europebusiness.controller.back;

import com.ouqicha.europebusiness.bean.entity.NewsEntity;
import com.ouqicha.europebusiness.bean.vo.NewsVo;
import com.ouqicha.europebusiness.service.NewsService;
import com.ouqicha.europebusiness.util.Page;
import com.ouqicha.europebusiness.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/2/26 0026
 * Time:15:42
 */
@Controller
@RequestMapping(value = "/admin/news")
public class AdminNewsController {
    @Autowired
    NewsService newsService;


    /**
     * 调往添加新闻的页面
     *
     * @return
     */
    @RequestMapping(value = "/toAddNews")
    public String toAddNews() {
        return "news/addNews";
    }

    /**
     * 添加新闻
     *
     * @param request
     * @param file
     * @param newsEntity
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/addNews")
    public String addNews(
            HttpServletRequest request,
            @RequestParam("file") MultipartFile file,
            @ModelAttribute NewsEntity newsEntity,
            Model model) throws IOException {
        boolean b = Utils.uploadOneFile(request, file);
        if (b) {
            String o = (String) request.getSession().getAttribute("imageUploadUrl");
            newsService.add(newsEntity, o);
            model.addAttribute("msg","添加新闻成功！");
            model.addAttribute("address","/admin/news/getNews");
            return "msg/msg";
        }
        model.addAttribute("msg","系统繁忙，请稍后再试");
        model.addAttribute("address","/admin/news/getNews");
        return "msg/msg";
    }
    /**
     * 获取新闻
     *
     * @param model
     * @param pageId
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/getNews")
    public String getNewsPage(Model model,
                              @RequestParam(name = "pageId", defaultValue = "1", required = true) int pageId,
                              @RequestParam(name = "pageSize", defaultValue = "4", required = false) int pageSize) {
        Page<NewsVo> page = newsService.getNewsPage(pageId, pageSize);
        model.addAttribute("page", page);
        return "news/news";
    }
    /**
     * 新闻详情
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/getNewsDetail")
    public String getNewsDetail(int id, Model model, int pageId) {
        NewsVo newsVo = newsService.getNews(id);
        model.addAttribute("newsVo", newsVo);
        model.addAttribute("pageId", pageId);
        return "news/newsDetail";
    }

    /**
     * 冻结或者解冻新闻详情
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/freezeOrUnfreezeNews")
    @ResponseBody
    public Integer freezeOrUnfreezeNews(int id) {
        newsService.freezeOrUnfreezeNews(id);
        return id;
    }

    /**
     * 删除该则新闻
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteNews")
    @ResponseBody
    public String deleteNews(int id) {
        newsService.deleteNews(id);
        return Integer.toString(id);
    }
}
