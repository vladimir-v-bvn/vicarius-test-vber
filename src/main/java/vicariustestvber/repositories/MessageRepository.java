package vicariustestvber.repositories;

import java.util.Optional;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import vicariustestvber.models.Message;

@Repository
public interface MessageRepository extends ElasticsearchRepository<Message, String> {
  Optional<Message> findById(String id);
  <S extends Message> S save(S entity);
  }

