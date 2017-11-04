/*
 * Testing class for BaseDBFunctions4
 * Adam Flammino 11/4/17
 */
package Database;

import java.util.Calendar;


public class functionTest {

    public static void main(String args[]) {
        boolean flag;
        String host = "jdbc:mysql://sdev450.gmavt.net:3306";
        String username = "demo1";
        String password = "DirectSellDbAccess1234";
        Calendar calendar = Calendar.getInstance();
        String insert = "insert into demo1.USERS(EMAIL, FULL_NAME, PASSWORD, SALT, "
                + "ZIP, RECOVERY_KEY, DATE_JOINED) VALUES('test3', 'RealName', "
                + "0000000000000000000000000000000000000000000000000000000000000002, "
                + "1111111113, 12347, 125, NOW())";
        
        // 
        BaseDBFunctions dbTest = new BaseDBFunctions();
        flag = dbTest.connect(host, username, password);
        if (flag){
            System.out.println("Connected successfully! ");
        }
        else{
            System.out.println("Connection failed!");
        }
        flag = dbTest.executeSQL(insert, true);
        if (flag){
            System.out.println("Data inserted!");
        }
        else{
            System.out.println("Insert failed!");
        }
    }
}
