package Assignment_2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class AddressBookDAOImpl implements AddressBookDAO{
	
	HashMap<Integer, Contact> addresses;
	Contact contact = new Contact();
	private String path;
	int namekey = 0;
	
	
	
	
	public AddressBookDAOImpl(String filename){
		path = filename;
		
		try{
			
			FileHandler rf  = new FileHandler(path);
			addresses = rf.readAddresses();
			
		}
		catch (IOException e){
			System.out.println(e.getMessage());
		}
	}

	@Override
	public boolean createAddress(Contact contact) {
		namekey = contact.hashCode();	
		System.out.println("hashcode: " + namekey);
		addresses.put(namekey, contact);
		System.out.println("created an address");
		return true;
	}

	@Override
	public void getContact(String surname) {
		
		for (int key: addresses.keySet()){
			if (addresses.get(key).getSurname().equals(surname)){
				System.out.println("found it!!");
				System.out.println("here it is: " 
              + addresses.get(key).getFirstname()+ " ,"
			  + addresses.get(key).getSurname() + " ,"
			  + addresses.get(key).getAddress_line_1() + " ,"
			  + addresses.get(key).getAddress_line_2() + " ,"
			  + addresses.get(key).getAddress_line_3() + " ,"
			  + addresses.get(key).getMobile());
		
			}
		
		}
		
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
		// TODO Auto-generated method stub
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
