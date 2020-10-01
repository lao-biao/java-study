package com.study.springbootsolr.pojo;

import org.apache.solr.client.solrj.beans.Field;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 周超
 * @title SolrSearchResult
 * @date 2020/8/18 13:52
 * @description
 */
public class SolrSearchResult implements Serializable {

    @Field("id")
    private String id;
    @Field("article_content")
    private String content;
    @Field("article_create_time")
    private Date createTime;
    @Field("article_labels")
    private String labels;
    @Field("article_title")
    private String title;

    public SolrSearchResult() {

    }

    @Override
    public String toString() {
        return "SolrSearchResult{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                ", labels='" + labels + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getLabels() {
        return labels;
    }

    public void setLabels(String labels) {
        this.labels = labels;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
