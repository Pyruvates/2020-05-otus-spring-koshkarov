package ru.koshkarovvitaliy.quiz;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.Resource;
import ru.koshkarovvitaliy.quiz.model.Answers;
import ru.koshkarovvitaliy.quiz.model.Questions;
import ru.koshkarovvitaliy.quiz.service.QuizService;
import ru.koshkarovvitaliy.quiz.model.Options;

import java.io.IOException;
import java.util.List;

@ComponentScan("ru.koshkarovvitaliy.quiz")
public class Application {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);

        Questions questions = context.getBean(Questions.class);
        Resource resource = questions.getResource();
        List<String> questionsStr = Utils.convertResourceToList(resource);

        Options options = context.getBean(Options.class);
        resource = options.getResource();
        List<String> optionsStr = Utils.convertResourceToList(resource);

        Answers answers = context.getBean(Answers.class);
        resource = answers.getResource();
        List<String> answersStr = Utils.convertResourceToList(resource);

        QuizService quizService = context.getBean(QuizService.class);

        quizService.holdQuiz(questionsStr, optionsStr, answers);

        quizService.computeQuizResult(answers.getMaxFailedCount(), answersStr, answers.getResults());
    }
}
