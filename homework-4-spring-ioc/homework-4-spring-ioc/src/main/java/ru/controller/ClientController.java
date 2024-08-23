package ru.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.dto.ClientDTO;
import ru.models.Client;
import ru.services.ClientService;

import java.util.List;

@Component
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }


    public String execute(){
        return clientService.execute();
    }

    @SneakyThrows
    public String getAllClients(){
        List<Client> clients = clientService.getAllClients();

        String clientsJson = new ObjectMapper().writeValueAsString(clients);

        return clientsJson;
    }


    public void addClient(ClientDTO clientDTO){
        clientService.addClient(clientDTO);
    }

    @SneakyThrows
    public String getClient(Integer clientId){
        Client client = clientService.getClient(clientId);

        return new ObjectMapper().writeValueAsString(client);


    }

    public void updateClient(Integer clientId, ClientDTO clientDTO){
        clientService.updateClient(clientId, clientDTO);
    }

    public void deleteClient(Integer clientId){
        clientService.deleteClient(clientId);
    }

}
