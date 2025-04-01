package com.tuna.gomen.applicant.command.service;

public interface ApplicantCommandService {
    void applyToTeam(Integer teamPostId, Integer userId, String introduce);
    void cancelApplication(Integer teamPostId, Integer userId);
    void processApplication(Integer teamPostId, Integer userId, String isProcessed);
}
