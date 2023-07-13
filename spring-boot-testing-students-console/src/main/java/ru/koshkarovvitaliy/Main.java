package ru.koshkarovvitaliy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import ru.koshkarovvitaliy.model.Answers;
import ru.koshkarovvitaliy.service.QuizService;

import java.io.IOException;

@SpringBootApplication
@EnableConfigurationProperties(YamlProperties.class)
public class Main implements CommandLineRunner {
    @Autowired
    private ApplicationContext appContext;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws IOException {
        YamlProperties yamlProps = appContext.getBean(YamlProperties.class);
        Answers answers = appContext.getBean(Answers.class);
        QuizService quizService = appContext.getBean(QuizService.class);

        quizService.start(yamlProps, answers);
    }
}