package ru.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.models.Client;
import ru.models.Part;

import java.util.Date;

@AllArgsConstructor
@Data
public class OrderDTO {

    private Date date;
    private Client client;
    private Part part;
}
