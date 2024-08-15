package ru.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.models.Manufacture;
import ru.models.PartType;

@AllArgsConstructor
@Data
public class PartDTO {

    private PartType partType;
    private Manufacture manufacture;
    private Double rating;
    private Integer quantity;
    private Integer price;

}
