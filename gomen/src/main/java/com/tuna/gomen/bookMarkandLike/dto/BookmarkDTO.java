package com.tuna.gomen.bookMarkandLike.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookmarkDTO {
    private Integer userId;
    private Integer postId;
}