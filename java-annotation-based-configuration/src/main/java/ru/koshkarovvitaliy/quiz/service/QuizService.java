package ru.koshkarovvitaliy.quiz.service;

import org.springframework.stereotype.Service;
import ru.koshkarovvitaliy.quiz.model.Answers;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Service
public class QuizService {

    public void holdQuiz(List<String> questions, List<String> optionsStr, Answers answers) {
        if (questions.isEmpty() || optionsStr.isEmpty()) {
            System.out.println("Error: some file is empty");
            return;
        }

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Welcome to the quiz!");
            System.out.println("Enter the answer number after the questions.");

            for (int i = 0; i < questions.size(); i++) {
                System.out.println("\r\n" + questions.get(i));
                List<String> options = Arrays.asList(optionsStr.get(i).split(","));
                options.forEach(option -> System.out.println((options.indexOf(option) + 1) + ") " + option));

                answers.getResults().add(sc.nextInt());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void computeQuizResult(int maxFailedCount, List<String> answersStr, List<Integer> results) {
        String[] answers = answersStr.get(0).split(",");
        int right = answers.length;
        int wrong = 0;

        for (int i = 0; i < right; i++) {
            if (Integer.parseInt(answers[i]) != results.get(i)) {
                wrong++;
            }
        }

        System.out.println("\r\nCount of right answers: " + (right - wrong) + " out of " + right);

        if (wrong >= maxFailedCount) {
            System.out.println("\r\nNot bad, but you could be better :) You didn't pass the test");
        } else {
            System.out.println("\r\nWell done! You passed the quiz");
        }

        System.out.println("Thank you for participating!");
    }
}
