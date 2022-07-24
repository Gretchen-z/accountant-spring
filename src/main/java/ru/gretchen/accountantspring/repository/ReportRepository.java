package ru.gretchen.accountantspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gretchen.accountantspring.model.Report;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
}
