package ru.elena.zh.passwords.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;
import ru.elena.zh.passwords.base.Password;

public class PasswordDiscard {

    public List<Password> discard(List<Password> list1, List<Password> list2) {
        try {
            //находим паспорт с самой свежей датой для каждой страны
            Map<String, Optional<Password>> lastEntryDateForEveryCountry = Stream.of(list1, list2)
                    .flatMap(c -> c.stream())
                    .collect(groupingBy(Password::getCountry, maxBy(Comparator.comparing(Password::dateToCompare))));

            final List<Password> resultSet = lastEntryDateForEveryCountry.values().stream().map(e -> e.get()).collect(toList());
            //составляем отсортированный по убыванию даты список из всех паспортов,
            //чтобы при добавлении в результирующий список в первую очередь добавить паспорт с самой свежей датой,
            //а его дубликаты с более старыми датами не добавлять
            //дубликатом определяется совпадением трех полей: country, number, series
            List<Password> entrySet = Stream.of(list1, list2)
                    .flatMap(c -> c.stream())
                    .sorted(Comparator.comparing(Password::dateToCompare).reversed())
                    .collect(toList());
            //добавляем те  паспорта из общего списка, которых еще нет в результирующем наборе            
            for (Password p : entrySet) {
                if (!resultSet.contains(p)) {
                    p.setActive("деактивирован");
                    resultSet.add(p);
                }
            }
            Collections.sort(resultSet, Comparator.comparing(Password::dateToCompare).reversed());
            return resultSet;

        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<Password>();
        }
    }
}
