package com.tuna.gomen.mentoringspace.command.entity;

import java.util.Objects;


public class MentoringSpaceMemberPK {
    private Integer mentoringSpace;
    private Integer mentee;

    public MentoringSpaceMemberPK() {
    }

    public MentoringSpaceMemberPK(Integer mentoringSpace, Integer mentee) {
        this.mentoringSpace = mentoringSpace;
        this.mentee = mentee;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MentoringSpaceMemberPK that = (MentoringSpaceMemberPK) o;
        return Objects.equals(mentoringSpace, that.mentoringSpace) && Objects.equals(mentee, that.mentee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mentoringSpace, mentee);
    }
}
