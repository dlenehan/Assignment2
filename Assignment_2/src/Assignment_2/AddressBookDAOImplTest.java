package Assignment_2;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AddressBookDAOImplTest {

	@Before
	public void setUp() throws Exception {
		
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateAddress() {
		String fileName = System.getProperty("user.home")+"/addresses.csv";
		AddressBookDAOImpl adr = new AddressBookDAOImpl();
		
		Contact contact =  new Contact ("10","joe","bloggs","1 the main street",
				"new town","county here","0857788558");
		
		assertEquals(true, adr.createAddress(contact));
		assertNotNull(adr.addresses.toString());
		assertFalse(adr.addresses.isEmpty());
		
	}
	
	public void testgetContact(){
		
		
	}

}
