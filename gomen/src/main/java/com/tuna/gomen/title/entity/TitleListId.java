package com.tuna.gomen.title.entity;

import java.io.Serializable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class TitleListId implements Serializable {

    private Integer userId;
    private Integer titleId;

    public TitleListId() {}

    public TitleListId(Integer userId, Integer titleId) {
        this.userId = userId;
        this.titleId = titleId;
    }
}