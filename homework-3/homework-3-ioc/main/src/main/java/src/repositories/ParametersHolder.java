package src.repositories;



/*@Component
@PropertySource("application.properties")*/
public class ParametersHolder {

    //@Value("${my.param.db}")
    private String someText;

    public String getSomeText() {
        return someText;
    }
}
