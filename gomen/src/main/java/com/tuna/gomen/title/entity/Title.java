package com.tuna.gomen.title.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_title")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Title {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer titleId;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @Column(name = "title_name", nullable = false)
    private String titleName;

    // @PrePersist는 객체가 DB에 저장되기 전 실행됩니다.
    @PrePersist
    @PreUpdate
    public void removeExtraSpaces() {
        if (this.titleName != null) {
            this.titleName = this.titleName.replaceAll("[\\n\\r\\t]", "").trim();
        }
    }
}
