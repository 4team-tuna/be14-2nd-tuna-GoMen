package com.tuna.gomen.mentoring.command.entity;

import java.util.Objects;

public class MentoringRequestPK {
    private Integer mentorId;
    private Integer menteeId;
    private Integer teamId;

    public MentoringRequestPK() {
    }

    public MentoringRequestPK(Integer mentorId, Integer menteeId, Integer teamId) {
        this.mentorId = mentorId;
        this.menteeId = menteeId;
        this.teamId = teamId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MentoringRequestPK that = (MentoringRequestPK) o;
        return Objects.equals(mentorId, that.mentorId) && Objects.equals(menteeId, that.menteeId) && Objects.equals(teamId, that.teamId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mentorId, menteeId, teamId);
    }
}
