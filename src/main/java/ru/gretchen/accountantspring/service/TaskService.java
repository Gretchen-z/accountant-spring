package ru.gretchen.accountantspring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gretchen.accountantspring.exception.TaskNotGetByDateException;
import ru.gretchen.accountantspring.exception.TaskNotSaveException;
import ru.gretchen.accountantspring.model.Task;
import ru.gretchen.accountantspring.repository.TaskRepository;

import java.time.LocalDate;
import java.util.List;

/**
 * Сервис для работы с Task repository
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TaskService {
    private final TaskRepository taskRepository;

    /**
     *
     * @param task
     * @return Task
     * Метод для сохранения Task в БД
     */
    @Transactional
    public Task create(Task task) {
        try {
            return taskRepository.save(task);
        } catch (Exception e) {
            throw new TaskNotSaveException(e.getMessage());
        }
    }

    /**
     *
     * @return List<Task>
     * Метод для получения из БД всех Task по определённой дате
     */
    public List<Task> getByDateNow() {
        try {
            return taskRepository.findAllByDate(LocalDate.now());
        } catch (Exception e) {
            throw new TaskNotGetByDateException(e.getMessage());
        }

    }
}
