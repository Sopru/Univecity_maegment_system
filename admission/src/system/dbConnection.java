package system;

import java.sql.*;


/**
 * the method is for handling the connection with the database and the server in
 * this case we have local host
 * 
 * we have the connection and from this class we handel the sql and the return
 * from the database and send it back to see it
 */
public class dbConnection {
    private static final String USERNAME = "";
    private static final String PASSWORD = "";
    private static final String CON = "jdb:mysql://localhost/ums";

    public static Connection getConnection() throws SQLException {


        return DriverManager.getConnection(CON, USERNAME, PASSWORD);
    }

    private static Statement myStamen;

    public static Statement getMyStamen() {
        return myStamen;
    }

    static {
        try {
            myStamen = getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * development only
     */

    public boolean login(String userName, String password) throws SQLException {
        ResultSet rs = myStamen.executeQuery("select * FROM login");
        if (rs.next()) {
            return rs.getString("username").contains(userName) && rs.getString("password").contains(password);
        }
        return false;
    }



}
