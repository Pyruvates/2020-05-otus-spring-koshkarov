package ru.koshkarovvitaliy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, Spring!");

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        User user = context.getBean(User.class);
        System.out.println("Name: " + user.getName() + ", age: " + user.getAge());
    }
}
