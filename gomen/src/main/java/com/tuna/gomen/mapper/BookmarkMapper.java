package com.tuna.gomen.mapper;

import com.tuna.gomen.bookMarkandLike.dto.BookmarkedBoardDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

    @Mapper
    public interface BookmarkMapper {
        List<BookmarkedBoardDto> findBookmarkedPostsByUserId(@Param("userId") Integer userId);
    }

