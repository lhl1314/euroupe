package com.ouqicha.europebusiness.service;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrawlerService {

    @Autowired
    CsiCrawlerCrawlerControllerFactory crawlerCrawlerControllerFactory;
//    private CrawlerDao1 crawlerDao1;
//
//    public CrawlerDao1 getCrawlerDao1() {
//        return crawlerDao1;
//    }
//
//    public void setCrawlerDao1(CrawlerDao1 crawlerDao) {
//        this.crawlerDao1 = crawlerDao;
//    }
//
//    public void saveEnour(EnuropEntity entity){
//        crawlerDao1.saveEnour(entity);
//    }

    public int startCrawler() {
        int result = 1;
        String crawlStorageFolder = "E:/crawl/root";
//        int numberOfCrawlers = 7;
//
//        CrawlConfig config = new CrawlConfig();
//        config.setCrawlStorageFolder(crawlStorageFolder);
//        config.setMaxDepthOfCrawling(1);
//
//        /*
//         * Instantiate the controller for this crawl.
//         */
//        PageFetcher pageFetcher = new PageFetcher(config);
//        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
//        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
//        CrawlController controller = null;
//        try {
//            controller = new CrawlController(config, pageFetcher, robotstxtServer);
//        } catch (Exception e) {
//            e.printStackTrace();
//            result = 0;
//        }
//
//        /*
//         * For each crawl, you need to add some seed urls. These are the first
//         * URLs that are fetched and then the crawler starts following links
//         * which are found in these pages
//         */
//        controller.addSeed("http://www.ics.uci.edu/~lopes/");
//        controller.addSeed("http://www.ics.uci.edu/~welling/");
//        controller.addSeed("http://www.ics.uci.edu/");
//
//        /*
//         * Start the crawl. This is a blocking operation, meaning that your code
//         * will reach the line after this only when crawling is finished.
//         */
//        controller.start(MyCrawler.class, numberOfCrawlers);


        int numberOfCrawlers = 7;

        CrawlConfig config = new CrawlConfig();
        config.setCrawlStorageFolder(crawlStorageFolder);
        config.setMaxDepthOfCrawling(1);
//        config.setResumableCrawling(true);

        /*
         * Instantiate the controller for this crawl.
         */
        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller = null;
        try {
            controller = new CrawlController(config, pageFetcher, robotstxtServer);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*
         * For each crawl, you need to add some seed urls. These are the first
         * URLs that are fetched and then the crawler starts following links
         * which are found in these pages
         */
//        controller.addSeed("http://www.ics.uci.edu/~lopes/");
//        controller.addSeed("http://www.ics.uci.edu/~welling/");
//        controller.addSeed("http://www.ics.uci.edu/");
//        controller.addSeed("https://blog.csdn.net/seek_of/article/details/79764122");
//        controller.addSeed("https://www.baidu.com");https://www.europages.com/
        controller.addSeed("https://www.europages.cn/%E5%86%B6%E9%87%91%E5%92%8C%E9%87%91%E5%B1%9E%E5%8A%A0%E5%B7%A5.html");//https://www.europages.com/

        /*
         * Start the crawl. This is a blocking operation, meaning that your code
         * will reach the line after this only when crawling is finished.
         */
//        controller.start(MyCrawler.class, numberOfCrawlers);
//        CsiCrawlerCrawlerControllerFactory factory = new CsiCrawlerCrawlerControllerFactory(crawlerDao1);
//        CsiCrawlerCrawlerControllerFactory factory = new CsiCrawlerCrawlerControllerFactory();
        controller.startNonBlocking(crawlerCrawlerControllerFactory, numberOfCrawlers);
        return result;
    }
}
