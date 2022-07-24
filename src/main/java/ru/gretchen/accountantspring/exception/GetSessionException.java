package ru.gretchen.accountantspring.exception;

public class GetSessionException extends RuntimeException{
    public GetSessionException(String message) {
        super("Не удалось получить фабрику сессий: " + message);
    }
}
