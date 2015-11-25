/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.db;

import ict.bean.CustomerBean;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author tony
 */
public class CustomerDB {
    private String url = "";
    private String username = "";
    private String password = "";
    
    public CustomerDB(String url, String username, String password){
        this.url = url;
        this.username = username;
        this.password = password;
    }
    
     public CustomerDB() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Connection getConnection() throws SQLException, IOException{
        System.setProperty("jsbc.drivers", "com.mysql.jdbc.Driver");
        return DriverManager.getConnection(url, username, password);
    }
    
     public ArrayList queryCustByLogName(String loginName){
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        CustomerBean cb = null;
        ArrayList<CustomerBean> customers = new ArrayList(); 
        try{
            cnnct = getConnection();
            Statement stmt = cnnct.createStatement();
            String preQueryStatement = "SELECT * FROM Customer WHERE loginName = " + loginName;
            ResultSet rs = stmt.executeQuery(preQueryStatement);
            while(rs.next()){
                cb = new CustomerBean();
                cb.setCustId(rs.getString("custId"));
                cb.setLoginName(rs.getString("loginName"));
                cb.setLoginPswd(rs.getString("loginPswd"));
                cb.setCustFullName(rs.getString("custFullName"));
                cb.setCustTel(rs.getString("custTel"));
                cb.setCustAddress(rs.getString("custAddress"));
                cb.setCustDOB(rs.getString("custDOB"));
                customers.add(cb);
            }
            rs.close();
            cnnct.close();
        }catch(SQLException ex){
            while(ex != null){
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
        return customers;
        
    }
}
