package com.tuna.gomen.mail;

import com.tuna.gomen.mapper.MailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailService {

    @Autowired
    private MailRepository mailRepository;

    @Autowired
    private MailMapper mailMapper;

    // 쪽지 보내기 (JPA 사용)
    public void sendMail(Integer senderId, Integer receiverId, String content) {
        Mail mail = new Mail();
        mail.setSenderId(senderId);
        mail.setReceiverId(receiverId);
        mail.setContent(content);
        mailRepository.save(mail); // JPA 쪽지 저장
    }

    // Sender가 보낸 쪽지 조회
    public List<Mail> getSentMails(Integer senderId) {
        return mailMapper.selectSentMails(senderId); // MyBatis 사용
    }

    // Receiver가 받은 쪽지 조회
    public List<Mail> getReceivedMails(Integer receiverId) {
        return mailMapper.selectReceivedMails(receiverId); // MyBatis 사용
    }
}
