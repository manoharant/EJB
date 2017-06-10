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
        return "���й���Ա��ɫ���û��ſ��Է���AdminUserMethod()����";
    }

    @RolesAllowed({"DepartmentUser"})
    public String DepartmentUserMethod() {
        return "������ҵ���Ž�ɫ���û��ſ��Է���DepartmentUserMethod()����";
    }

    @PermitAll
    public String AnonymousUserMethod() {
        return "�κν�ɫ���û������Է���AnonymousUserMethod()����";
    }  
}
