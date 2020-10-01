package com.study.springbootsolr.pojo;

import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;

/**
 * @author 周超
 * @title PageList
 * @date 2020/8/18 13:57
 * @description
 */
public class PageList<T> implements Serializable {

    private long currentPage;   // 当前页码
    private long totalCount;    // 总共有多少条
    private long pageSize;      // 每页内容量
    private long totalPage;     // 总页数
    private boolean first;  // 是否是第一页
    private boolean last;   // 是否是最后一页
    private List<T> content;   // 内容

    public PageList() {
    }

    @Override
    public String toString() {
        return "PageList{" +
                "currentPage=" + currentPage +
                ", totalCount=" + totalCount +
                ", pageSize=" + pageSize +
                ", totalPage=" + totalPage +
                ", first=" + first +
                ", last=" + last +
                ", content=" + content +
                '}';
    }

    public long getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(long currentPage) {
        this.currentPage = currentPage;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }
}
