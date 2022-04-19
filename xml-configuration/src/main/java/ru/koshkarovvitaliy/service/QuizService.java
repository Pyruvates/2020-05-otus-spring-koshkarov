package ru.koshkarovvitaliy.service;

import java.util.List;
import java.util.Scanner;

public class QuizService {
    public void holdQuiz(List<String> questions, List<String> answers) {
        if (questions.isEmpty() || answers.isEmpty()) {
            System.out.println("Error: some file is empty");
            return;
        }

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Welcome to the quiz!");
            System.out.println("Write answers after questions.\r\n");

            for (int i = 0; i < questions.size(); i++) {
                System.out.println(questions.get(i));
                sc.next();
                System.out.println("The right answer is:");
                System.out.println(answers.get(i) + "\r\n");
            }

            System.out.println("Thank you for participating!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
