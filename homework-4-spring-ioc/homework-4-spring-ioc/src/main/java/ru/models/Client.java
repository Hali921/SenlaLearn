package ru.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Component
public class Client {

    private Integer id;
    private String firstName;
    private String lastName;
    private Double money;
    private String role;
    private String car;


}
