package Assignment_2;

import java.util.*;

public interface AddressBookDAO {
	boolean createAddress(Contact c);
	void getContact(String key);
	List<Contact> getAllAddresses();
	boolean updateAddress(String key);
	boolean deleteAddress(Integer keycode);
	Integer findKey(String key);

}
