package com.tuna.gomen.bookMarkandLike.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookmarkedBoardDto {
    private Integer postId;
    private String title;
    private String isBlinded;
    private String isDeleted;
    private String userNickname;

}
