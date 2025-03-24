package com.tuna.gomen.mail;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MailRepository extends JpaRepository<Mail, Integer> {
    // Sender가 보낸 쪽지 조회
    List<Mail> findBySenderId(Integer senderId);

    // Receiver가 받은 쪽지 조회
    List<Mail> findByReceiverId(Integer receiverId);
}

