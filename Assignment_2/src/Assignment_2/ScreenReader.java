package Assignment_2;


import java.util.List;
import java.util.Scanner;

public class ScreenReader {
	
	int answer = 0;
	
	int value;
	int namekey = 0;
	String namein;
	String nextkey;
	String contct_id, cont_id; 
	String fileName = System.getProperty("user.home")+"/addresses.csv";
	

	MenuDisplay menu = new MenuDisplay();	
	Scanner sc = new Scanner(System.in);
	AddressBookDAOImpl adr = new AddressBookDAOImpl(fileName);
	
	
	
	public void readOptions(){
		while (answer != 7){
		
			menu.displayMenu();
			
			
			answer = sc.nextInt();
			Contact contact = new Contact();
			

			switch (answer){
			case 1: 
				nextkey = adr.getNextKey();
				contact = getAddress(nextkey);
				System.out.println("contact is : " + contact);
				
				boolean created = adr.createAddress(contact);
				System.out.println("Created" + created);
				
				break;
			case 2:  List<Contact> list = adr.getAllAddresses();
			         adr.printAddresses(list);
			break;
			case 3: System.out.println("Please enter number of name you wish to delete. ");
			value = sc.nextInt();
			contct_id = Integer.toString(value);
			value = adr.findKey(contct_id);
			adr.deleteAddress(value);
			System.out.println("Address is deleted from address book.");
			break;
			case 4:  
				List<Contact> lista = adr.getAllAddresses();
		         adr.printAddresses(lista);
				System.out.println("Please select number of"
						+ " address to be changed");
				value = sc.nextInt();
				cont_id = Integer.toString(value);
				value = adr.findKey(cont_id);
				adr.deleteAddress(value);
				nextkey = adr.getNextKey();
				contact = getAddress(nextkey);
				System.out.println("contact is : " + contact);
				
				boolean crted = adr.createAddress(contact);
				System.out.println("Address has been updated."
				+ crted);
				
				break;	
			case 5:
				System.out.println("Writing csv file:");
				adr.saveUpdates(fileName);
				break;
			case 6:
				System.out.println("Please enter surname. ");
				namein = sc.next();
				adr.getContact(namein);
				break;
			case 7: System.exit(0);
			sc.close();
			default: System.out.println("Please enter a number between 1 and 5.");
			menu.displayMenu();
			
			
		}

	}
	}
	
	
	public Contact getAddress(String contct_id){
		
		
        String contact_id = contct_id;
		System.out.println("Enter firstname: ");
		String firstname =sc.next();
		System.out.println("Enter surname: ");
		String surname =sc.next();
		sc.nextLine();
		System.out.println("Enter address 1: ");
		String address_line_1 =sc.nextLine();
		sc.nextLine();
		
		System.out.println("Enter address 2: ");
		String address_line_2 =sc.nextLine();
		
		System.out.println("Enter address 3: ");
		String address_line_3 =sc.nextLine();
		System.out.println("Enter mobile");
		String mobile =sc.nextLine();
		
		
		return new Contact(contact_id,firstname,surname,address_line_1,
				address_line_2, address_line_3, mobile);
	}

}
