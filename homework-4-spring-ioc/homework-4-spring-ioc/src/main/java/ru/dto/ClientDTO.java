package ru.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ClientDTO {

    private String firstName;
    private String lastName;
    private Double money;
    private String role;
    private String car;

}
