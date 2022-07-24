package ru.gretchen.accountantspring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gretchen.accountantspring.exception.ReportNotCreateException;
import ru.gretchen.accountantspring.model.Report;
import ru.gretchen.accountantspring.repository.ReportRepository;

import java.time.LocalDate;

/**
 * Сервис для работы с Report repository
 */
@Service
@RequiredArgsConstructor
@Transactional
public class ReportService {
    private final ReportRepository reportRepository;
    private final TaskService taskService;

    /**
     * Метод для формирования и сохранения Report в БД
     * @return Report
     */
    public Report create() {
        try {
            Report report = new Report();
            report.setDate(LocalDate.now());
            report.setTasks(taskService.getByDateNow());
            return reportRepository.save(report);
        } catch (Exception e) {
            throw new ReportNotCreateException(e.getMessage());
        }
    }
}
