package lesson3.task2;

import java.util.*;

public class Phonebook {

//        //задание 2 мой вариант
////
//        Map<String, Contact> contacts = new HashMap<String, Contact>();
//        contacts.put("Петров", new Contact("Петров","87011801842"));
//        contacts.put("Иванов", new Contact("Иванов", "87021801843", "87011801842"));
//        Contact myFriend = contacts.get("Иванов");
//        System.out.println(myFriend);

    //вывод с ошибкой ((

    //вариант преподавателя

    Map<String, Set<String>> phonebook;

    public Phonebook() {
        this.phonebook = new HashMap<>();
    }

    public void addPhone(String name, String phone) {
//        Set<String> phones = phonebook.computeIfAbsent(name,key -> new HashSet<>());
        Set<String> phones= phonebook.get(name);
        if (phones == null){
            phones = new HashSet<>();
            phonebook.put(name, phones);
        }
        phones.add(phone);

    }

    public Set<String> getPhonesByName(String name) {

        return phonebook.get(name);

    }

    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        phonebook.addPhone("Маркиз", "123");
        phonebook.addPhone("Маркиз", "1234567");
        phonebook.addPhone("Карабас", "12345");

        System.out.println(phonebook.getPhonesByName("Маркиз"));
    }
}

