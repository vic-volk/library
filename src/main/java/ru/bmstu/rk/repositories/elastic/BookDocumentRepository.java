package ru.bmstu.rk.repositories.elastic;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.stereotype.Repository;
import ru.bmstu.rk.model.Book;

@Repository
public interface BookDocumentRepository extends ElasticsearchCrudRepository<Book, String> {
}
