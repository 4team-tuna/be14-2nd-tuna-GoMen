package com.tuna.userservice.query.controller;

import com.tuna.userservice.query.dto.UserQueryDTO;
import com.tuna.userservice.query.service.UserQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserQueryController {
    private UserQueryService userService;

    @Autowired
    public UserQueryController(UserQueryService userService) {
        this.userService = userService;
    }

    @RequestMapping("/selectAll")
    public List<UserQueryDTO> selectAllUsers() {
        List<UserQueryDTO> users = userService.selectAllUsers();
//        users.forEach(System.out::println);
        return users;
    }

    @RequestMapping("/findUserByUserId")
    public UserQueryDTO findUserByUserId(@RequestParam("userId") int userId) {
        UserQueryDTO foundUser = userService.selectUserByUserId(userId);
        return foundUser;
    }

    @RequestMapping("/findUserPasswordByLoginId")
    public String findUserPasswordByLoginId(@RequestParam("loginId") String loginId) {
        UserQueryDTO foundUser = userService.selectUserByLoginId(loginId);
        return foundUser.getPassword();
    }

    @RequestMapping("/findUserByNickname")
    public List<UserQueryDTO> findUserByNickname(@RequestParam("nickname") String nickname) {
        List<UserQueryDTO> users = userService.selectUserByNickname(nickname);
        return users;
    }

    @RequestMapping("/findUserNicknameByPostId")
    public String findUserNicknameByPostId(@RequestParam("postId") int postId) {
        UserQueryDTO foundUser = userService.selectUserByPostId(postId);
        return foundUser.getNickname();
    }

    @RequestMapping("/findUserNicknameByCommentId")
    public String findUserNicknameByCommentId(@RequestParam("commentId") int commentId) {
        UserQueryDTO foundUser = userService.selectUserByCommentId(commentId);
        return foundUser.getNickname();
    }

    @RequestMapping("/findUserNicknameByQuestionId")
    public String findUserNicknameByQuestionId(@RequestParam("questionId") int questionId) {
        UserQueryDTO foundUser = userService.selectUserByQuestionId(questionId);
        return foundUser.getNickname();
    }

    @RequestMapping("/findUserNicknameByAnswerId")
    public String findUserNicknameByAnswerId(@RequestParam("answerId") int answerId) {
        UserQueryDTO foundUser = userService.selectUserByAnswerId(answerId);
        return foundUser.getNickname();
    }

    @RequestMapping("/findUserIsMentorByNickname")
    public String findUserIsMentorByNickname(@RequestParam("nickname") String nickname) {
        List<UserQueryDTO> users = userService.selectUserByNickname(nickname);
        for (UserQueryDTO user : users) {
            if (nickname.equals(user.getNickname())) {
                return user.getIsMentor();
            }
        }
        return "없는 닉네임입니다.";
    }
}

