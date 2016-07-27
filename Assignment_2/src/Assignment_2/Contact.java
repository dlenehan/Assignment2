package Assignment_2;


public class Contact {
	private String contact_id;
	private String firstname;
	private String surname;
	private String address_line_1;
	private String address_line_2;
	private String address_line_3;
	private String mobile;

	public Contact(){
		
	}
	
	public Contact(String contact_id, String firstname, String surname, String address_line_1, String address_line_2,
			String address_line_3, String mobile) {
		super();
		this.contact_id = contact_id;
		this.firstname = firstname;
		this.surname = surname;
		this.address_line_1 = address_line_1;
		this.address_line_2 = address_line_2;
		this.address_line_3 = address_line_3;
		this.mobile = mobile;
	}
	
	
		public String getContact_id() {
		return contact_id;
	}

	public void setContact_id(String contact_id) {
		this.contact_id = contact_id;
	}

		public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getAddress_line_1() {
		return address_line_1;
	}
	public void setAddress_line_1(String address_line_1) {
		this.address_line_1 = address_line_1;
	}
	public String getAddress_line_2() {
		return address_line_2;
	}
	public void setAddress_line_2(String address_line_2) {
		this.address_line_2 = address_line_2;
	}
	public String getAddress_line_3() {
		return address_line_3;
	}
	public void setAddress_line_3(String address_line_3) {
		this.address_line_3 = address_line_3;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	 @Override
	public String toString() {
		return "Contact [contact_id=" + contact_id + ", firstname=" + firstname + ", surname=" + surname
				+ ", address_line_1=" + address_line_1 + ", address_line_2=" + address_line_2 + ", address_line_3="
				+ address_line_3 + ", mobile=" + mobile + "]";
	}

	    @Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((address_line_1 == null) ? 0 : address_line_1.hashCode());
			result = prime * result + ((address_line_2 == null) ? 0 : address_line_2.hashCode());
			result = prime * result + ((address_line_3 == null) ? 0 : address_line_3.hashCode());
			result = prime * result + ((contact_id == null) ? 0 : contact_id.hashCode());
			result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
			result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
			result = prime * result + ((surname == null) ? 0 : surname.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Contact other = (Contact) obj;
			if (address_line_1 == null) {
				if (other.address_line_1 != null)
					return false;
			} else if (!address_line_1.equals(other.address_line_1))
				return false;
			if (address_line_2 == null) {
				if (other.address_line_2 != null)
					return false;
			} else if (!address_line_2.equals(other.address_line_2))
				return false;
			if (address_line_3 == null) {
				if (other.address_line_3 != null)
					return false;
			} else if (!address_line_3.equals(other.address_line_3))
				return false;
			if (contact_id != other.contact_id)
				return false;
			if (firstname == null) {
				if (other.firstname != null)
					return false;
			} else if (!firstname.equals(other.firstname))
				return false;
			if (mobile == null) {
				if (other.mobile != null)
					return false;
			} else if (!mobile.equals(other.mobile))
				return false;
			if (surname == null) {
				if (other.surname != null)
					return false;
			} else if (!surname.equals(other.surname))
				return false;
			return true;
		}

		 public int compare(Contact c1, Contact c2) {
			    return c1.contact_id.compareTo(c2.contact_id);
			  }

		
		

		
	    
	    

}
