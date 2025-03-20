package com.tuna.gomen.mentorList;

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
