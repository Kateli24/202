package dao;

import domain.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.TreeSet;

/**
 *
 * @author liji8162
 */
public class ProductDataManager implements ProductDao{
	private static String TcpConnection = "jdbc:h2:tcp://localhost:8067/project;IFEXISTS=TRUE";
	
	public ProductDataManager(){
	}
	
	public ProductDataManager(String connection){
		this.TcpConnection = TcpConnection;
	}

	@Override
	public void addProduct(Product product) {
		String sql = "insert into product (id, name,description,category,price,quantity) values (?,?,?,?,?,?)";
		
		try(
				  Connection dbCon = JdbcConnection.getConnection(TcpConnection);
				  PreparedStatement stmt = dbCon.prepareStatement(sql);
				  )
		{
			stmt.setInt(1,product.getId());
			stmt.setString(2,product.getName());
			stmt.setString(3,product.getDescription());
			stmt.setString(4,product.getCategory());
			stmt.setBigDecimal(5,product.getPrice());
			stmt.setInt(6,product.getQuantity());
			stmt.executeUpdate();
		}
		catch(SQLException ex){
			throw new RuntimeException(ex);
		}
			
		}
				  

	@Override
	public void deleteProduct(Product product) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public Product findProduct(Integer id) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public Collection<String> getCategories() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public Collection<Product> getProducts() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public TreeSet<Product> productsByCategory(String category) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}
