package src.repositories;


import annotatioin.Autowired;

//@Component
public class ClientRepositoryImpl implements ClientRepository{

    @Autowired
    private ParametersHolder parametersHolder;


    public String execute(){
        return parametersHolder.getSomeText();
    }

}
