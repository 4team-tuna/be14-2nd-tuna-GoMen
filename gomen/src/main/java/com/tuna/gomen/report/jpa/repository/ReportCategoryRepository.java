package com.tuna.gomen.report.jpa.repository;

import com.tuna.gomen.report.jpa.entity.ReportCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportCategoryRepository extends JpaRepository<ReportCategory, Integer> {
}