package com.furniture.shopping.model.pojo;

public class Role {
    private Long roleId;

    private Long roleType;

    private String roleDesc;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getRoleType() {
        return roleType;
    }

    public void setRoleType(Long roleType) {
        this.roleType = roleType;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc == null ? null : roleDesc.trim();
    }
}