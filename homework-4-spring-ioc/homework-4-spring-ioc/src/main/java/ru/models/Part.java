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
public class Part {

    private Integer id;
    private PartType partType;
    private Manufacture manufacture;
    private Double rating;
    private Integer quantity;
    private Integer price;
}
