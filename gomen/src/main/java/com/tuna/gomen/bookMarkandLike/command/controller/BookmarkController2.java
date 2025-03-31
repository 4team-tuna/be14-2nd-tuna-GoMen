package com.tuna.gomen.bookMarkandLike.command.controller;

import com.tuna.gomen.bookMarkandLike.command.dto.BookmarkDTO;
import com.tuna.gomen.bookMarkandLike.command.entity.Bookmark;
import com.tuna.gomen.bookMarkandLike.command.service.BookmarkService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gomen/bookmarks")
public class BookmarkController2 {

    private final BookmarkService2 bookmarkService2;

    @Autowired
    public BookmarkController2( BookmarkService2 bookmarkService2) {
        this.bookmarkService2 = bookmarkService2;
    }


    @PostMapping("/add")
// URL: http://localhost:8080/gomen/bookmarks/add
    public BookmarkDTO addBookmark(@RequestBody Bookmark request) {
        System.out.println("컨트롤러: Received postId: " + request.getPostId());

        if (request.getPostId() == null) {
            throw new IllegalArgumentException("Post ID cannot be null");
        }

        return bookmarkService2.addBookmark(request.getUserId(), request.getPostId());
    }


    @DeleteMapping("/remove")
    //http://localhost:8080/gomen/bookmarks/remove?userId=숫자&postId=숫자(db에 존재하는 데이터 아니면 오류뜸)
    public ResponseEntity<String> removeBookmark(@RequestParam Integer userId, @RequestParam Integer postId) {
        bookmarkService2.removeBookmark(userId, postId);
        return ResponseEntity.ok("Bookmark removed successfully");
    }




}
