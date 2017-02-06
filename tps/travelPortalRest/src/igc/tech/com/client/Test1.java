package igc.tech.com.client;

import com.sun.corba.se.impl.oa.toa.TOA;
import igc.tech.com.model.RoomDetailModel;

import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tilak on 4/18/2016.
 */
public class Test1 {


    public static void  access(String location,String checkInDate,String checkOutDate,int noOfRoom,
                        int noOfAdult, int noOfChild, int[] age,List<RoomDetailModel> roomDetailModels){


       // System.out.println("test"+roomDetailModels.toString());

        int actualAdult ;
        int actualChild ;
        int minAge;
        int totalGuest;


        for (RoomDetailModel roomDetailModel : roomDetailModels) {

            actualAdult=noOfAdult;
            actualChild=0;
            minAge=6;
            totalGuest=0;

            if (noOfChild!=0){
                for (int x : age) {

                    if (x <= minAge) {
                        actualChild++;
                    } else {

                        actualAdult++;
                    }

                }

            }

            System.out.println("room name:"+roomDetailModel.getCustomName());
            System.out.println("rate:"+Integer.parseInt(roomDetailModel.getRate())*noOfRoom );
            System.out.println("no of rooms:"+noOfRoom );
            System.out.println("noOfGuest:"+Integer.parseInt(roomDetailModel.getNoOfGuest())*noOfRoom );
            System.out.println("extra Adult:"+Integer.parseInt(roomDetailModel.getExtraAdult())*noOfRoom );
            System.out.println("extra child:"+Integer.parseInt(roomDetailModel.getExtraChild())*noOfRoom );


            totalGuest=actualAdult+actualChild;

            System.out.println("===>  actual adult:"+actualAdult+"actual child:"+actualChild+"Total Guest:"+ totalGuest);

            if (totalGuest <= (Integer.parseInt(roomDetailModel.getNoOfGuest())*noOfRoom )  ) {

                System.out.println("Status: room Selected with fixed price."+"no of rooms:"+noOfRoom);
            }
            else  if (actualAdult<  (Integer.parseInt(roomDetailModel.getNoOfGuest())*noOfRoom ) ){

                int remGuest=(Integer.parseInt(roomDetailModel.getNoOfGuest())*noOfRoom ) -actualAdult;

                int effChild=actualChild-remGuest;

                if ( effChild<=(Integer.parseInt(roomDetailModel.getExtraChild()) ) *noOfRoom  ){

                    System.out.println("Status: room Selected with extra price of child added."+effChild +". No of rooms:"+noOfRoom);

                }

            }

            else  if (actualAdult==(Integer.parseInt(roomDetailModel.getNoOfGuest()))*noOfRoom ){

                if ( actualChild<=(Integer.parseInt(roomDetailModel.getExtraChild()) )*noOfRoom ){

                    System.out.println("Status: room Selected with extra price of child added."+actualChild+". no of room:"+noOfRoom);

                }

            }

            else  if (actualAdult>(Integer.parseInt(roomDetailModel.getNoOfGuest())*noOfRoom )  ){

                int effAdult=actualAdult-(Integer.parseInt(roomDetailModel.getNoOfGuest())*noOfRoom );


                if (effAdult<=(Integer.parseInt(roomDetailModel.getExtraAdult())*noOfRoom ) && actualChild<=(Integer.parseInt(roomDetailModel.getExtraChild())*noOfRoom ) ){

                    System.out.println("Status: room Selected with extra price of adult:"+effAdult+" and child :"+actualChild+". no of room:"+noOfRoom);
                }

            }



            System.out.println("*--------------------------------------------------*");




        }

    }
    public static void main(String[] args) {

        List<RoomDetailModel> roomDetailModels = new ArrayList<>();


        RoomDetailModel roomDetailModel = new RoomDetailModel();
        roomDetailModel.setCustomName("room1");
        roomDetailModel.setRate("50");
        roomDetailModel.setNoOfGuest("2");
        roomDetailModel.setExtraAdult("2");
        roomDetailModel.setExtraChild("2");
        roomDetailModels.add(roomDetailModel);

        roomDetailModel = new RoomDetailModel();
        roomDetailModel.setCustomName("room2");
        roomDetailModel.setRate("55");
        roomDetailModel.setNoOfGuest("2");
        roomDetailModel.setExtraAdult("2");
        roomDetailModel.setExtraChild("2");
        roomDetailModels.add(roomDetailModel);

        roomDetailModel = new RoomDetailModel();
        roomDetailModel.setCustomName("room3");
        roomDetailModel.setRate("60");
        roomDetailModel.setNoOfGuest("4");
        roomDetailModel.setExtraAdult("2");
        roomDetailModel.setExtraChild("2");
        roomDetailModels.add(roomDetailModel);

        roomDetailModel = new RoomDetailModel();
        roomDetailModel.setCustomName("room4");
        roomDetailModel.setRate("65");
        roomDetailModel.setNoOfGuest("6");
        roomDetailModel.setExtraAdult("2");
        roomDetailModel.setExtraChild("2");
        roomDetailModels.add(roomDetailModel);

        roomDetailModel = new RoomDetailModel();
        roomDetailModel.setCustomName("room5");
        roomDetailModel.setRate("70");
        roomDetailModel.setNoOfGuest("8");
        roomDetailModel.setExtraAdult("2");
        roomDetailModel.setExtraChild("2");
        roomDetailModels.add(roomDetailModel);


        roomDetailModel = new RoomDetailModel();
        roomDetailModel.setCustomName("room6");
        roomDetailModel.setRate("75");
        roomDetailModel.setNoOfGuest("10");
        roomDetailModel.setExtraAdult("3");
        roomDetailModel.setExtraChild("2");
        roomDetailModels.add(roomDetailModel);


        int noOfRoom=1;
        int noOfAdult=4;
        int noOfChild=0;
        int[] childAges=new int[]{ 7, 5, 6, 7};


        access(null,null,null,noOfRoom,noOfAdult,noOfChild,childAges,roomDetailModels);
    }


/*

    public static void main(String[] args) {

        List<RoomDetailModel> roomDetailModels = new ArrayList<>();


        RoomDetailModel roomDetailModel = new RoomDetailModel();
        roomDetailModel.setCustomName("room1");
        roomDetailModel.setRate("50");
        roomDetailModel.setNoOfGuest("2");
        roomDetailModel.setExtraAdult("2");
        roomDetailModel.setExtraChild("2");
        roomDetailModels.add(roomDetailModel);

        roomDetailModel = new RoomDetailModel();
        roomDetailModel.setCustomName("room2");
        roomDetailModel.setRate("55");
        roomDetailModel.setNoOfGuest("2");
        roomDetailModel.setExtraAdult("2");
        roomDetailModel.setExtraChild("2");
        roomDetailModels.add(roomDetailModel);

        roomDetailModel = new RoomDetailModel();
        roomDetailModel.setCustomName("room3");
        roomDetailModel.setRate("60");
        roomDetailModel.setNoOfGuest("4");
        roomDetailModel.setExtraAdult("2");
        roomDetailModel.setExtraChild("2");
        roomDetailModels.add(roomDetailModel);

        roomDetailModel = new RoomDetailModel();
        roomDetailModel.setCustomName("room4");
        roomDetailModel.setRate("65");
        roomDetailModel.setNoOfGuest("6");
        roomDetailModel.setExtraAdult("2");
        roomDetailModel.setExtraChild("2");
        roomDetailModels.add(roomDetailModel);

        roomDetailModel = new RoomDetailModel();
        roomDetailModel.setCustomName("room5");
        roomDetailModel.setRate("70");
        roomDetailModel.setNoOfGuest("8");
        roomDetailModel.setExtraAdult("2");
        roomDetailModel.setExtraChild("2");
        roomDetailModels.add(roomDetailModel);


        roomDetailModel = new RoomDetailModel();
        roomDetailModel.setCustomName("room6");
        roomDetailModel.setRate("75");
        roomDetailModel.setNoOfGuest("10");
        roomDetailModel.setExtraAdult("3");
        roomDetailModel.setExtraChild("2");
        roomDetailModels.add(roomDetailModel);

        // System.out.println(roomDetailModels.toString());

        int actualRate=0;

        int noOfRoom = 1;
        int noOfAdult = 3;
        int noOfChild = 6;

        int actualAdult = noOfAdult;
        int actualChild = 0;

        int extraAdultCharge = 10;
        int extraChildCharge = 5;

        int[] age = new int[]{5, 6, 7, 5, 6, 7};

        for (int x : age) {

            if (x <= 6) {
                actualChild++;
            } else {

                actualAdult++;
            }

        }


        System.out.println("actual Adult:" + actualAdult + "actual Child:" + actualChild);

        int totalGuest = actualAdult + actualChild;

        System.out.println("totalGuest:" + totalGuest);

        List<RoomDetailModel> roomDetailModels1 = new ArrayList<>();

        for (RoomDetailModel roomDetailModel1 : roomDetailModels) {
            System.out.println(roomDetailModel1.toString());

            if (totalGuest <= Integer.parseInt(roomDetailModel1.getNoOfGuest())) {
                roomDetailModel1.setStatus("fixed charge");
                roomDetailModel1.setFinalCharge(roomDetailModel1.getRate());
                roomDetailModels1.add(roomDetailModel1);
            }

            else if (totalGuest <= (Integer.parseInt(roomDetailModel1.getNoOfGuest()) + Integer.parseInt(roomDetailModel1.getExtraAdult()) + Integer.parseInt(roomDetailModel1.getExtraChild()))) {


                roomDetailModel1.setStatus("extra charge" + "extra adult:" + (actualAdult - Integer.parseInt(roomDetailModel1.getNoOfGuest())) + "extra child:" + actualChild);
                System.out.println(Integer.parseInt(roomDetailModel1.getRate()));
                System.out.println(extraAdultCharge * (actualAdult - Integer.parseInt(roomDetailModel1.getNoOfGuest())));
                System.out.println(extraChildCharge * actualChild);

                int finalChg = Integer.parseInt(roomDetailModel1.getRate()) + extraAdultCharge * (actualAdult - Integer.parseInt(roomDetailModel1.getNoOfGuest())) + extraChildCharge * actualChild;

                System.out.println(finalChg);


                roomDetailModel1.setFinalCharge(String.valueOf(finalChg));


                roomDetailModels1.add(roomDetailModel1);
            }


        }

        System.out.println("*********************************************************");

        //  System.out.println(roomDetailModels1.toString());


        for (RoomDetailModel roomDetailModel1 : roomDetailModels1) {
            System.out.println("final:" + roomDetailModel1.toString());


        }


    }
*/

}

