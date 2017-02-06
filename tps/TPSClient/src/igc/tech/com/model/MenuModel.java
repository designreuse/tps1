package igc.tech.com.model;

/**
 * Created by Ganga on 7/19/2016.
 */
public class MenuModel {

    private String menuAccessId, roleId, menuId;
    private String menuDesc, roleDesc, menuUrl, parentMenuId, parentMenuDesc;

    public String getMenuAccessId() {
        return menuAccessId;
    }

    public void setMenuAccessId(String menuAccessId) {
        this.menuAccessId = menuAccessId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getMenuDesc() {
        return menuDesc;
    }

    public void setMenuDesc(String menuDesc) {
        this.menuDesc = menuDesc;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getParentMenuId() {
        return parentMenuId;
    }

    public void setParentMenuId(String parentMenuId) {
        this.parentMenuId = parentMenuId;
    }

    public String getParentMenuDesc() {
        return parentMenuDesc;
    }

    public void setParentMenuDesc(String parentMenuDesc) {
        this.parentMenuDesc = parentMenuDesc;
    }

    @Override
    public String toString() {
        return "MenuAccessModel{" +
                "menuAccessId='" + menuAccessId + '\'' +
                ", roleId='" + roleId + '\'' +
                ", menuId='" + menuId + '\'' +
                ", menuDesc='" + menuDesc + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                ", menuUrl='" + menuUrl + '\'' +
                ", parentMenuId='" + parentMenuId + '\'' +
                ", parentMenuDesc='" + parentMenuDesc + '\'' +
                '}';
    }
}
