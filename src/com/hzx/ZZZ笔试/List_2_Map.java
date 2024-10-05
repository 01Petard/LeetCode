package com.hzx.ZZZ笔试;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class demo_Person {

    private final String name;
    private final String phoneNumber;

    public demo_Person(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

}
public class List_2_Map {



    public static void main(String[] args) {
        List<demo_Person> bookList = new ArrayList<>();
        bookList.add(new demo_Person("jack", "18163138123"));
        bookList.add(new demo_Person("martin", null));
        bookList.add(new demo_Person("martin", "1234567890"));

        // 将List<Person>转换为Map<String, String>
        Map<String, String> phoneBook = bookList.stream().collect(
                    Collectors.toMap(
                        demo_Person::getName,
                        person -> person.getPhoneNumber() != null ? person.getPhoneNumber() : "",
                        (existing, replacement) -> replacement)
                );


        // 打印Map
        phoneBook.forEach((name, phoneNumber) -> System.out.println(name + ": " + phoneNumber));
    }
}
