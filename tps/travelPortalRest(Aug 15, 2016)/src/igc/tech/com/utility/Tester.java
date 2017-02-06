package igc.tech.com.utility;


import igc.tech.com.model.ResponseModel;

import java.io.IOException;

public class Tester {


    public static void main(String[] args){


        Person person=new Person();
        person.setFirstName("ram");
        person.setLastName("sharma");



        System.out.println(person.getClass().getAnnotations());


    }

}


