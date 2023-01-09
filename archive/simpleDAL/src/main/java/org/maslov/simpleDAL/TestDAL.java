package org.maslov.simpleDAL;

import java.math.BigDecimal;
import java.sql.*;


public class TestDAL {
    private Connection connection;
    static String createBooksSQLcmd = "CREATE TABLE BOOKS (Title CHAR(60), ISBN CHAR(13)," +
            " Publisher_ID CHAR(4), Price DECIMAL(10,2));";

    static String insertIntoTableBooksCmd = "INSERT INTO BOOKS VALUES(?, ?, ?, ?)";
    static String selectFromTableBooksCmd = "SELECT * FROM BOOKS;";
    public TestDAL() {
        ConnectionManager cm = new ConnectionManager();
        connection = cm.getConnection();
    }

    void insertIntoTableBOOKS() {
        try {
            PreparedStatement pst = connection.prepareStatement(insertIntoTableBooksCmd);
            String title = "Title " + (int) (100 * Math.random());
            String isbn = "ISBN " + (int) (100 * Math.random());
            String publisher_id = new Integer((int)(10000 * Math.random())).toString();
            BigDecimal bd = new BigDecimal((int)(100 * Math.random()));

            pst.setString(1, title);
            pst.setString(2, isbn);
            pst.setString(3, publisher_id);
            pst.setBigDecimal(4, bd);
            pst.executeUpdate();
        }
        catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }
    void createBooksTable() {
        try (Statement st = connection.createStatement()) {
            st.executeUpdate(createBooksSQLcmd);
        }
        catch (SQLException se) {
            System.out.println(se.getStackTrace());
        }
    }
    void selectBooksTable() {
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(selectFromTableBooksCmd);
            while (rs.next()) {
               String title = rs.getString("Title");
               String ISBN = rs.getString("ISBN");
               String Publisher_ID = rs.getString("Publisher_ID");
               BigDecimal price = rs.getBigDecimal("Price");
               System.out.println("Title" + title);
               System.out.println("ISBN" + ISBN);
               System.out.println("Publisher_ID" + Publisher_ID);
               System.out.println("Price" + price);
            }
        }
        catch (SQLException se) {
            System.out.println(se.getStackTrace());
        }
    }
    void perform() {
        //createBooksTable();
        //for (int i = 0; i < 10; ++i) {
        //    insertIntoTableBOOKS();
        //}
        selectBooksTable();
    }
}
