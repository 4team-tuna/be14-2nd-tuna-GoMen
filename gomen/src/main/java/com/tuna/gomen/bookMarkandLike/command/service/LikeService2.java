package com.tuna.gomen.bookMarkandLike.command.service;


import com.tuna.gomen.board.command.entity.Board;
import com.tuna.gomen.board.command.repository.BoardRepository;
import com.tuna.gomen.bookMarkandLike.command.dto.LikeDTO;
import com.tuna.gomen.bookMarkandLike.command.entity.Like;
import com.tuna.gomen.bookMarkandLike.command.repository.LikeRepository;
import com.tuna.gomen.user.command.entity.User;
import com.tuna.gomen.user.command.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class LikeService2 {

    private final LikeRepository likeRepository;
    private final UserRepository userRepository;
    private final BoardRepository boardRepository;

    @Autowired
    public  LikeService2(LikeRepository likeRepository,
                             UserRepository userRepository,
                             BoardRepository boardRepository) {
        this.likeRepository = likeRepository;
        this.userRepository = userRepository;
        this.boardRepository = boardRepository;
    }

    @Transactional
    public LikeDTO addLike(Integer userId, Integer postId) {
//        System.out.println("In Service Layer: Received postId = " + postId);

        if (postId == null) {
            throw new IllegalArgumentException("Post ID cannot be null");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Board board = boardRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        Like like = new Like();
        like.setUserId(user.getUserId());
        like.setPostId(board.getPostId());

//        System.out.println("Post ID: " + bookmark.getPostId());// Bookmark 객체가 생성되었을 때 postId가 null인지 확인

        likeRepository.save(like);

        return new LikeDTO(userId, postId);  // 엔티티 → DTO 변환 후 반환
    }

    @Transactional
    public void removeLike(Integer userId, Integer postId) {

        // 사용자가 해당 post를 좋아요했는지(존재하는 데이터인지 확인) 아니면 오류.
        Like like = likeRepository.findByUserIdAndPostId(userId, postId)
                .orElseThrow(() -> new RuntimeException("Like not found"));

        likeRepository.deleteByUserIdAndPostId(userId, postId);

        System.out.println("like removed successfully for postId = " + postId);
    }

}