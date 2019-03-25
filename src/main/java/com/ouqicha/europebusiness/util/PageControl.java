package com.ouqicha.europebusiness.util;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/2/14 0014
 * Time:11:03
 */
public class PageControl<T> {
    public Page<T> setPage(int pageIndex, int pageCount, List<T>list){
        Page page = new Page();
        page.setPageIndex(pageIndex);
        page.setPageTotal(pageCount);
        page.setList(list);
        int start = pageIndex - 4;//使得数据左边有四个，右边有四个
        if (start < 0) {
            start = 0;
        }
        int end = start + 8;
        if (end > page.getPageTotal()) {
            end = page.getPageTotal();
        }
        int seven = 8;
        while (end - start < seven) {
            if (start > 0) {
                start--;
            }
            if (start == 0) {
                break;
            }
        }
        page.setStart(start);
        page.setEnd(end);
        return page;
    }
}
