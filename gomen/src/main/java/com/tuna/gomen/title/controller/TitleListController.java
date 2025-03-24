package com.tuna.gomen.title.controller;


import com.tuna.gomen.title.service.TitleListService;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gomen/title-list")
@RequiredArgsConstructor
public class TitleListController {

    private final TitleListService titleListService;

    @PostMapping("/add")
    public ResponseEntity<String> addTitleToUser(@RequestBody Map<String, Integer> request) {
        try {
            Integer userId = request.get("userId");
            Integer titleId = request.get("titleId");

            if (userId == null || titleId == null) {
                return ResponseEntity.badRequest().body("userId와 titleId는 필수입니다.");
            }

            titleListService.addTitleToUser(userId, titleId);
            return ResponseEntity.ok("칭호가 유저에게 정상적으로 부여되었습니다.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("칭호 부여에 실패했습니다.");
        }
    }
}
