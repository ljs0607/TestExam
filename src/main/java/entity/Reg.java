package entity;

import java.util.Vector;

public class Reg {
    private boolean isLogin = false;//是否登录
    private String adminUsername = "";//用户名
    private Vector adminPower = null;//权限
    private String adminRealName = "";//真实姓名
    private String SysLTime = "";//登录时间
    private String unitid;//所在单位编号
    public boolean isLogin() {
        return isLogin;
    }
    public void setLogin(boolean isLogin) {
        this.isLogin = isLogin;
    }
    public String getAdminUsername() {
        return adminUsername;
    }
    public void setAdminUsername(String adminUsername) {
        this.adminUsername = adminUsername;
    }
    public Vector getAdminPower() {
        return adminPower;
    }
    public void setAdminPower(Vector adminPower) {
        this.adminPower = adminPower;
    }
    public String getAdminRealName() {
        return adminRealName;
    }
    public void setAdminRealName(String adminRealName) {
        this.adminRealName = adminRealName;
    }
    public String getSysLTime() {
        return SysLTime;
    }
    public void setSysLTime(String sysLTime) {
        SysLTime = sysLTime;
    }
    public String getUnitid() {
        return unitid;
    }
    public void setUnitid(String unitid) {
        this.unitid = unitid;
    }
    }

