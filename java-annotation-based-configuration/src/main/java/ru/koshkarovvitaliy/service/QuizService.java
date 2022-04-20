package ru.koshkarovvitaliy.service;

import lombok.Getter;
import ru.koshkarovvitaliy.model.Answers;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Getter
public class QuizService {

    public void holdQuiz(List<String> questions, List<String> optionsStr, Answers answers) {
        if (questions.isEmpty() || optionsStr.isEmpty()) {
            System.out.println("Error: some file is empty");
            return;
        }

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Welcome to the quiz!");
            System.out.println("Write answers after questions.");

            for (int i = 0; i < questions.size(); i++) {
                System.out.println("\r\n" + questions.get(i));
                List<String> options = Arrays.asList(optionsStr.get(i).split(","));
                options.forEach(option -> System.out.println((options.indexOf(option) + 1) + ") " + option));

                answers.getResults().add(sc.nextInt());
            }

            System.out.println("\r\n" + "Thank you for participating!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
