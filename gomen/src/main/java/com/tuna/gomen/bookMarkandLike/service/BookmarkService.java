package com.tuna.gomen.bookMarkandLike.service;

import com.tuna.gomen.bookMarkandLike.dto.BookmarkedBoardDto;
import com.tuna.gomen.mapper.BookmarkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookmarkService {

    private final BookmarkMapper bookmarkMapper;

    @Autowired
    public BookmarkService(BookmarkMapper bookmarkMapper) {
        this.bookmarkMapper = bookmarkMapper;
    }

    public List<BookmarkedBoardDto> getBookmarkedPostsByUserId(Long userId) {
        return bookmarkMapper.findBookmarkedPostsByUserId(userId);
    }
}

