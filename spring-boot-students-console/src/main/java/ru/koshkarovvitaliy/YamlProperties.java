package ru.koshkarovvitaliy;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import ru.koshkarovvitaliy.model.Answers;

@Getter
@Setter
@ConfigurationProperties
public class YamlProperties {

    @Value("${application.questions.path}")
    private Resource questionsPath;

    @Value("${application.options.path}")
    private Resource optionsPath;

    @Bean
    public Answers answers() {
        return new Answers();
    }
}