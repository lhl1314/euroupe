package com.ouqicha.europebusiness.util;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/2/14 0014
 * Time:10:58
 */
public class Page<T>{
    private Integer pageIndex;
    private Integer pageTotal;
    private Integer start;
    private Integer end;
    private List<T>list;

    public Page() {
    }

    public Page(Integer pageIndex, Integer pageTotal, Integer start, Integer end, List<T> list) {
        this.pageIndex = pageIndex;
        this.pageTotal = pageTotal;
        this.start = start;
        this.end = end;
        this.list = list;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
//    public Page<T> setPage(int pageIndex, int pageCount, List<T>list){
//        Page page = new Page();
//        page.setPageIndex(pageIndex);
//        page.setPageTotal(pageCount);
//        page.setList(list);
//        int start = pageIndex - 4;//使得数据左边有四个，右边有四个
//        if (start < 0) {
//            start = 0;
//        }
//        int end = start + 8;
//        if (end > page.getPageTotal()) {
//            end = page.getPageTotal();
//        }
//        int seven = 8;
//        while (end - start < seven) {
//            if (start > 0) {
//                start--;
//            }
//            if (start == 0) {
//                break;
//            }
//        }
//        page.setStart(start);
//        page.setEnd(end);
//        return page;
//    }
}
