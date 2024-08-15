package ru.repositories;

import ru.models.Client;

import java.util.List;

public interface ClientRepository {
    String execute();
    List<Client> findAllClients();

    void save(Client client);

    Client findById(Integer clientId);

    void deleteById(Integer clientId);
}
