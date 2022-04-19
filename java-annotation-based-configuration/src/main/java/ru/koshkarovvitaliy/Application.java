package ru.koshkarovvitaliy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.Resource;
import ru.koshkarovvitaliy.model.Answers;
import ru.koshkarovvitaliy.model.Questions;
import ru.koshkarovvitaliy.service.QuizService;

import java.io.IOException;
import java.util.List;

@ComponentScan("ru.koshkarovvitaliy")
public class Application {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);

        Questions questions = context.getBean(Questions.class);
        Resource resource = context.getResource(questions.getClassPath());
        List<String> questionsStr = Utils.convertResourceToList(resource);

        Answers answers = context.getBean(Answers.class);
        resource = context.getResource(answers.getClassPath());
        List<String> answersStr = Utils.convertResourceToList(resource);

        QuizService quizService = context.getBean(QuizService.class);
        quizService.holdQuiz(questionsStr, answersStr);
    }
}
