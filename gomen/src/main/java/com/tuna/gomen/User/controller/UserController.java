package com.tuna.gomen.user.controller;

import com.tuna.gomen.user.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.tuna.gomen.user.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/selectAll")
    public List<UserDTO> selectAllUsers() {
        List<UserDTO> users = userService.selectAllUsers();
//        users.forEach(System.out::println);
        return users;
    }

    @RequestMapping("/findUserByUserId")
    public UserDTO findUserByUserId(@RequestParam("userId") int userId) {
        UserDTO foundUser = userService.selectUserByUserId(userId);
        return foundUser;
    }

    @RequestMapping("/findUserPasswordByLoginId")
    public String findUserPasswordByLoginId(@RequestParam("loginId") String loginId) {
        UserDTO foundUser = userService.selectUserByLoginId(loginId);
        return foundUser.getPassword();
    }

    @RequestMapping("/findUserByNickname")
    public List<UserDTO> findUserByNickname(@RequestParam("nickname") String nickname) {
        List<UserDTO> users = userService.selectUserByNickname(nickname);
        return users;
    }

    @RequestMapping("/findUserNicknameByPostId")
    public String findUserNicknameByPostId(@RequestParam("postId") int postId) {
        UserDTO foundUser = userService.selectUserByPostId(postId);
        return foundUser.getNickname();
    }

    @RequestMapping("/findUserNicknameByCommentId")
    public String findUserNicknameByCommentId(@RequestParam("commentId") int commentId) {
        UserDTO foundUser = userService.selectUserByCommentId(commentId);
        return foundUser.getNickname();
    }

    @RequestMapping("/findUserNicknameByQuestionId")
    public String findUserNicknameByQuestionId(@RequestParam("questionId") int questionId) {
        UserDTO foundUser = userService.selectUserByQuestionId(questionId);
        return foundUser.getNickname();
    }

    @RequestMapping("/findUserNicknameByAnswerId")
    public String findUserNicknameByAnswerId(@RequestParam("answerId") int answerId) {
        UserDTO foundUser = userService.selectUserByAnswerId(answerId);
        return foundUser.getNickname();
    }

    @RequestMapping("/findUserIsMentorByNickname")
    public String findUserIsMentorByNickname(@RequestParam("nickname") String nickname) {
        List<UserDTO> users = userService.selectUserByNickname(nickname);
        for (UserDTO user : users) {
            if (nickname.equals(user.getNickname())) {
                return user.getIsMentor();
            }
        }
        return "없는 닉네임입니다.";
    }
}

