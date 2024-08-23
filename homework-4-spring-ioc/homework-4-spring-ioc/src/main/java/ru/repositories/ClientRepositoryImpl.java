package ru.repositories;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.models.Client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ClientRepositoryImpl implements ClientRepository{
    //для базы данных типа ArrayList
    private static Integer createId;

    @Autowired
    private ParametersHolder parametersHolder;
    private static List<Client> clientList;


    public String execute(){
        return parametersHolder.getSomeText();
    }


    static {
        createId = 5;
        clientList = new ArrayList<>(Arrays.asList(
                new Client(1, "Ivan", "Ivanov", 500.0, "user", "BMW"),
                new Client(2, "Mihail", "Mihailov", 500.0, "user", "Opel"),
                new Client(3, "Aleks", "Aleksov", 500.0, "user", "Ford"),
                new Client(4, "Dmitriy", "Dmitriev", 500.0, "user", "Lada"),
                new Client(5, "Oleg", "Olegov", 500.0, "user", "Chevrolet")));
    }

    public List<Client> findAllClients() {
        return clientList;
    }

    @Override
    public void save(Client client) {
        clientList.add(client);

        client.setId(++createId);
    }

    @Override
    public Client findById(Integer clientId) {
        Client foundClient = null;
        for (Client client : clientList){
            if(client.getId().equals(clientId))
                foundClient = client;
        }
        return foundClient;
    }

    @Override
    public void deleteById(Integer clientId) {
        for (Client client : clientList){
            if (client.getId().equals(clientId))
                clientList.remove(client);
        }
    }
}
