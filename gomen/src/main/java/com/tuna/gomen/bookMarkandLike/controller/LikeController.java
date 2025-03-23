package com.tuna.gomen.bookMarkandLike.controller;


import com.tuna.gomen.bookMarkandLike.dto.LikeDTO;
import com.tuna.gomen.bookMarkandLike.entity.Like;
import com.tuna.gomen.bookMarkandLike.service.LikeService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gomen/like")
public class LikeController {

//    private final LikeService likeService;
//
//    @Autowired
//    public BookmarkController(BookmarkService bookmarkService) {
//        this.bookmarkService = bookmarkService;
//    }
//
//    // 특정 사용자가 북마크한 게시글 조회 API
//    @GetMapping("/{userId}")
//    public List<BookmarkedBoardDto> getBookmarkedBoards(@PathVariable Integer userId) {
//        return bookmarkService.getBookmarkedPostsByUserId(userId);
//    }

    /// /////////////////////////////////////////////////
    /// //////////////////////////////////////////
    /// //////////////////////////////////////////////////
    /// ///////////////////////////////////////////////////////////////////
    //    아래부터는 command

    @Autowired
    private LikeService2 likeService2;

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