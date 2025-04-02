package com.tuna.gomen.bookMarkandLike.query.service;

import com.tuna.gomen.bookMarkandLike.query.dto.BookmarkedBoardDto;
import com.tuna.gomen.mapper.BookmarkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service("queryBookmarkService")  // 쿼리용 서비스
public class BookmarkService {

    private final BookmarkMapper bookmarkMapper;

    @Autowired
    public BookmarkService(BookmarkMapper bookmarkMapper) {
        this.bookmarkMapper = bookmarkMapper;
    }

    public List<BookmarkedBoardDto> getBookmarkedPostsByUserId(Integer userId) {
        return bookmarkMapper.findBookmarkedPostsByUserId(userId);
    }
}

