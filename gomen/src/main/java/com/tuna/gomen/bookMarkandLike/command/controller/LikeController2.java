package com.tuna.gomen.bookMarkandLike.command.controller;


import com.tuna.gomen.bookMarkandLike.command.dto.LikeDTO;
import com.tuna.gomen.bookMarkandLike.command.entity.Like;
import com.tuna.gomen.bookMarkandLike.command.service.LikeService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gomen/like")
public class LikeController2 {

    private final LikeService2 likeService2;

    @Autowired
    public LikeController2(LikeService2 likeService2) {
        this.likeService2 = likeService2;
    }

    @PostMapping("/add")
// URL: http://localhost:8080/gomen/like/add
    public LikeDTO addLike(@RequestBody Like request) {
        System.out.println("컨트롤러: Received postId: " + request.getPostId());

        if (request.getPostId() == null) {
            throw new IllegalArgumentException("Post ID cannot be null");
        }

        return likeService2.addLike(request.getUserId(), request.getPostId());
    }


    @DeleteMapping("/remove")
    //http://localhost:8080/gomen/like/remove?userId=숫자&postId=숫자(db에 존재하는 데이터 아니면 오류뜸)
    public ResponseEntity<String> removeLike(@RequestParam Integer userId, @RequestParam Integer postId) {
        likeService2.removeLike(userId, postId);
        return ResponseEntity.ok("Like removed successfully");
    }

}