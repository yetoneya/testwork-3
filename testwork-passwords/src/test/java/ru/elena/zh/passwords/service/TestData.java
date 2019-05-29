package ru.elena.zh.passwords.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import ru.elena.zh.passwords.base.Password;

public class TestData {

    private static final List<Password> LIST1 = new ArrayList<Password>();
    private static final List<Password> LIST2 = new ArrayList<Password>();
    private static final List<Password> LIST3 = new ArrayList<Password>();
    private static final List<Password> LIST12 = new ArrayList<Password>();
    private static final List<Password> LIST13 = new ArrayList<Password>();
    private static final List<Password> LIST23 = new ArrayList<Password>();

    static {
        LIST1.add(new Password("РФ", "11", "111122", "10.09.2001", "активен"));
        LIST1.add(new Password("РФ", "11", "111122", "11.09.2014", "активен"));
        LIST1.add(new Password("Аргентина", "34", "3534564", "01.01.2007", "деактивирован"));
        LIST1.add(new Password("РФ", "334", "77723", "01.09.1900", "активен"));

        LIST2.add(new Password("РФ", "11", "111122", "11.09.2011", "деактивирован"));
        LIST2.add(new Password("Аргентина", "34", "3534564", "11.09.2001", "активен"));
        LIST2.add(new Password("Ливан", "234", "355666", "11.09.1975", "активен"));
        LIST2.add(new Password("Индия", "384", "93493", "17.09.1975", "деактивирован"));

        LIST3.add(new Password("РФ", "12", "111122", "11.09.2011", "деактивирован"));
        LIST3.add(new Password("Аргентина", "34", "3534564", "11.09.2016", "деактивирован"));
        LIST3.add(new Password("Ливан", "234", "355666", "11.09.2015", "активен"));
        LIST3.add(new Password("Ливан", "384", "93493", "17.09.2015", "деактивирован"));

        LIST12.add(new Password("РФ", "11", "111122", "11.09.2014", "активен"));
        LIST12.add(new Password("Аргентина", "34", "3534564", "01.01.2007", "деактивирован"));
        LIST12.add(new Password("РФ", "334", "77723", "01.09.1900", "деактивирован"));
        LIST12.add(new Password("Ливан", "234", "355666", "11.09.1975", "активен"));
        LIST12.add(new Password("Индия", "384", "93493", "17.09.1975", "деактивирован"));

        Collections.sort(LIST12, Comparator.comparing(Password::dateToCompare).reversed());

        LIST13.add(new Password("РФ", "11", "111122", "11.09.2014", "активен"));
        LIST13.add(new Password("РФ", "12", "111122", "11.09.2011", "деактивирован"));
        LIST13.add(new Password("Аргентина", "34", "3534564", "11.09.2016", "деактивирован"));
        LIST13.add(new Password("РФ", "334", "77723", "01.09.1900", "деактивирован"));
        LIST13.add(new Password("Ливан", "384", "93493", "17.09.2015", "деактивирован"));
        LIST13.add(new Password("Ливан", "234", "355666", "11.09.2015", "деактивирован"));

        Collections.sort(LIST13, Comparator.comparing(Password::dateToCompare).reversed());

    }

    public static List<Password> getList1() {
        return new ArrayList<>(LIST1);
    }

    public static List<Password> getList2() {
        return new ArrayList<>(LIST2);
    }

    public static List<Password> getList3() {
        return new ArrayList<>(LIST3);
    }

    public static List<Password> getList12() {
        return new ArrayList<>(LIST12);
    }

    public static List<Password> getList13() {
        return new ArrayList<>(LIST13);
    }

    public static List<Password> getList23() {
        return new ArrayList<>(LIST23);
    }

}
