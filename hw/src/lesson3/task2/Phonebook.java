package lesson3.task2;

import java.util.HashMap;
import java.util.Map;

public class Phonebook {

    public static void main(String[] args) {

        //задание 2 мой вариант

        Map<String, Contact> contacts = new HashMap<String, Contact>();
        contacts.put("Петров", new Contact("Петров","87011801842"));
        contacts.put("Иванов", new Contact("Иванов", "87021801843", "87011801842"));
        Contact myFriend = contacts.get("Иванов");
        System.out.println(myFriend);

        //вывод с ошибкой ((

        //вариант преподавателя



    }
    }
