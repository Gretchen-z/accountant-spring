package ru.gretchen.accountantspring.exception;

public class ReportNotCreateException extends RuntimeException{
    public ReportNotCreateException(String message) {
        super("Не удалось создать отчёт: " + message);
    }
}
