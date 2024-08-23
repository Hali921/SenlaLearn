package ru;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.config.MainConfiguration;
import ru.controller.ClientController;
import ru.controller.PartController;
import ru.dto.ClientDTO;
import ru.dto.PartDTO;
import ru.models.Manufacture;
import ru.models.PartType;



public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfiguration.class);

        ClientController clientController = context.getBean(ClientController.class);

        System.out.println(clientController.execute());

        //Методы ClientController
        System.out.println("Client контроллер - ");
        System.out.println(clientController.getClient(1));
        clientController.addClient(new ClientDTO(
                "Ildar", "Khaliullin", 500.0, "admin", "Opel"));
        clientController.addClient(new ClientDTO(
                "Igor", "Popov", 500.0, "admin", "Mazda"));


        clientController.updateClient(6,
                new ClientDTO(null, null, null, "user", "Audi" ));

        clientController.deleteClient(7);

        System.out.println(clientController.getAllClients());

        //Методы PartController
        PartController partController = context.getBean(PartController.class);
        System.out.println("Part контроллер - ");

        System.out.println(partController.getPart(1));

        partController.addPart(new PartDTO(new PartType(1,"wheel"),
                new Manufacture(1, "ATE"), 4.0, 100, 20));
        partController.addPart(new PartDTO(new PartType(1,"shock absorbers"),
                new Manufacture(1, "MINTEX"), 4.5, 100, 70));

        partController.updatePart(4, new PartDTO(new PartType(4,"wheel"),
                new Manufacture(1, "ATE"), 3.7, 99, 20));

        partController.deletePart(5);

        System.out.println(partController.getAllParts());



    }
}
