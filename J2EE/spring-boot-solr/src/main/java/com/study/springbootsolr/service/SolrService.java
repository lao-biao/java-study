package com.study.springbootsolr.service;

import com.google.gson.Gson;
import com.study.springbootsolr.pojo.PageList;
import com.study.springbootsolr.pojo.SolrSearchResult;
import org.apache.http.util.TextUtils;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author 周超
 * @title SolrService
 * @date 2020/8/18 13:37
 * @description
 */
@Service
public class SolrService {

    @Autowired
    private SolrClient solrClient;

    public String add() {
        SolrInputDocument doc = new SolrInputDocument();
        doc.addField("id", "730469770008199168");
        doc.addField("article_title", "SpringBoot中使用Solr作为搜索引擎");
        doc.addField("article_content", "这是测试solr添加的文章内容。");
        doc.addField("article_create_time", new Date());
        doc.addField("article_labels", "后端-测试-solr");
        try {
            solrClient.add(doc);
            solrClient.commit();
        } catch (SolrServerException | IOException e) {
            e.printStackTrace();
            return "文章添加失败";
        }
        return "文章添加成功";
    }

    public String update() {
        SolrInputDocument doc = new SolrInputDocument();
        doc.addField("id", "730469770008199168");
        doc.addField("article_title", "SpringBoot中使用Solr作为搜索引擎");
        doc.addField("article_content", "<p>文章更新，这是测试solr更新的文章内容。</p>");
        doc.addField("article_create_time", new Date());
        doc.addField("article_labels", "后端-测试-solr");
        try {
            solrClient.add(doc);
            solrClient.commit();
        } catch (SolrServerException | IOException e) {
            e.printStackTrace();
            return "文章更新失败";
        }
        return "文章更新成功";
    }

    public String delete() {
        try {
            // 单独删除一条记录
            solrClient.deleteById("730469770008199168");
            // 提交
            solrClient.commit();
        } catch (SolrServerException | IOException e) {
            e.printStackTrace();
            return "文章删除失败";
        }
        return "文章删除成功";
    }


    public String search(String keyword, int page, int size) {
        // 参数检查
        if (page < 1) page = 1;
        if (size < 5) size = 5;

        // 分页设置
        SolrQuery solrQuery = new SolrQuery();
        solrQuery.setRows(size);    // 每页数量
        solrQuery.setStart(size * (page - 1));   // 设置开始位置

        // 设置搜索条件
        solrQuery.set("df", "search_item"); //  设置搜索关键字：标题，内容，标签
        solrQuery.set("q", TextUtils.isEmpty(keyword) ? "*" : keyword); // 条件过滤

        // 时间的降序
        solrQuery.setSort("article_create_time", SolrQuery.ORDER.desc);

        solrQuery.setHighlight(true);   // 开启高亮
        solrQuery.addHighlightField("article_title,article_content"); // 高亮字段
        solrQuery.setHighlightSimplePre("<font color='red'>");  // 高亮前缀
        solrQuery.setHighlightSimplePost("</font>");            // 高亮后缀
        solrQuery.setHighlightFragsize(400);    // 设置字符数

        // 设置返回字段
        solrQuery.addField("id,article_content,article_create_time,article_labels,article_title");

        // 处理搜索结果
        try {
            QueryResponse result = solrClient.query(solrQuery);
            // 获取高亮内容
            Map<String, Map<String, List<String>>> highlighting = result.getHighlighting();
            // 把数据转换成bean类
            List<SolrSearchResult> beans = result.getBeans(SolrSearchResult.class);
            for (SolrSearchResult item : beans) {
                Map<String, List<String>> stringListMap = highlighting.get(item.getId());
                if (stringListMap == null) continue;
                List<String> title = stringListMap.get("article_title");
                // 替换文章标题为高亮
                if (title != null) {
                    item.setTitle(title.get(0));
                }
                List<String> content = stringListMap.get("article_content");
                // 替换文章内容为高亮
                if (content != null) {
                    item.setContent(content.get(0));
                }
            }
            // 封装结果：列表，页面，每页数量
            PageList<SolrSearchResult> pageList = new PageList<>();
            pageList.setContent(beans);
            pageList.setCurrentPage(page);
            pageList.setTotalCount(result.getResults().getNumFound());
            pageList.setPageSize(size);
            pageList.setTotalPage((int) (pageList.getTotalCount() / size + 0.5));
            pageList.setFirst(pageList.getCurrentPage() == 1);
            pageList.setLast(pageList.getCurrentPage() == pageList.getTotalPage());
            // 返回搜索结果
            Gson gson = new Gson();
            return gson.toJson(pageList);
        } catch (SolrServerException | IOException e) {
            e.printStackTrace();
        }
        return "搜索失败，请稍后重试！";
    }
}
