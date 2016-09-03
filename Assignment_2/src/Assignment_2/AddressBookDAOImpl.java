package Assignment_2;

import java.io.IOException;
import java.sql.Connection;	
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class AddressBookDAOImpl implements AddressBookDAO{
	
	HashMap<Integer, Contact> addresses;
	Contact contact = new Contact();
	int namekey = 0;
	
	
	
	
	public AddressBookDAOImpl(){
		
		DBHandler db = null;

		try {
			db = new DBHandler();
		} catch (Exception ex1) {
			ex1.printStackTrace();    // could not start db

			return;                   // bye bye
		}

		
		try {

			// add some rows - will create duplicates if run more then once
			// the id column is automatically generated
			db.update(
					"INSERT INTO addresses(contact_id, firstname, surname, address_line_1, address_line_2, address_line_3, mobile)"
							+ " VALUES('3','Peter','Smith','1 the main street','newtown','co dublin','0877601406')");

			db.update(
					"INSERT INTO addresses(contact_id, firstname, surname, address_line_1, address_line_2, address_line_3, mobile)"
							+ " VALUES('4','Jack','Byrne','2 the main street','newtown','co dublin','0877601406')");

			
			// do a query
			addresses = db.loadAddresses("SELECT * FROM addresses");




			// at end of program
			db.shutdown();
		} catch (SQLException ex3) {
			ex3.printStackTrace();
		}
	}   // main()

	
    // class DBHandler

	

	@Override
	public boolean createAddress(Contact contact) {
		namekey = contact.hashCode();	
		System.out.println("hashcode: " + namekey);
		addresses.put(namekey, contact);
		System.out.println("created an address");
		return true;
	}

	@Override
	public Contact getContact(String surname) {
		
		for (int key: addresses.keySet()){
			if (addresses.get(key).getSurname().equals(surname)){
				System.out.println("found it!!");
				System.out.println("here it is: "); 
			    contact = addresses.get(key);
		
			}
		
		}
	return contact;	
	}

	@Override
	public void printContact(Contact contact){
		System.out.println("Here goes: " + contact.getContact_id() + " "
				+ contact.getFirstname() +
				contact.getSurname() + "," +
	            contact.getAddress_line_1() + "," +
	            contact.getAddress_line_2() + "," +
	            contact.getAddress_line_3() + "," +
	            contact.getMobile() + ".") ;
				
		
	}
	
	
	@Override
	public List<Contact> getAllAddresses() {
		Collection<Contact> contacts = addresses.values();
		System.out.println("addresses values: " + contacts);
		List<Contact> list = new ArrayList<>(contacts);
		Collections.sort(list, new MyComparator());
		return list;
	}

	public void printAddresses(List<Contact> list){
		for (Iterator<Contact> it = list.iterator(); it.hasNext();) {
            Contact cntct = (Contact) it.next();
            System.out.println(cntct.getContact_id() + "." +
            cntct.getFirstname() + " " +
            cntct.getSurname() + "," +
            cntct.getAddress_line_1() + "," +
            cntct.getAddress_line_2() + "," +
            cntct.getAddress_line_3() + "," +
            cntct.getMobile() + ".") ;
          }
	}
	
	
	@Override
	public boolean updateAddress(String filename) {
		FileHandler wr = new FileHandler(filename);
		
		wr.writeCsvFile(filename,addresses);
		return true;
	}

	@Override
	public Integer findKey(String contct_id) {
		int value = 0;
		
		for (int key: addresses.keySet()){
			
			if (addresses.get(key).getContact_id().equals(contct_id)){
				System.out.println("found it!!");
				System.out.println("key = " + key);
				value = key;
				
				
			}
		}
		
		return value;
	}
	
	public boolean deleteAddress(Integer key){
		addresses.remove(key);
		return true;
	}
	
	
	
	public String getNextKey() {
			
		 int max_key = 0;
		 int contct_id;
		 int counter;
		 String nextkey;
		                for (int key: addresses.keySet()){
		                      contct_id = Integer.parseInt(addresses.get(key).getContact_id());
		                         if (contct_id > max_key){
		                             max_key = contct_id;
		                        }
		                }
		                System.out.println("Max key: " + max_key);
		                counter = max_key;		
						counter = counter + 1;
						nextkey = Integer.toString(counter);
		        return nextkey;
		        
		        }
	
	
	
	
	public void saveUpdates(String filename){
		FileHandler wr = new FileHandler(filename);
	
		wr.writeCsvFile(filename,addresses);

		
	}

}
