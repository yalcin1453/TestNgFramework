package com.techproed.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOnMethods {
    @Test
    public void login(){
        System.out.println("login");

    }@Test
    public void homePage(){
        System.out.println("homePage");


    }@Test()
    public void search(){
        System.out.println("search");

    }@Test
    public void result(){
        System.out.println("result");


    }










}
