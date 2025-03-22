package com.tuna.gomen.bookMarkandLike.controller;

import com.tuna.gomen.bookMarkandLike.dto.BookmarkDTO;
import com.tuna.gomen.bookMarkandLike.dto.BookmarkedBoardDto;
import com.tuna.gomen.bookMarkandLike.entity.Bookmark;
import com.tuna.gomen.bookMarkandLike.service.BookmarkService;
import com.tuna.gomen.bookMarkandLike.service.BookmarkService2;
import org.springframework.beans.factory.annotation.Autowired;
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

    //    아래부터는 command

    @Autowired
    private BookmarkService2 bookmarkService2;

    @PostMapping("/add")
    public BookmarkDTO addBookmark(@RequestParam Integer userId, @RequestParam Integer postId) {

        // 디버그용 로그 출력
        System.out.println("컨트롤러: Received postId: " + postId);

        // postId가 null일 경우 예외 처리
        if (postId == null) {
            throw new IllegalArgumentException("Post ID cannot be null");
        }
        return bookmarkService2.addBookmark(userId, postId);
    }

}
