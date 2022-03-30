package com.at.elastic;


import com.at.elastic.bean.Article;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot11ElasticApplicationTests {
    @Autowired
    JestClient jestClient;

    @Test
    public void contextLoads() {
        // 1、给ES中索引（保存）一个文档；
        Article article = new Article();
        article.setId(1);
        article.setTitle("好消息");
        article.setAuthor("zhangsan");
        article.setContent("Hello World!");

        // 2、构建一个索引功能
        Index index = new Index.Builder(article).index("at").type("news").build();

        try {
            // 3、执行
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试搜索
     */
    @Test
    public void search() {
        // 查询表达式
        String json = "{\"query\":{\"match\":{\"content\":\"hello\"}}}";
        // 构建搜索功能
        Search search = new Search.Builder(json).addIndex("at").addType("news").build();
        try {
            // 执行
            SearchResult result = jestClient.execute(search);
            System.out.println(result.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
