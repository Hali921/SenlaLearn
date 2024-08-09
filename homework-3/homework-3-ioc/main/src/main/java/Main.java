

import context.ApplicationContext;
import factory.BeanFactory;
import src.controller.ClientController;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ApplicationContext();
        BeanFactory beanFactory = new BeanFactory(context);
        context.setBeanFactory(beanFactory);

        ClientController controller = context.getBean(ClientController.class);
        System.out.println(controller.execute());





    }
}
