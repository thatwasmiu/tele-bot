package daste.telebot;

import lombok.NonNull;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class SpringContextUtils implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(@NonNull ApplicationContext applicationContext) throws BeansException {
        SpringContextUtils.applicationContext = applicationContext;
    }

    public static Object getBean(String name) {
        return applicationContext.getBean(name);
    }

    public static <T> T getBean(Class<T> requiredType) {
        return applicationContext.getBean(requiredType);
    }

    public static <T> T getBean(String name, Class<T> requiredType) {
        return applicationContext.getBean(name, requiredType);
    }

    public static boolean containsBean(String name) {
        return applicationContext.containsBean(name);
    }

    public static boolean isSingleton(String name) {
        return applicationContext.isSingleton(name);
    }

    public static Class<?> getType(String name) {
        return applicationContext.getType(name);
    }

    public static List<String> getBeanNamePrefix(String prefixName) {
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        List<String> result = Arrays.stream(beanNames)
                .filter(name -> name.startsWith(prefixName))
                .map(name -> name.substring(Constant.Batch.PREFIX.length()))
                .collect(Collectors.toList());
        return Optional.of(result).orElse(new ArrayList<>());
    }

    public static List<String> getMethodsNameOfBean(String beanName) {
        Object obj = applicationContext.getBean(beanName);
        Method[] methods = obj.getClass().getDeclaredMethods();
        return Arrays.stream(methods)
                .map(Method::getName)
                .collect(Collectors.toList());
    }
}
