package ru.gretchen.accountantspring.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User {
    private String chatId;

    private String fullName;

    private String group;
}
