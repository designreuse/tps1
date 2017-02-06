package igc.tech.com.utility;

/**
 * Created by tilak on 6/16/2016.
 */
public class Employee {

    private String id;
    private String managerId;

    public Employee(String id, String managerId) {
        this.id = id;
        this.managerId = managerId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", managerId='" + managerId + '\'' +
                '}';
    }
}
