package org.example.hexlet.repository;

import lombok.Getter;
import org.example.hexlet.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {
    @Getter
    private static List<User> entities = new ArrayList<>(List.of(
            new User(1L,"Vitya123", "viktor@mail.ru", "qwerty"),
            new User(2L,"Kolya_The_Best", "nikolay@mail.ru", "qwerty1"),
            new User(3L,"OlegMVP", "olegivanovich@mail.ru", "qwerty12"),
            new User(4L,"@*K0NffeTKa*@", "alevtina@mail.ru", "qwerty123"),
            new User(5L,"DEVil", "nikitos@mail.ru", "qwerty1234")
    ));

    public static void save(User user) {
        user.setId(entities.size() + 1L);
        entities.add(user);
    }

    public static List<User> search (String term) {
        return entities.stream()
                .filter(u -> u.getName().startsWith(term.trim()))
                .toList();
    }

    public static Optional<User> find (Long id) {
        return entities.stream().filter(u -> u.getId().equals(id)).findFirst();
    }
}
