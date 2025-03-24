package com.tuna.gomen.report.jpa.repository;

import com.tuna.gomen.report.jpa.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Integer> {
    List<Report> findByIsProcessed(String isProcessed);
}