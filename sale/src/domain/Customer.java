package domain;

/**
 *
 * @author liji8162
 */
public class Customer {
	private String username;
	private String name;
	private String email;
	private String shippingAddress;
	private String creditCardDetail;
	private String password;

	public String getUsername() {
		return username;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public String getCreditCardDetail() {
		return creditCardDetail;
	}

	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public void setCreditCardDetail(String creditCardDetail) {
		this.creditCardDetail = creditCardDetail;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer{" + "username=" + username + ", name=" + name + ", email=" + email + '}';
	}
	
	
	
}
