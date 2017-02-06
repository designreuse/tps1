package npay;

import igc.tech.com.utility.Employee;
import igc.tech.com.utility.EmployeeNode;
import org.us.booking.UnitedSolutions;
import org.us.booking.UnitedSolutionsService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tilak on 6/16/2016.
 */
public class Testing {



    public static void main(String[] args) {



        Service service=new Service();
        ServiceSoap serviceSoap=service.getServiceSoap();

        TransactionStatus transactionStatus=     serviceSoap.checkTransactionStatus("105","1234564","icgtech_uat",
               "3367E240B90AC610EE1E93C320442CD3278B3A74630C7D6D82BA563FAB2FA292",
               "148F5D6BF851E7E81C0032E5F00087D0835A9E12644BF67A43C7F9DCB6530C4F","103396237268");

        System.out.println(transactionStatus.toString());





     /*   <npay:ValidateMerchant>
        <!--Optional:-->
        <npay:MerchantId>105</npay:MerchantId>
        <!--Optional:-->
        <npay:MerchantTxnId>1234564</npay:MerchantTxnId>
        <!--Optional:-->
        <npay:MerchantUserName>icgtech_uat</npay:MerchantUserName>
        <!--Optional:-->
        <npay:MerchantPassword>3367E240B90AC610EE1E93C320442CD3278B3A74630C7D6D82BA563FAB2FA292</npay:MerchantPassword>
        <!--Optional:-->
        <npay:Signature>148F5D6BF851E7E81C0032E5F00087D0835A9E12644BF67A43C7F9DCB6530C4F</npay:Signature>
        <!--Optional:-->
        <npay:AMOUNT>10</npay:AMOUNT>
        <!--Optional:-->
        <npay:purchaseDescription>test</npay:purchaseDescription>
        </npay:ValidateMerchant>*/


    }

}
