package com.tuna.gomen.starPointReview.command.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MentoringId implements Serializable {
    private Integer mentorId;
    private Integer menteeId;
    private Integer teamId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MentoringId that = (MentoringId) o;
        return Objects.equals(mentorId, that.mentorId)
                && Objects.equals(menteeId, that.menteeId)
                && Objects.equals(teamId, that.teamId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mentorId, menteeId, teamId);
    }
}
