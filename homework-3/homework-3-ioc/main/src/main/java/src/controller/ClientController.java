package src.controller;


import annotatioin.Autowired;
import src.services.ClientService;


public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }


    public String execute(){
        return clientService.execute();
    }



}
