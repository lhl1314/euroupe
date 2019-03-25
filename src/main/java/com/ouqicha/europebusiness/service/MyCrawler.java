package com.ouqicha.europebusiness.service;


import com.ouqicha.europebusiness.bean.entity.EnuropEntity;
import com.ouqicha.europebusiness.dao.CrawlerDao;
import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.SessionFactoryUtils;
import org.springframework.orm.hibernate4.SessionHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Set;
import java.util.regex.Pattern;

@Service
public class MyCrawler extends WebCrawler {

    @Autowired
    private CrawlerDao crawlerDao;
//    private CrawlerDao1 crawlerDao1;
//    private CrawlerService crawlerService;

    private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|gif|jpg"
            + "|png|mp3|mp3|zip|gz))$");
//    public CrawlerDao getCrawlerDao() {
//        return crawlerDao;
//    }

//    public void setCrawlerDao(CrawlerDao crawlerDao) {
//        this.crawlerDao = crawlerDao;
//    }

//    public MyCrawler(CrawlerDao crawlerDao){
//        this.crawlerDao = crawlerDao;
//    }

    public MyCrawler() {

    }

    /**
     * This method receives two parameters. The first parameter is the page
     * in which we have discovered this new url and the second parameter is
     * the new url. You should implement this function to specify whether
     * the given url should be crawled or not (based on your crawling logic).
     * In this example, we are instructing the crawler to ignore urls that
     * have css, js, git, ... extensions and to only accept urls that start
     * with "http://www.ics.uci.edu/". In this case, we didn't need the
     * referringPage parameter to make the decision.
     */
    @Override
    public boolean shouldVisit(Page referringPage, WebURL url) {
        String href = url.getURL().toLowerCase();
        return !FILTERS.matcher(href).matches();
//                && href.startsWith("http://www.ics.uci.edu/");
    }

    /**
     * This function is called when a page is fetched and ready
     * to be processed by your program.
     */
    @Override
    public void visit(Page page) {
        String url = page.getWebURL().getURL();
        System.out.println("URL: " + url);
        String decodeUrl = "";
        try {
            decodeUrl = URLDecoder.decode(url, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(" 解码URL: " + decodeUrl);
        if (page.getParseData() instanceof HtmlParseData) {
            HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
            String text = htmlParseData.getText();
            String html = htmlParseData.getHtml();
            Set<WebURL> links = htmlParseData.getOutgoingUrls();

            System.out.println("Text length: " + text.length());
            System.out.println("Html length: " + html.length());
            System.out.println("Number of outgoing links: " + links.size());

            if (url.contains("%E5%90%84%E4%BC%81%E4%B8%9A")) {//eg. https://www.europages.cn/%E5%90%84%E4%BC%81%E4%B8%9A/%E4%BE%BF%E6%90%BA%E5%BC%8F%E7%94%B5%E5%8A%A8%E5%B7%A5%E5%85%B7.html
                final Document doc = Jsoup.parse(html);
                Elements contents = doc.select("div[class=main-title clearfix FL]");
                if (contents.size() == 0) {
                    contents = doc.select("div[class=main-title clearfix]");
                }
//                Configuration configuration = new Configuration();
//                configuration.configure("hibernate.cfg.xml");
//                ServiceRegistry resgistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
//                SessionFactory sessionFactory = configuration.buildSessionFactory(resgistry);
//                Session session = sessionFactory.getCurrentSession();

//                ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//
//                SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
//                boolean participate = bindHibernateSessionToThread(sessionFactory);
                for (final Element c : contents) {
                    String name = c.select("a").first().attr("title");
                    System.out.println("企业名称-------》" + name);


                    EnuropEntity enuropEntity = new EnuropEntity();
                    enuropEntity.setName(name);
                    System.out.println("----saveEnour(start)---->");
                    try {
                        crawlerDao.saveEuropeCompany(enuropEntity);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
//                    if(crawlerService == null){

//                        crawlerDao  = this.beanFactory.getBean(CrawlerDao.class);

//                        Session session = sessionFactory.openSession();
//                        System.out.println("----session---->"+session);
//                        session.save(enuropEntity);

//                        crawlerService = (CrawlerService) context.getBean("crawlerService");
//                        crawlerService.saveEnour(enuropEntity);


//                    }
//                    crawlerService.saveEnour(enuropEntity);
                    System.out.println("----saveEnour(end)---->");


//                     // 图片
//                     final String img = c.select(".img img").first().attr("src");
//                     System.out.println("图片：" + img);
//
//                     // 地址
//                     final Element txt = c.select("div[class=txt]").first();
//                     final String arr1 = txt.select("h3 a").first().text();
//                     final String arr2 = txt.select("h4 a").first().text();
//                     final String arr3 = txt.select("div[class=detail]").first().text();
//
//                     final String arr = arr1.concat(arr1 + ",").concat(arr2 + ",").concat(arr3);
//                     System.out.println("地址：" + arr);
//                     // 说明
//                     final String rank = txt.select("p").first().text();
//                     System.out.println("说明：" + rank);
//                     // 价格
//                     final String pirce = c.select("p[class=price]").first().text();
//                     try {
//                             cw = new CsvWriter(new FileWriter(csv, true), ',');
//                             cw.write(img);
//                             cw.write(pirce);
//                             cw.write(arr);
//                             cw.write(rank);
//                             cw.endRecord();
//                             cw.flush();
//                             cw.close();
//                     } catch (final IOException e) {
//                             e.printStackTrace();
//                     }
                }
//                crawlerDao.closeSession();
//                closeHibernateSessionFromThread(participate, sessionFactory);
            }
            System.out.println("---------------------------------------------------------");
        }

    }
//    private BeanFactory beanFactory;
//    @Override
//    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
//        this.beanFactory = beanFactory;
//    }


    public static boolean bindHibernateSessionToThread(SessionFactory sessionFactory) {
        if (TransactionSynchronizationManager.hasResource(sessionFactory)) {
            // Do not modify the Session: just set the participate flag.
            return true;
        } else {
            Session session = sessionFactory.openSession();
            session.setFlushMode(FlushMode.MANUAL);
            SessionHolder sessionHolder = new SessionHolder(session);
            TransactionSynchronizationManager.bindResource(sessionFactory, sessionHolder);
        }

        return false;
    }

    public static void closeHibernateSessionFromThread(boolean participate, Object sessionFactory) {

        if (!participate) {
            SessionHolder sessionHolder = (SessionHolder) TransactionSynchronizationManager.unbindResource(sessionFactory);
            SessionFactoryUtils.closeSession(sessionHolder.getSession());
        }
    }


}
