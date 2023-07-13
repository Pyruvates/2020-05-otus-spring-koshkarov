package ru.koshkarovvitaliy.service;

import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import ru.koshkarovvitaliy.YamlProperties;
import ru.koshkarovvitaliy.model.Answers;
import ru.koshkarovvitaliy.util.Util;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Service
@AllArgsConstructor
public class QuizService {
    private static final Logger logger = LogManager.getLogger(QuizService.class);

    public void start(YamlProperties yamlProps, Answers answers) throws IOException {
        List<String> questions = Util.convertResourceToList(yamlProps.getQuestionsPath());
        List<String> optionsStr = Util.convertResourceToList(yamlProps.getOptionsPath());
        List<String> answersStr = Util.convertResourceToList(answers.getResource());

        holdQuiz(questions, optionsStr, answers);
        computeQuizResult(answers.getMaxFailedCount(), answersStr, answers.getResults());
    }

    private void holdQuiz(List<String> questions, List<String> optionsStr, Answers answers) {
        if (questions.isEmpty() || optionsStr.isEmpty()) {
            logger.error("Error: some file is empty");
            return;
        }

        try (Scanner sc = new Scanner(System.in)) {
            logger.info("Enter the answer number after the questions.");

            for (int i = 0; i < questions.size(); i++) {
                logger.info(questions.get(i));
                List<String> options = Arrays.asList(optionsStr.get(i).split(","));
                options.forEach(option -> logger.info((options.indexOf(option) + 1) + ") " + option));

                answers.getResults().add(sc.nextInt());
            }
        } catch (Exception ex) {
            logger.error("{}: {}", ex.getClass(), ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void computeQuizResult(int maxFailedCount, List<String> answersStr, List<Integer> results) {
        String[] answers = answersStr.get(0).split(",");
        int right = answers.length;
        int wrong = 0;

        for (int i = 0; i < right; i++) {
            if (Integer.parseInt(answers[i]) != results.get(i)) {
                wrong++;
            }
        }

        logger.info("Count of right answers: " + (right - wrong) + " out of " + right);

        if (wrong >= maxFailedCount) {
            logger.info("Not bad, but you could be better :) You didn't pass the test");
        } else {
            logger.info("Well done! You passed the quiz");
        }

        logger.info("Thank you for participating!");
    }
}