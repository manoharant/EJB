package com.foshanshop.ejb3.impl;

import com.foshanshop.ejb3.SecurityAccess;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote ({SecurityAccess.class})
public class SecurityAccessBean implements SecurityAccess{

    @RolesAllowed({"AdminUser"})
    public String AdminUserMethod() {    
        return "具有管理员角色的用户才可以访问AdminUserMethod()方法";
    }

    @RolesAllowed({"DepartmentUser"})
    public String DepartmentUserMethod() {
        return "具有事业部门角色的用户才可以访问DepartmentUserMethod()方法";
    }

    @PermitAll
    public String AnonymousUserMethod() {
        return "任何角色的用户都可以访问AnonymousUserMethod()方法";
    }  
}
