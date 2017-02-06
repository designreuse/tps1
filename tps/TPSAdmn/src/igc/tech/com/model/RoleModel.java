package igc.tech.com.model;

/**
 * Created by DELL on 2/1/2016.
 */
public class RoleModel {

    private String roleDescription,roleId;

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "RoleModel{" +
                "roleDescription='" + roleDescription + '\'' +
                ", roleId='" + roleId + '\'' +
                '}';
    }
}

