package com.matty.ex_7.service.Impl;

import com.matty.ex_7.service.IAnimal;

public class Dog implements IAnimal {
    @Override
    public void eat() {
        System.out.println("I am eating!");
    }
}
