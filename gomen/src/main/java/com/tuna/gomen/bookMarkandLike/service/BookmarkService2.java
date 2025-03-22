package com.tuna.gomen.bookMarkandLike.service;

import com.tuna.gomen.board.command.entity.Board;
import com.tuna.gomen.board.repository.BoardRepository;
import com.tuna.gomen.bookMarkandLike.dto.BookmarkDTO;
import com.tuna.gomen.bookMarkandLike.entity.Bookmark;
import com.tuna.gomen.user.command.entity.User;
import com.tuna.gomen.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tuna.gomen.bookMarkandLike.repository.BookmarkRepository;

@Service
@Transactional
public class BookmarkService2 {

    private final BookmarkRepository bookmarkRepository;
    private final UserRepository userRepository;
    private final BoardRepository boardRepository;

    @Autowired
    public  BookmarkService2(BookmarkRepository bookmarkRepository,
                         UserRepository userRepository,
                         BoardRepository boardRepository) {
        this.bookmarkRepository = bookmarkRepository;
        this.userRepository = userRepository;
        this.boardRepository = boardRepository;
    }

    @Transactional
    public BookmarkDTO addBookmark(Integer userId, Integer postId) {
//        System.out.println("In Service Layer: Received postId = " + postId);

        if (postId == null) {
            throw new IllegalArgumentException("Post ID cannot be null");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Board board = boardRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        Bookmark bookmark = new Bookmark();
        bookmark.setUserId(user.getUserId());
        bookmark.setPostId(board.getPostId());

//        System.out.println("Post ID: " + bookmark.getPostId());// Bookmark 객체가 생성되었을 때 postId가 null인지 확인

        bookmarkRepository.save(bookmark);

        return new BookmarkDTO(userId, postId);  // 엔티티 → DTO 변환 후 반환
    }
}