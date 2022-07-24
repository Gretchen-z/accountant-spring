package ru.gretchen.accountantspring.exception;

public class ReportNotWriteException extends RuntimeException{
    public ReportNotWriteException(String message) {
        super("Не удалось записать и отправить отчёт " + message);
    }
}
