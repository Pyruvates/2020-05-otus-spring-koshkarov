package ru.koshkarovvitaliy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.koshkarovvitaliy.model.Answers;
import ru.koshkarovvitaliy.model.Options;
import ru.koshkarovvitaliy.model.Questions;
import ru.koshkarovvitaliy.service.QuizService;

@Configuration
@PropertySource("classpath:application.properties")
public class Config {

    @Bean
    public Questions questions() {
        return new Questions();
    }

    @Bean
    public Options options() {
        return new Options();
    }

    @Bean
    public Answers answers() {
        return new Answers();
    }

    @Bean
    public QuizService quizService() {
        return new QuizService();
    }
}
