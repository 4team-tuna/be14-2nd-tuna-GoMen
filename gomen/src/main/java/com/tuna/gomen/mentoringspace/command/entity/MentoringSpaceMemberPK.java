package com.tuna.gomen.mentoringspace.command.entity;

import com.tuna.gomen.user.command.entity.User;

import java.util.Objects;

public class MentoringSpaceMemberPK {
    private Integer mentoringSpaceId;
    private Integer userId;

    public MentoringSpaceMemberPK() {
    }

    public MentoringSpaceMemberPK(Integer mentoringSpaceId, Integer userId) {
        this.mentoringSpaceId = mentoringSpaceId;
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MentoringSpaceMemberPK that = (MentoringSpaceMemberPK) o;
        return Objects.equals(mentoringSpaceId, that.mentoringSpaceId) && Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mentoringSpaceId, userId);
    }
}
