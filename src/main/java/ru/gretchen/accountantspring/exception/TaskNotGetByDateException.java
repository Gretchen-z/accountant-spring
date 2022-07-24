package ru.gretchen.accountantspring.exception;

public class TaskNotGetByDateException extends RuntimeException{
    public TaskNotGetByDateException(String message) {
        super("Не удалось получить сегодняшние задачи " + message);
    }
}
