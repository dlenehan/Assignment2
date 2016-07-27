package Assignment_2;

import java.util.Comparator;

class MyComparator implements Comparator<Contact> {

	  public int compare(Contact c1, Contact c2) {
	    return c1.getContact_id().compareTo(c2.getContact_id());
	  }
	}