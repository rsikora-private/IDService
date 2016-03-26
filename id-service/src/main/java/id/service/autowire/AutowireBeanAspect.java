package id.service.autowire;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

/**
 * Created by robertsikora on 26.03.2016.
 */

@Aspect
@Component
public class AutowireBeanAspect {

    @Autowired
    private AutowireCapableBeanFactory autowireCapableBeanFactory;

    @Before("execution(* id..*ServiceImpl.*(..))\")")
    public void logServiceAccess(final JoinPoint joinPoint) {
        final Object[] args = joinPoint.getArgs();
        Stream.of(args).forEach(t -> autowireCapableBeanFactory.autowireBean(t));
    }
}