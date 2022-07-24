package ru.gretchen.accountantspring.soap;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gretchen.accountantspring.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Сервис для работы с SOAP-сервисами
 */
@Service
@RequiredArgsConstructor
@Transactional
public class SOAPService {
    /**
     * @param chatIds
     * @return List<User>
     * Метод запрашивает у сервиса-команды данные по User у сервиса-команды
     */
    public List<User> requestUserByChatId(List<String> chatIds) {
        CommandImplService command = new CommandImplService();
        Command commandI = command.getCommandImplPort();
        SetOfUser users = commandI.getAllUsersAndGroups();
        List<ru.gretchen.accountantspring.soap.User> userItems = users.getItem();
        List<User> userList = new ArrayList<>();

        for (ru.gretchen.accountantspring.soap.User user : userItems) {
            userList.add(new User(user.getChatId(), user.getFullName(), user.getGroup()));
        }

        userList = userList.stream()
                .filter(user -> chatIds.contains(user.getChatId()))
                .collect(Collectors.toList());

        return userList;
    }
}
