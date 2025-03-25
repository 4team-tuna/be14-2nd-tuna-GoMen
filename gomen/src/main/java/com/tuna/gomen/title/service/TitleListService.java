package com.tuna.gomen.title.service;


import com.tuna.gomen.title.entity.TitleList;

public interface TitleListService {
    void addTitleToUser(Integer userId, Integer titleId);
}
