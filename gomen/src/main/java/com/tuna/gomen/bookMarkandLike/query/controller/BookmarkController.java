package com.tuna.gomen.bookMarkandLike.query.controller;

import com.tuna.gomen.bookMarkandLike.query.dto.BookmarkedBoardDto;
import com.tuna.gomen.bookMarkandLike.query.service.BookmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}