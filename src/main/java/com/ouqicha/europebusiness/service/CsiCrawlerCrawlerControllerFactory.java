package com.ouqicha.europebusiness.service;

import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CsiCrawlerCrawlerControllerFactory implements CrawlController.WebCrawlerFactory {

    Map<String, String> metadata;
    @Autowired
    MyCrawler myCrawler;
//    CrawlerDao1 crawlerDao1;

//    public CsiCrawlerCrawlerControllerFactory(CrawlerDao1 crawlerDao1) {
//        this.metadata = metadata;
//        this.crawlerDao1 = crawlerDao1;
//    }

    public CsiCrawlerCrawlerControllerFactory() {
        this.metadata = metadata;
    }


    @Override
    public WebCrawler newInstance() throws Exception {
        return myCrawler;
    }
}
