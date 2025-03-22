package com.tuna.gomen.bookMarkandLike.controller;

import com.tuna.gomen.bookMarkandLike.dto.BookmarkDTO;
import com.tuna.gomen.bookMarkandLike.dto.BookmarkedBoardDto;
import com.tuna.gomen.bookMarkandLike.entity.Bookmark;
import com.tuna.gomen.bookMarkandLike.service.BookmarkService;
import com.tuna.gomen.bookMarkandLike.service.BookmarkService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gomen/bookmarks")
public class BookmarkController {

    private final BookmarkService bookmarkService;

    @Autowired
    public BookmarkController(BookmarkService bookmarkService) {
        this.bookmarkService = bookmarkService;
    }

    // 특정 사용자가 북마크한 게시글 조회 API
    @GetMapping("/{userId}")
    public List<BookmarkedBoardDto> getBookmarkedBoards(@PathVariable Integer userId) {
        return bookmarkService.getBookmarkedPostsByUserId(userId);
    }

    /// /////////////////////////////////////////////////
    /// //////////////////////////////////////////
    /// //////////////////////////////////////////////////
    /// ///////////////////////////////////////////////////////////////////
    //    아래부터는 command

    @Autowired
    private BookmarkService2 bookmarkService2;

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


    @DeleteMapping("/remove")
    //http://localhost:8080/gomen/bookmarks/remove?userId=숫자&postId=숫자(db에 존재하는 데이터 아니면 오류뜸)
    public ResponseEntity<String> removeBookmark(@RequestParam Integer userId, @RequestParam Integer postId) {
        bookmarkService2.removeBookmark(userId, postId);
        return ResponseEntity.ok("Bookmark removed successfully");
    }

}
