package ru.koshkarovvitaliy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import ru.koshkarovvitaliy.model.Answers;
import ru.koshkarovvitaliy.model.Questions;
import ru.koshkarovvitaliy.service.QuizService;

import java.io.IOException;
import java.util.List;

import static ru.koshkarovvitaliy.Config.SPRING_CONTEXT;
import static ru.koshkarovvitaliy.Utils.convertResourceToList;

public class Main {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext(SPRING_CONTEXT);

        Questions questions = context.getBean(Questions.class);
        Answers answers = context.getBean(Answers.class);
        QuizService quizService = context.getBean(QuizService.class);

        Resource resource = context.getResource(questions.getClassPath());
        List<String> questionsStr = convertResourceToList(resource);

        resource = context.getResource(answers.getClassPath());
        List<String> answersStr = convertResourceToList(resource);

        quizService.holdQuiz(questionsStr, answersStr);
    }
}
