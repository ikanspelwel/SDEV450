/*
 * Testing class for BaseDBFunctions4
 * Adam Flammino 11/4/17
 */
package Database;


public class functionTest {

    public static void main(String args[]) {
        boolean flag;
        String host = "jdbc:mysql://sdev450.gmavt.net:3306";
        String username = "demo1";
        String password = "DirectSellDbAccess1234";
        BaseDBFunctions dbTest = new BaseDBFunctions();
        flag = dbTest.connect(host, username, password);
        if (flag){
            System.out.println("Connected successfully! ");
        }
        else{
            System.out.println("Connection failed!");
        }

    }
}
