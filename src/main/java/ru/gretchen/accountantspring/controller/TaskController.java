package ru.gretchen.accountantspring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gretchen.accountantspring.model.Task;
import ru.gretchen.accountantspring.service.TaskService;

import java.time.LocalDate;

/**
 * Контроллер для работы с Task
 * endpoint /accountant/tasks
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/tasks")
public class TaskController {

    private final TaskService taskService;

    /**
     * Метод принимает от сервиса-роутера информацию о Task и сохраняет в БД
     */
    @PostMapping
    public void post(@RequestBody Task task) {
        task.setDate(LocalDate.now());
        taskService.create(task);
    }
}
