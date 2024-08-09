package src.services;


import annotatioin.Autowired;
import src.repositories.ClientRepository;

//@Component
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
}
