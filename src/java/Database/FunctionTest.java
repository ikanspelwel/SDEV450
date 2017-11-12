/* 
 * Testing class for BaseDBFunctions4
 * Adam Flammino 11/4/17
 */
package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;


public class FunctionTest {

    public static void main(String args[]) {
        ResultSet rs = null;
        boolean flag;
        String host = "jdbc:mysql://sdev450.gmavt.net:3306";
        String username = "demo1";
        String password = "DirectSellDbAccess1234";
        Calendar calendar = Calendar.getInstance();
        String insert = "insert into demo1.USERS(EMAIL, FULL_NAME, PASSWORD, SALT, "
                + "ZIP, RECOVERY_KEY, DATE_JOINED) VALUES('test4', 'RealName1', "
                + "0000000000000000000000000000000000000000000000000000000000000003, "
                + "1111111114, 12348, 126, NOW())";
        String select = "select * from demo1.USERS";
        BaseDBFunctions dbTest = new BaseDBFunctions();
        try {
            dbTest.connect(host, username, password);
        } catch (Exception e) {
            System.out.println("Connection failed!");
            return;
        }

        System.out.println("Connected successfully! ");
        try{
            dbTest.executeSQL(insert, true);
            System.out.printf("Query %s successful!\n", insert);
        } catch (Exception e){
            System.out.printf("Query %s failed: %s\n", insert, e.getMessage());
            return;
        }
        try{
            dbTest.executeSQL(select, false);
            System.out.printf("Query %s successful!\n", select);
            rs = dbTest.getResults();
        } catch (Exception e){
            System.out.printf("Query %s failed: %s\n", select, e.getMessage());
            return;
        }
            try{
            while (rs.next()){
             System.out.printf("%d %s %s %s %s %d %s %s \n", rs.getInt("UID"), rs.getString("EMAIL"),
                     rs.getString("FULL_NAME"), rs.getString("PASSWORD"), 
                     rs.getString("SALT"), rs.getInt("ZIP"), rs.getString("RECOVERY_KEY"), 
                     rs.getDate("DATE_JOINED"));  
            }
            }
            catch (SQLException err){
            System.out.println(err.getMessage());
            }
        }
    }
