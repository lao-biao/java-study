package com.study.springbootsolr.controller;

import com.study.springbootsolr.service.SolrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 周超
 * @title SolrController
 * @date 2020/8/18 13:36
 * @description 测试solr的增删改查
 */
@RestController
@RequestMapping("/test")
public class SolrController {

    @Autowired
    private SolrService solrService;

    @PostMapping("/solr")
    public String testSolrAdd() {
        return solrService.add();
    }

    @PutMapping("/solr")
    public String testSolrUpdate() {
        return solrService.update();
    }

    @DeleteMapping("/solr")
    public String testSolrDelete() {
        return solrService.delete();
    }

    @GetMapping("/solr/{page}/{size}")
    public String testSolrSearch(@PathVariable("page") int page,
                                 @PathVariable("size") int size,
                                 @RequestParam("keyword") String keyword) {
        return solrService.search(keyword, page, size);
    }
}
