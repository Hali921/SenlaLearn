package ru.services;

import ru.dto.ClientDTO;
import ru.models.Client;

import java.util.List;

public interface ClientService {
    String execute();
    List<Client> getAllClients();

    void addClient(ClientDTO clientDTO);

    Client getClient(Integer clientId);

    void updateClient(Integer clientId, ClientDTO clientDTO);

    void deleteClient(Integer clientId);
}
