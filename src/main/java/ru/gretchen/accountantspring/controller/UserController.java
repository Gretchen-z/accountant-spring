package ru.gretchen.accountantspring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gretchen.accountantspring.model.Task;
import ru.gretchen.accountantspring.repository.TaskRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Контроллер для работы с User
 * endpoint /accountant/users
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/users")
public class UserController{
    private final TaskRepository taskRepository;

    /**
     * Метод отправляет сервису-нотификатору список chatId затрекавшихся сегодня User'ов
     */
    @GetMapping
    public List<String> get() {
        List<Task> todayTasks = taskRepository.findAllByDate(LocalDate.now());
        List<String> chatIds = todayTasks.stream()
                .map(Task::getChatId)
                .distinct()
                .collect(Collectors.toList());
        return chatIds;
    }
}
