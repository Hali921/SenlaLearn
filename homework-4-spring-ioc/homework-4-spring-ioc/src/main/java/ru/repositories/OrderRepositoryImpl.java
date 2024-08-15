package ru.repositories;


import org.springframework.stereotype.Component;
import ru.models.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class OrderRepositoryImpl implements OrderRepository{



    List<Order> orderList = new ArrayList<>(Arrays.asList(
            new Order(1, new Date(),
                    new Client(10,"Marat", "Maratov", 500.0, "user", "BMW"),
                    new Part(3, new PartType(3, "glass"),
                            new Manufacture(3,"Fag"), 2.4, 100, 50))));




}
