package Assignment_2;

import java.util.*;

public interface AddressBookDAO {
	boolean createAddress(Contact c);
	Contact getContact(String key);
	List<Contact> getAllAddresses();
	boolean updateAddress(String key);
	boolean deleteAddress(Integer keycode);
	void printContact(Contact c);
	Integer findKey(String key);

}
