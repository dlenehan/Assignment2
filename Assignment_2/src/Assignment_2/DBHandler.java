package Assignment_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class DBHandler {

    Connection conn;            
    HashMap<Integer, Contact> adr = new HashMap<Integer,Contact>();
    int value;
    
   
    public DBHandler(String db_file_name_prefix) throws Exception {    
        
        Class.forName("org.hsqldb.jdbcDriver");
        
        conn = DriverManager.getConnection("jdbc:hsqldb:"
                                           + db_file_name_prefix,    // filenames
                                           "sa",                     // username
                                           "");                      // password
    }

    public void shutdown() throws SQLException {

        Statement st = conn.createStatement();        
        st.execute("SHUTDOWN");
        conn.close();   
    }

//use for SQL command SELECT
    public synchronized void query(String expression) throws SQLException {

        Statement st = null;
        ResultSet rs = null;

        st = conn.createStatement();         
        
        rs = st.executeQuery(expression);    // run the query
        
        while (rs.next()) { 
            HashMap<Integer, Contact> adr= new HashMap<Integer, Contact>();
            String contact_id = rs.getString("contact_id");
            String firstname=rs.getString("firstname");
            String surname=rs.getString("surname");
            String address_line_1=rs.getString("adr1");
            String address_line_2 = rs.getString("adr2");
            String address_line_3 = rs.getString("adr3");
            String mobile = rs.getString("mobile");
            Contact contact = new Contact(contact_id,firstname,surname,address_line_1,address_line_2,
            		address_line_3,mobile);
             value = contact.hashCode();
            adr.put(value, contact);
        }
        

  
    }

//use for SQL commands CREATE, DROP, INSERT and UPDATE
    public synchronized void update(String expression) throws SQLException {

        Statement st = null;

        st = conn.createStatement();    // statements
        System.out.println("before....");
        int i = st.executeUpdate(expression);    // run the query
        System.out.println("after...");
        if (i == -1) {
            System.out.println("db error : " + expression);
        }
        
        st.close();
    }    // void update()

    public static void dump(ResultSet rs) throws SQLException {

        // the order of the rows in a cursor
        // are implementation dependent unless you use the SQL ORDER statement
        ResultSetMetaData meta   = rs.getMetaData();
        int               colmax = meta.getColumnCount();
        int               i;
        Object            o = null;

        // the result set is a cursor into the data.  You can only
        // point to one row at a time
        // assume we are pointing to BEFORE the first row
        // rs.next() points to next row and returns true
        // or false if there is no next row, which breaks the loop
        for (; rs.next(); ) {
            for (i = 0; i < colmax; ++i) {
                o = rs.getObject(i + 1);    // Is SQL the first column is indexed

                // with 1 not 0
                System.out.print(o.toString() + " ");
            }

            System.out.println(" ");
        }
    }
    
    








}                                      //void dump( ResultSet rs )

   