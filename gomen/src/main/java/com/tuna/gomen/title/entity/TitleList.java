package com.tuna.gomen.title.entity;

import com.tuna.gomen.user.command.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "tbl_title_list")
@Getter
@Setter
public class TitleList {
    @Id
    @Column(name = "user_id")
    private Integer userId;

    @Id
    @Column(name = "title_id")
    private Integer titleId;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "title_id", insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)  // 부모 삭제 시 자식도 자동으로 삭제
    private Title title;


}
