package domain;

import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotNull;

/**
 *
 * @author liji8162
 */
public class Customer {
	@NotNull(message = "userName must be provided.")
	@NotBlank(message = "userName must be provided.")
	private String username;
	@NotNull(message = "Name must be provided.")
	@NotBlank(message = "Name must be provided.")
	private String name;
	@NotNull(message = "email must be provided.")
	@NotBlank(message = "email must be provided.")
	private String email;
	@NotNull(message = "Address must be provided.")
	@NotBlank(message = "Address must be provided.")
	private String shippingAddress;
	@NotNull(message = "credit card details must be provided.")
	@NotBlank(message = "credit card details must be provided.")
	private String creditCardDetail;
	@NotNull(message = "Password must be provided.")
	@NotBlank(message = "Password must be provided.")
	private String password;

	public Customer(String username, String name, String email, String shippingAddress, String creditCardDetail, String password) {

		this.username = username;
		this.name = name;
		this.email = email;
		this.shippingAddress = shippingAddress;
		this.creditCardDetail = creditCardDetail;
		this.password = password;
	}

	public Customer() {
	}

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
