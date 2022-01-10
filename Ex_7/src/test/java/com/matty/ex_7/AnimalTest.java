package com.matty.ex_7;

import com.matty.ex_7.service.IAnimal;
import com.matty.ex_7.service.Impl.Dog;
import org.junit.jupiter.api.Test;

public class AnimalTest {

    @Test
    public void AnimalTest(){
        Dog dog = new Dog();
        IAnimal proxyInstance = (IAnimal) ProxyFactory.getProxyInstance(dog);
        proxyInstance.eat();
    }
}
