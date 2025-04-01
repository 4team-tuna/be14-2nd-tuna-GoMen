package com.tuna.gomen.applicant.command.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class ApplicantId implements Serializable {
    private Integer teamPostId;
    private Integer userId;

    public ApplicantId() {}

    public ApplicantId(Integer teamPostId, Integer userId) {
        this.teamPostId = teamPostId;
        this.userId = userId;
    }
}
