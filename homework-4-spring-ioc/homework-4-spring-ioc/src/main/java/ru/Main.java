package ru;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.config.MainConfiguration;
import ru.controller.ClientController;
import ru.dto.ClientDTO;


public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfiguration.class);

        ClientController clientController = context.getBean(ClientController.class);

        System.out.println(clientController.execute());

        //Методы ClientController
        System.out.println(clientController.getClient(1));
        clientController.addClient(new ClientDTO(
                "Ildar", "Khaliullin", 500.0, "admin", "Opel"));
        clientController.addClient(new ClientDTO(
                "Igor", "Popov", 500.0, "admin", "Mazda"));


        clientController.updateClient(6,
                new ClientDTO(null, null, null, "user", "Audi" ));

        clientController.deleteClient(7);

        System.out.println(clientController.getAllClients());

        //

    }
}
