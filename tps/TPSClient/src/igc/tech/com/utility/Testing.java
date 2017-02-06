package igc.tech.com.utility;

import sun.awt.SunToolkit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tilak on 6/16/2016.
 */
public class Testing {


    public  void check(EmployeeNode employeeNode, List<Employee> employees){

        List<EmployeeNode> employeeNodes=new ArrayList<>();

        int count=0;

        while (!(employees.size()==count) ){

            Employee employee=employees.get(count);

            if (employee.getManagerId().equals(employeeNode.getId())){
                employeeNodes.add(new EmployeeNode(employee.getId()));
                employees.remove(count);
            }
            else
            {
                count++;
            }

        }



        if (!employeeNodes.isEmpty()){

            employeeNode.setDirectReports(employeeNodes);

            for(EmployeeNode employeeNode1:employeeNode.getDirectReports()){

                check(employeeNode1,employees);
            }
        }

        }



    public static void main(String[] args) {
        List<Employee> employees=new ArrayList<>();

        employees.add(new Employee("3",null));
        employees.add(new Employee("1","3"));
        employees.add(new Employee("2","3"));
        employees.add(new Employee("6","1"));
        employees.add(new Employee("8","2"));
        employees.add(new Employee("11","8"));

        EmployeeNode employeeNode=new EmployeeNode();

        String mainParent=null;

        boolean parent=false;

        // get and set paretent id

        for (Employee employee:employees){
            if (employee.getManagerId()==null){
                mainParent=employee.getId();
                employeeNode.setId(employee.getId());
                employees.remove(employee);
                parent=true;
                break;
            }
        }
        // end and set get paretent id

       /* while (!employees.isEmpty()){

          List<EmployeeNode> employeeNodes=employeeNode.getDirectReports();
            if (!employeeNodes.isEmpty()){

                for (EmployeeNode employeeNode1:employeeNodes){

                    new Testing().check(employeeNode1,employees);

                }

            }

            if (parent==true){
               new Testing().check(employeeNode,employees);
                parent=false;
            }


        }*/

        System.out.println(employeeNode.toString());

        new Testing().check(employeeNode,employees);

        System.out.println(employeeNode.toString());

    }

}
