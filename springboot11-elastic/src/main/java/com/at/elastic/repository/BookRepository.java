package com.at.elastic.repository;

import com.at.elastic.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface BookRepository extends ElasticsearchRepository<Book, Integer> {
    // 参照   https://docs.spring.io/spring-data/elasticsearch/docs/current/reference/html/#reference
    List<Book> findByBookNameLike(String bookName);
}
