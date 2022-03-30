package com.at.elastic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot默认支持两种技术来和ES交互；
 * 1、Jest（默认不生效）
 *      需要导入jest的工具包（io.searchbox.client.JestClient）
 * 2、SpringData ElasticSearch
 *      1）、Client节点信息clusterNodes；clusterName
 *      2）、ElasticSearchTemplate操作ES；
 *      3）、编写一个ElasticsearchRepository的子接口来操作ES；
 */
@SpringBootApplication
public class Springboot11ElasticApplication {
    public static void main(String[] args) {
        SpringApplication.run(Springboot11ElasticApplication.class, args);
    }
}
