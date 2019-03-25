package com.ouqicha.europebusiness.controller.other;

import com.ouqicha.europebusiness.service.CrawlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class CrawlerController {

    @Autowired
    private CrawlerService crawlerService;

    @RequestMapping("/startCrawler")
    public String startCrawler() {
        System.out.println("************** startCrawler ********************");
        crawlerService.startCrawler();
        return "test1";
    }
}
