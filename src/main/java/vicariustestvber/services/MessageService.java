package vicariustestvber.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import vicariustestvber.models.Message;
import vicariustestvber.repositories.MessageRepository;

public class MessageService {
  @Autowired
  private MessageRepository messageRepository;
  
  public Optional<Message> findByMessageId(String id) {
    return messageRepository.findById(id);
  }
  public <S extends Message> S save(S entity) {
    return messageRepository.save(entity);
  }
}
