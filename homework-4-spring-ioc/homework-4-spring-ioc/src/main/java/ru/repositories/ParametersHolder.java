package ru.repositories;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("application.properties")
public class ParametersHolder {

    @Value("${my.param.db}")
    private String someText;

    public String getSomeText() {
        return someText;
    }
}
