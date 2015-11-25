package ict.bean;

import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tony
 */
public class CustomerBean implements Serializable{
    private String custId, loginName, loginPswd, custFullName, custTel, custAddress, custDOB;
    
    public CustomerBean(){
        
    }
    
    public CustomerBean(String custId, String loginName, String loginPswd, String custFullName, String custTel, String custAddress, String custDOB){
        this.custId = custId;
        this.loginName = loginName;
        this.loginPswd = loginPswd;
        this.custFullName = custFullName;
        this.custTel = custTel;
        this.custAddress = custAddress;
        this.custDOB = custDOB;
    }

    /**
     * @return the custId
     */
    public String getCustId() {
        return custId;
    }

    /**
     * @param custId the custId to set
     */
    public void setCustId(String custId) {
        this.custId = custId;
    }

    /**
     * @return the loginName
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * @param loginName the loginName to set
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * @return the loginPswd
     */
    public String getLoginPswd() {
        return loginPswd;
    }

    /**
     * @param loginPswd the loginPswd to set
     */
    public void setLoginPswd(String loginPswd) {
        this.loginPswd = loginPswd;
    }

    /**
     * @return the custTel
     */
    public String getCustTel() {
        return custTel;
    }

    /**
     * @param custTel the custTel to set
     */
    public void setCustTel(String custTel) {
        this.custTel = custTel;
    }

    /**
     * @return the custAddress
     */
    public String getCustAddress() {
        return custAddress;
    }

    /**
     * @param custAddress the custAddress to set
     */
    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    /**
     * @return the custDOB
     */
    public String getCustDOB() {
        return custDOB;
    }

    /**
     * @param custDOB the custDOB to set
     */
    public void setCustDOB(String custDOB) {
        this.custDOB = custDOB;
    }

    /**
     * @return the custFullName
     */
    public String getCustFullName() {
        return custFullName;
    }

    /**
     * @param custFullName the custFullName to set
     */
    public void setCustFullName(String custFullName) {
        this.custFullName = custFullName;
    }
            
}
