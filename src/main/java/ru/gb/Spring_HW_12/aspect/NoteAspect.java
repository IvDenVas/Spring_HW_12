package ru.gb.Spring_HW_12.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Aspect
@Component
public class NoteAspect {

    @After(value = "@annotation(TrackUserAction)")
    public void log(JoinPoint joinPoint){
        System.out.println("Метод: " + joinPoint.getSignature().getName() +", вызван: "+ LocalDateTime.now()
                + ". Данные: " + Arrays.toString(joinPoint.getArgs()));
    }
}