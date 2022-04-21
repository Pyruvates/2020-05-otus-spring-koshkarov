package ru.koshkarovvitaliy.quiz;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.koshkarovvitaliy.quiz.model.Answers;
import ru.koshkarovvitaliy.quiz.model.Questions;
import ru.koshkarovvitaliy.quiz.model.Options;

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
}
