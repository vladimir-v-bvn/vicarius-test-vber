package vicariustestvber.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import vicariustestvber.models.Message;
import vicariustestvber.services.MessageService;

@RestController
@RequestMapping("/message")
@Slf4j
public class MessageController {
  
  private  MessageService messageService;

  @Autowired
  public MessageController(MessageService messageService) { 
      this.messageService = messageService;
  }
  
  @GetMapping("/{messageId}")
  @ResponseBody
  public ResponseEntity<String> findById(@PathVariable String messageId) {                         
    return ResponseEntity.status(HttpStatus.OK).header("Custom-Header", "").body(
        messageService.findByMessageId(messageId).get().toString());
  }
  
  @PostMapping("/save")
  @ResponseBody
  public void save(@RequestBody Message message) {                         
    messageService.save(message);
  }

}
