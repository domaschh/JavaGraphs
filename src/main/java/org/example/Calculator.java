package org.example;

import java.util.function.Function;

public class Calculator {
    static int multiply(int num1, int num2) {
        return num1*num2;
    }

    public static <T, R> R executeCalculationFunction(Function<T,R> function, T someparameter){
        return function.apply(someparameter);
    }

}


interface SomeInterface {
    int something();
}
