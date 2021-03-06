package my.examples.studymanager.repository;

import my.examples.studymanager.domain.Message;
import my.examples.studymanager.repository.MessageRepository;
import my.examples.studymanager.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
//@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class MessageRepositoryTest {
    @Autowired
    MessageRepository messageRepository;
    @Autowired
    UserRepository userRepository;

    //메시지 상세 내용 조회(한 건)
    @Test
    public void getMessage(){
        System.out.println(messageRepository.findById(1L).get().getMessageContent());
    }
//
//    //메시지 삭제
//    @Test
//    @Rollback(false)
//    public void deleteMessage(){
//        messageRepository.deleteById(7L);
//    }
//
//    //유저의 메시지 조회
//    @Test
//    public void getMessageByUser(){
//        List<Message> messages = messageRepository.getMessageByUser(4L);
//        for(Message message : messages){
//            System.out.println(message.getMessageContent());
//        }
//    }
//
//    //모집 중 스터디 작성자의 메시지에 메시지를 추가
//    // -addMessage(userId, userId, Message)
//    @Test
//    @Rollback(false)
//    public void addmessage(){
//        Message message = new Message();
//        message.setMessageContent("test message");
//        message.setUser(userRepository.findById(3L).get());
//        message.setUser1(userRepository.getOne(2L));
//        messageRepository.save(message);
//    }
}