package com.tuna.gomen.mentorList.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MentorListDTO {
    private int mentorId;
    private String mExpert;
    private String mContent;
    private String isDeleted;
}
