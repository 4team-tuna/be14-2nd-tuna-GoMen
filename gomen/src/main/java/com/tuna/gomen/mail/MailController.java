package com.tuna.gomen.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gomen/mail")
public class MailController {

    @Autowired
    private MailService mailService;

    // 쪽지 보내기
    //
    @PostMapping("/send")
    public void sendMail(@RequestParam Integer senderId,
                         @RequestParam Integer receiverId,
                         @RequestParam String content) {

        mailService.sendMail(senderId, receiverId, content);
    }

    // Sender가 보낸 쪽지 조회
    @GetMapping("/sent/{senderId}")
    public List<Mail> getSentMails(@PathVariable Integer senderId) {
        return mailService.getSentMails(senderId);
    }

    // Receiver가 받은 쪽지 조회
    @GetMapping("/received/{receiverId}")
    public List<Mail> getReceivedMails(@PathVariable Integer receiverId) {
        return mailService.getReceivedMails(receiverId);
    }
}
