package com.tuna.userservice.command.controller;

import com.tuna.userservice.command.dto.UserCommandDTO;
import com.tuna.userservice.command.service.UserCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserCommandController {
    private UserCommandService userService;

    @Autowired
    public UserCommandController(UserCommandService userService) {
        this.userService = userService;
    }

    @PostMapping("/regist")
    public ResponseEntity<UserCommandDTO> registUser(@RequestBody UserCommandDTO userCommandDTO) {

//        try {
            userService.registUser(userCommandDTO);
//        } catch (Exception e) {
//            throw new RuntimeException("계정 생성 과정에서 오류.");
//        }

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userCommandDTO);
    }

    @PatchMapping("/quit")
    public ResponseEntity<String> quitUser(@RequestParam("loginId") String loginId){
        try {
            userService.quitUser(loginId);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("이미 탈퇴한 회원입니다.");
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(loginId + "가 탈퇴 처리 되었습니다.");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUser(@RequestParam("loginId") String loginId){
        try {
            userService.deleteUser(loginId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("삭제에 실패하였습니다.");
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(loginId + "회원을 삭제하였습니다.");
    }

    @PatchMapping("/changeToMentor")
    public ResponseEntity<String> changeToMentor(@RequestParam("loginId") String loginId){
        try {
            userService.changeToMentor(loginId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("멘토로 변경에 실패하였습니다.");
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("멘토로 변경되었습니다.");
    }

    @PatchMapping("/changePassword")
    public ResponseEntity<String> changePassword(@RequestParam("loginId") String loginId,
                                                 @RequestParam("password") String password){
        try {
            userService.changePassword(loginId, password);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("비밀번호 변경에 실패하였습니다.");
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("비밀번호 변경이 완료되었습니다.");
    }

    @PatchMapping("/changeCollege")
    public ResponseEntity<String> changeCollege(@RequestParam("loginId") String loginId,
                                                @RequestParam("college") String college){
        try {
            userService.changeCollege(loginId, college);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("학력 수정에 실패하였습니다.");
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("학력 수정에 성공하였습니다.");
    }

    @PatchMapping("/changeBlog")
    public ResponseEntity<String> changeBlog(@RequestParam("loginId") String loginId,
                                             @RequestParam("blog") String blog){
        try{
            userService.changeBlog(loginId, blog);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("블로그 주소 업데이트에 실패하였습니다.");
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("블로그 주소 업데이트에 성공하였습니다.\n" + "블로그 주소 : " + blog);
    }
}

