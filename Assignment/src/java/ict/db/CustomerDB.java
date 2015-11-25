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

    public CustomerDB(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public CustomerDB() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Connection getConnection() throws SQLException, IOException {
        System.setProperty("jsbc.drivers", "com.mysql.jdbc.Driver");
        return DriverManager.getConnection(url, username, password);
    }

    public ArrayList queryCustByLogName(String loginName) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        CustomerBean cb = null;
        ArrayList<CustomerBean> customers = new ArrayList();
        try {
            cnnct = getConnection();
            Statement stmt = cnnct.createStatement();
            String preQueryStatement = "SELECT * FROM Customer WHERE loginName = " + loginName;
            ResultSet rs = stmt.executeQuery(preQueryStatement);
            while (rs.next()) {
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
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return customers;
    }

    public void createCustTable() {
        Connection cnnct = null;
        Statement stmnt = null;

        try {
            cnnct = getConnection();
            stmnt = cnnct.createStatement();
            String sql
                    = "CREATE TABLE Client("
                    + "cltId VARCHAR(10) NOT NULL,"
                    + "cltPswd VARCHAR(10) NOT NULL,"
                    + "cltFullName VARCHAR(30) NOT NULL,"
                    + "cltTel VARCHAR(12) NOT NULL,"
                    + "deliveryAddress VARCHAR(50) NOT NULL,"
                    + "cltBounsPoint NUMERIC(6) NOT NULL,"
                    + "PRIMARY KEY(cltId)"
                    + ")";
            stmnt.execute(sql);

            sql
                    = "CREATE TABLE Staff("
                    + "staId VARCHAR(10) NOT NULL,"
                    + "staPswd VARCHAR(10) NOT NULL,"
                    + "staFullName VARCHAR(30) NOT NULL,"
                    + "staTel VARCHAR(12) NOT NULL,"
                    + "PRIMARY KEY(staId)"
                    + ")";
            stmnt.execute(sql);

            sql
                    = "CREATE TABLE Product("
                    + "productId VARCHAR(10) NOT NULL,"
                    + "productName VARCHAR(30) NOT NULL,"
                    + "productQty NUMERIC(4) NOT NULL,"
                    + "productPrice NUMERIC(5) NOT NULL,"
                    + "productImg VARCHAR(100) NOT NULL,"
                    + "PRIMARY KEY(productId)"
                    + ")";
            stmnt.execute(sql);

            sql
                    = "CREATE TABLE ClientLog("
                    + "cltId VARCHAR(10) NOT NULL,"
                    + "productId VARCHAR(10) NOT NULL,"
                    + "productQty NUMERIC(4) NOT NULL,"
                    + "PRIMARY KEY(cltId),"
                    + "FOREIGN KEY (productId) REFERENCES Product(productId)"
                    + ")";
            stmnt.execute(sql);

            sql
                    = "CREATE TABLE Category("
                    + "productId VARCHAR(10) NOT NULL,"
                    + "category VARCHAR(30) NOT NULL,"
                    + "PRIMARY KEY(productId),"
                    + "FOREIGN KEY (productId) REFERENCES Product(productId)"
                    + ")";
            stmnt.execute(sql);

            sql
                    = "CREATE TABLE history("
                    + "orderId VARCHAR(10) NOT NULL,"
                    + "cltId VARCHAR(10) NOT NULL,"
                    + "orderDate DATE NOT NULL,"
                    + "price VARCHAR(6) NOT NULL,"
                    + "productId VARCHAR(5) NOT NULL,"
                    + "productQty VARCHAR(4) NOT NULL,"
                    + "PRIMARY KEY(orderId),"
                    + "FOREIGN KEY (cltId) REFERENCES Client(cltId),"
                    + "FOREIGN KEY (productId) REFERENCES Product(productId)"
                    + ")";
            stmnt.execute(sql);
            stmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public boolean addClientRecord(String cltId, String cltPswd, String cltFullName, String cltTel, String deliveryAddress, int cltBounsPoint) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;

        try {
            cnnct = getConnection();
            String PreparedStatement = "INSERT INTO Client VALUES (?,?,?,?,?,?)";
            pStmnt = cnnct.prepareStatement(PreparedStatement);
            pStmnt.setString(1, cltId);
            pStmnt.setString(2, cltPswd);
            pStmnt.setString(3, cltFullName);
            pStmnt.setString(4, cltTel);
            pStmnt.setString(5, deliveryAddress);
            pStmnt.setInt(6, cltBounsPoint);
            int rowCount = pStmnt.executeUpdate();
            if (rowCount >= 1) {
                isSuccess = true;
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return isSuccess;
    }

    public boolean addStaffRecord(String staId, String staPswd, String staFullName, String staTel) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;

        try {
            cnnct = getConnection();
            String PreparedStatement = "INSERT INTO Staff VALUES (?,?,?,?)";
            pStmnt = cnnct.prepareStatement(PreparedStatement);
            pStmnt.setString(1, staId);
            pStmnt.setString(2, staPswd);
            pStmnt.setString(3, staFullName);
            pStmnt.setString(4, staTel);
            int rowCount = pStmnt.executeUpdate();
            if (rowCount >= 1) {
                isSuccess = true;
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return isSuccess;
    }

    public boolean addProductRecord(String productId, String productName, int productQty, int productPrice, String productImg) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;

        try {
            cnnct = getConnection();
            String PreparedStatement = "INSERT INTO Product VALUES (?,?,?,?,?)";
            pStmnt = cnnct.prepareStatement(PreparedStatement);
            pStmnt.setString(1, productId);
            pStmnt.setString(2, productName);
            pStmnt.setInt(3, productQty);
            pStmnt.setInt(4, productPrice);
            pStmnt.setString(5, productImg);
            int rowCount = pStmnt.executeUpdate();
            if (rowCount >= 1) {
                isSuccess = true;
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return isSuccess;
    }
    
    public boolean addCategoryRecord(String productId, String category) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;

        try {
            cnnct = getConnection();
            String PreparedStatement = "INSERT INTO Category VALUES (?,?)";
            pStmnt = cnnct.prepareStatement(PreparedStatement);
            pStmnt.setString(1, productId);
            pStmnt.setString(2, category);
            int rowCount = pStmnt.executeUpdate();
            if (rowCount >= 1) {
                isSuccess = true;
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return isSuccess;
    }
}
