package com.tuna.gomen.user.controller;

import com.tuna.gomen.user.dto.UserDTO;
import com.tuna.gomen.user.vo.RequestQuitVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.tuna.gomen.user.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/gomen/user")
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

    @PostMapping("/regist")
    public ResponseEntity<UserDTO> registUser(@RequestBody UserDTO userDTO) {

//        try {
        userService.registUser(userDTO);
//        } catch (Exception e) {
//            throw new RuntimeException("계정 생성 과정에서 오류.");
//        }

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userDTO);
    }

    @PostMapping("/quit")
    public ResponseEntity<RequestQuitVO> quitUser(@RequestBody RequestQuitVO quitVO){
        try {
            userService.quitUser(quitVO);
        } catch (Exception e){
            throw new RuntimeException("회원 탈퇴 과정 중 오류 발생");
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(quitVO);
    }

    @PostMapping("/delete")
    public ResponseEntity<RequestQuitVO> deleteUser(@RequestBody RequestQuitVO quitVO){
        try {
            userService.deleteUser(quitVO);
        } catch (Exception e) {
            throw new RuntimeException("회원 삭제에서 오류 발생");
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(quitVO);
    }
}

