package com.tuna.gomen.mentoring;

import com.tuna.gomen.mapper.MentoringMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public class MentoringService {

    private MentoringMapper mentoringMapper;

//    @Autowired
    public MentoringService(MentoringMapper mentoringMapper) {
        this.mentoringMapper = mentoringMapper;
    }

}