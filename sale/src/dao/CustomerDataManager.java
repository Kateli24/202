package dao;

import domain.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author liji8162
 */
public class CustomerDataManager implements CustomerDao{
	private static String connection = "jdbc:h2:tcp://localhost:8067/project;IFEXISTS=TRUE";
	
	
	@Override
	public void save(Customer customer){
		String sql = "merge into customer(username, name,email,shippingAddress,creditCardDetail,password) values (?,?,?,?,?,?)";

		try (
				  Connection dbCon = JdbcConnection.getConnection(connection);
				  PreparedStatement stmt = dbCon.prepareStatement(sql);) {
			stmt.setString(1, customer.getUsername());
			stmt.setString(2, customer.getName());
			stmt.setString(3, customer.getEmail());
			stmt.setString(4, customer.getShippingAddress());
			stmt.setString(5, customer.getCreditCardDetail());
			stmt.setString(6, customer.getPassword());
			stmt.executeUpdate();
		} catch (SQLException ex) {
			throw new DAOException(ex.getMessage(),ex);
		}

	}
	
	@Override
	public Customer getCustomer(String userName) {
		String sql = "select * from customer where userName = ?";
		try (
				  Connection dbCon = JdbcConnection.getConnection(connection);
				  PreparedStatement stmt = dbCon.prepareStatement(sql);) {
			stmt.setString(1, userName);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				String username = rs.getString("userName");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String shippingAddress = rs.getString("shippingAddress");
				String creditCardDetail = rs.getString("creditCardDetail");
				String password = rs.getString("password");
				Customer aCustomer = new Customer(username,name,email,shippingAddress,creditCardDetail,password);
						  return aCustomer;
			}
			return null;
		} catch (SQLException ex) {
			throw new DAOException(ex.getMessage(), ex);	
	}
	}

	@Override
	public Boolean validateCredentials(String userName, String password) {
		String sql = "select * from customer where userName = ?";
		try (
				  Connection dbCon = JdbcConnection.getConnection(connection);
				  PreparedStatement stmt = dbCon.prepareStatement(sql);) {
			stmt.setString(1, userName);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				String thePassword = rs.getString("password");
				if(thePassword.equals(password)){
					return true;
				}
				else{
					return false;
				}
			}
			return null;
		} catch (SQLException ex) {
			throw new DAOException(ex.getMessage(), ex);	
	}
}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}