package com.tuna.gomen.bookMarkandLike.controller;

import com.tuna.gomen.bookMarkandLike.dto.BookmarkedBoardDto;
import com.tuna.gomen.bookMarkandLike.service.BookmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookmarks")
public class BookmarkController {

    private final BookmarkService bookmarkService;

    @Autowired
    public BookmarkController(BookmarkService bookmarkService) {
        this.bookmarkService = bookmarkService;
    }

    // 특정 사용자가 북마크한 게시글 조회 API
    @GetMapping("/{userId}")
    public List<BookmarkedBoardDto> getBookmarkedBoards(@PathVariable Long userId) {
        return bookmarkService.getBookmarkedPostsByUserId(userId);
    }
}

