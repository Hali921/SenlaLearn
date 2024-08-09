package factory;

import annotatioin.Autowired;
import config.Configuration;
import config.JavaConfiguration;
import configurator.BeanConfigurator;
import configurator.JavaBeanConfigurator;
import context.ApplicationContext;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class BeanFactory {

    private final Configuration configuration;
    private final BeanConfigurator beanConfigurator;
    private ApplicationContext applicationContext;

    public BeanFactory(ApplicationContext applicationContext){
        this.configuration = new JavaConfiguration();
        this.beanConfigurator = new JavaBeanConfigurator(configuration.getPackageToScan());
        this.applicationContext = applicationContext;
    }



    public <T> T getBean(Class<T> clazz){
        Class<? extends T> implementationClass = clazz;
        if(implementationClass.isInterface()){
            implementationClass = beanConfigurator.getImplementationClass(implementationClass);
        }

        try {
            T bean = implementationClass.getDeclaredConstructor().newInstance();
            for(Field field : Arrays.stream(implementationClass.getDeclaredFields())
                    .filter(field -> field.isAnnotationPresent(Autowired.class))
                    .collect(Collectors.toList())) {
                field.setAccessible(true);
                field.set(bean, applicationContext.getBean(implementationClass));

            }


            return bean;


        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }


    }
}
