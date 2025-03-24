package com.tuna.gomen.mapper;

import com.tuna.gomen.mail.Mail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MailMapper {

    // Sender가 보낸 쪽지 조회
    List<Mail> selectSentMails(Integer senderId);

    // Receiver가 받은 쪽지 조회
    List<Mail> selectReceivedMails(Integer receiverId);

    // 쪽지 보내기
    void sendMail(Mail mail);
}
