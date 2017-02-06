package igc.tech.com.validate;


import java.util.ArrayList;
import java.util.List;

public class Tester {


    public static void main(String[] args){


       List<ValidData> validDatas=new ArrayList<>();

        validDatas.add(new ValidData("name", "ra", new ValidType()));
        validDatas.add(new ValidData("email", "abc@gmail.com", new ValidType(true, false, false)));
        validDatas.add(new ValidData("phone No", "9841483331asdasd", new ValidType(true, true,  false)));

        List<ValidData> validDatas1=  new Validation().test(validDatas);

       for (ValidData validData:validDatas1){
           System.out.println(validData.toString());

       }

    }

}


