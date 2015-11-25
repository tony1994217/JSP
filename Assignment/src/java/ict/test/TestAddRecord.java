/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.test;

import ict.db.CustomerDB;

/**
 *
 * @author WAISIK
 */
public class TestAddRecord {

    public static void main(String[] arg) {
        String url = "jdbc:mysql://localhost:3306/ITP4511_ASSIGNMENT_DB";
        String username = "root";
        String password = "";
        CustomerDB custDb = new CustomerDB(url, username, password);

        custDb.addClientRecord("c0001", "0000", "Tony Sit", "+85268795423", "Tsing Yi", 0);
        custDb.addClientRecord("c0002", "1111", "Noob Cho", "+85298762341", "Sha Tin", 0);
        custDb.addClientRecord("c0003", "2222", "jimmy Chan", "+85251213417", "Tsuen Wan", 0);
        custDb.addClientRecord("c0004", "3333", "Peter Ho", "+85291236521", "Mong Kok", 0);
        custDb.addClientRecord("c0005", "4444", "May Choi", "+85267778821", "Tsim Sha Tsui", 0);

        custDb.addStaffRecord("s0001", "0000", "waisik", "+85212345678");

        custDb.addProductRecord("p0001", "G2", 57, 15, "../abc.");
        custDb.addProductRecord("p0002", "WEX", 75, 12, "../abc.");
        custDb.addProductRecord("p0003", "ACROBALL", 88, 14, "../abc.");
        custDb.addProductRecord("p0004", "vicuna", 96, 10, "../abc.");
        custDb.addProductRecord("p0015", "Whiteboard Marker", 67, 20, "../abc.");
        custDb.addProductRecord("p0016", "Sign Pen", 87, 18, "../abc.");
        custDb.addProductRecord("p0005", "Straightedge", 24, 5, "../abc.");
        custDb.addProductRecord("p0006", "Tiechi", 64, 20, "../abc.");
        custDb.addProductRecord("p0007", "Triangle ruler", 42, 14, "../abc.");
        custDb.addProductRecord("p0029", "T-square", 42, 20, "../abc.");
        custDb.addProductRecord("p0008", "eraser", 73, 5, "../abc.");
        custDb.addProductRecord("p0009", "Adhesive", 52, 15, "../abc.");
        custDb.addProductRecord("p0026", "Glue Stick", 48, 14, "../abc.");
        custDb.addProductRecord("p0010", "Tape Dispenser", 17, 30, "../abc.");
        custDb.addProductRecord("p0024", "Adhesive Tape", 43, 4, "../abc.");
        custDb.addProductRecord("p0025", "Double Side Tape", 23, 7, "../abc.");
        custDb.addProductRecord("p0011", "Clips holder", 42, 3, "../abc.");
        custDb.addProductRecord("p0018", "Paper Clips", 58, 4, "../abc.");
        custDb.addProductRecord("p0019", "Binder Clips", 42, 2, "../abc.");
        custDb.addProductRecord("p0020", "Clips", 34, 2, "../abc.");
        custDb.addProductRecord("p0012", "Pen Holder", 10, 20, "../abc.");
        custDb.addProductRecord("p0013", "Correction Fluid", 30, 15, "../abc.");
        custDb.addProductRecord("p0014", "Correction Tape", 30, 14, "../abc.");
        custDb.addProductRecord("p0017", "pen bag", 20, 20, "../abc.");
        custDb.addProductRecord("p0021", "Scissors", 40, 10, "../abc.");
        custDb.addProductRecord("p0022", "Cutters", 50, 6, "../abc.");
        custDb.addProductRecord("p0023", "Cutting Mat", 10, 30, "../abc.");
        custDb.addProductRecord("p0027", "Stapler", 30, 20, "../abc.");
        custDb.addProductRecord("p0028", "Punch", 30, 17, "../abc.");

        custDb.addCategoryRecord("p0001", "pen");
        custDb.addCategoryRecord("p0002", "pen");
        custDb.addCategoryRecord("p0003", "pen");
        custDb.addCategoryRecord("p0004", "pen");
        custDb.addCategoryRecord("p0015", "pen");
        custDb.addCategoryRecord("p0016", "pen");
        custDb.addCategoryRecord("p0005", "measure");
        custDb.addCategoryRecord("p0006", "measure");
        custDb.addCategoryRecord("p0007", "measure");
        custDb.addCategoryRecord("p0029", "measure");
        custDb.addCategoryRecord("p0008", "rubber");
        custDb.addCategoryRecord("p0009", "adhesive");
        custDb.addCategoryRecord("p0026", "adhesive");
        custDb.addCategoryRecord("p0010", "adhesive");
        custDb.addCategoryRecord("p0024", "adhesive");
        custDb.addCategoryRecord("p0025", "adhesive");
        custDb.addCategoryRecord("p0011", "clip");
        custDb.addCategoryRecord("p0018", "clip");
        custDb.addCategoryRecord("p0019", "clip");
        custDb.addCategoryRecord("p0020", "clip");
        custDb.addCategoryRecord("p0012", "Pen Holder");
        custDb.addCategoryRecord("p0013", "corr");
        custDb.addCategoryRecord("p0014", "corr");
        custDb.addCategoryRecord("p0017", "pen bag");
        custDb.addCategoryRecord("p0021", "cut");
        custDb.addCategoryRecord("p0022", "cut");
        custDb.addCategoryRecord("p0023", "cut");
        custDb.addCategoryRecord("p0027", "binding");
        custDb.addCategoryRecord("p0028", "binding");
    }
}
