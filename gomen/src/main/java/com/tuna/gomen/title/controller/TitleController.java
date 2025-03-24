package com.tuna.gomen.title.controller;

import com.tuna.gomen.title.entity.Title;
import com.tuna.gomen.title.service.TitleService;
import com.tuna.gomen.user.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gomen/titles")
public class TitleController {

    @Autowired
    private TitleService titleService;

    @Autowired
    private UserService userService;

    // 칭호 생성(POST)
    @PostMapping
    public ResponseEntity<Title> createTitle(@RequestBody String titleName) {
        try {
            Title title = titleService.createTitle(titleName);
            return new ResponseEntity<>(title, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST); // 400 Bad Request
        }
    }

    // 칭호 수정(PUT)
    @PutMapping("/{titleId}")
    public ResponseEntity<Title> updateTitle(@PathVariable Integer titleId, @RequestBody String newTitleName) {
        try {
            Title updatedTitle = titleService.updateTitle(titleId, newTitleName);
            return new ResponseEntity<>(updatedTitle, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND); // 404 Not Found
        }
    }


    // 모든 칭호 조회 (GET)
    @GetMapping("/select-all")
    public ResponseEntity<List<Title>> getAllTitles() {
        List<Title> titles = titleService.getAllTitles();
        return new ResponseEntity<>(titles, HttpStatus.OK);
    }
}
