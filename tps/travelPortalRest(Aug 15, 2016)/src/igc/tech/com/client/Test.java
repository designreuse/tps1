package igc.tech.com.client;

import sun.tools.jar.Main;

/**
 * Created by tilak on 4/18/2016.
 */
public class Test {

    public static void main(String[] args) {

      //  System.out.println(new Test().primeCount(10,30));



/*10 30 ==>6*/



    }


    public   int primeCount(int start, int end){

        int count=0;
        int status=0;

        for (int i=start;i<=end;i++){

            for (int x=2;x<=i/2;x++){

                if (i%x==0){
                    status=1;
                    break;
                }
            }

            if(status==0){
                count++;
            }


        }

        return  count;

    }
}
