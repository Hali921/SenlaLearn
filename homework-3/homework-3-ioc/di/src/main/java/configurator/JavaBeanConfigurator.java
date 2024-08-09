package configurator;

import org.reflections.Reflections;

import java.util.Set;

public class JavaBeanConfigurator implements BeanConfigurator{

    Reflections scanner;

    public JavaBeanConfigurator(String packageToScan){
        this.scanner = new Reflections(packageToScan);
    }



    @Override
    public <T> Class<? extends T> getImplementationClass(Class<T> intefaceClass) {
        Set<Class<? extends T>> implementationClasses = scanner.getSubTypesOf(intefaceClass);

        if(implementationClasses.size() != 1){
            throw new RuntimeException("Interface has 0 or more than 1 implementations");
        }

        return implementationClasses.stream().findFirst().get();
    }
}
