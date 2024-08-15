package ru.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.dto.ClientDTO;
import ru.models.Client;
import ru.repositories.ClientRepository;

import java.util.List;

@Component
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    @Autowired
    public void setClientRepository(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    @Override
    public String execute() {
        return clientRepository.execute();
    }

    public List<Client> getAllClients(){
        return clientRepository.findAllClients();
    }

    @Override
    public void addClient(ClientDTO clientDTO) {
        Client client = Client.builder()
                .firstName(clientDTO.getFirstName())
                .lastName(clientDTO.getLastName())
                .money(clientDTO.getMoney())
                .role(clientDTO.getRole())
                .car(clientDTO.getCar())
                .build();
        clientRepository.save(client);
    }

    @Override
    public Client getClient(Integer clientId) {
        return clientRepository.findById(clientId);
    }

    @Override
    public void updateClient(Integer clientId, ClientDTO clientDTO) {
        Client client = clientRepository.findById(clientId);
        client.setRole(client.getRole());
        client.setCar(clientDTO.getCar());
        clientRepository.deleteById(clientId);
        clientRepository.save(client);
    }

    @Override
    public void deleteClient(Integer clientId) {
        clientRepository.deleteById(clientId);
    }


}
