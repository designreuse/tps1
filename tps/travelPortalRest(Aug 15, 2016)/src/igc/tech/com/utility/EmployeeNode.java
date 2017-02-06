package igc.tech.com.utility;

import java.util.List;

/**
 * Created by tilak on 6/16/2016.
 */
public class EmployeeNode {
    private String id;
    private List<EmployeeNode> directReports;

    public EmployeeNode() {
    }

    public EmployeeNode(String id) {
        this.id = id;
    }

    public EmployeeNode(String id, List<EmployeeNode> directReports) {
        this.id = id;
        this.directReports = directReports;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<EmployeeNode> getDirectReports() {
        return directReports;
    }

    public void setDirectReports(List<EmployeeNode> directReports) {
        this.directReports = directReports;
    }

    @Override
    public String toString() {
        return "EmployeeNode{" +
                "id='" + id + '\'' +
                ", directReports=" + directReports +
                '}';
    }
}
