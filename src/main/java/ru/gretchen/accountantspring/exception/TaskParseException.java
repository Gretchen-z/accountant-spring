package ru.gretchen.accountantspring.exception;

public class TaskParseException extends RuntimeException{
    public TaskParseException(String message) {
        super("Задача передана в неверном формате " + message);
    }
}
