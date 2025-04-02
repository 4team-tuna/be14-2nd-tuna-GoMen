package com.tuna.gomen.bookMarkandLike.command.service;

import com.tuna.gomen.board.command.entity.Board;
import com.tuna.gomen.board.command.repository.BoardRepository;
import com.tuna.gomen.bookMarkandLike.command.dto.BookmarkDTO;
import com.tuna.gomen.bookMarkandLike.command.entity.Bookmark;
import com.tuna.gomen.user.command.entity.User;
import com.tuna.gomen.user.command.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tuna.gomen.bookMarkandLike.command.repository.BookmarkRepository;

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

    @Transactional
    public void removeBookmark(Integer userId, Integer postId) {
        System.out.println("In Service Layer: Removing bookmark for postId = " + postId);

        // 사용자가 해당 post를 북마크했는지(존재하는 데이터인지 확인) 아니면 오류.
        Bookmark bookmark = bookmarkRepository.findByUserIdAndPostId(userId, postId)
                .orElseThrow(() -> new RuntimeException("Bookmark not found"));

        bookmarkRepository.deleteByUserIdAndPostId(userId, postId);

        System.out.println("Bookmark removed successfully for postId = " + postId);
    }

}