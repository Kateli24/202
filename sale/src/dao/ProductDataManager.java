package dao;

import domain.Product;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

/**
 *
 * @author liji8162
 */
public class ProductDataManager implements ProductDao {

	private static String TcpConnection = "jdbc:h2:tcp://localhost:8067/project;IFEXISTS=TRUE";

	public ProductDataManager() {
	}

	public ProductDataManager(String connection) {
		ProductDataManager.TcpConnection = connection;
	}

	@Override
	public void addProduct(Product product) {
		String sql = "merge into product (PRODUCT_ID, name,description,category,price,quantity) values (?,?,?,?,?,?)";

		try (
				  Connection dbCon = JdbcConnection.getConnection(TcpConnection);
				  PreparedStatement stmt = dbCon.prepareStatement(sql);) {
			stmt.setInt(1, product.getId());
			stmt.setString(2, product.getName());
			stmt.setString(3, product.getDescription());
			stmt.setString(4, product.getCategory());
			stmt.setBigDecimal(5, product.getPrice());
			stmt.setInt(6, product.getQuantity());
			stmt.executeUpdate();
		} catch (SQLException ex) {
			throw new DAOException(ex.getMessage(),ex);
		}

	}

	@Override
	public void deleteProduct(Product product) {
		String sql = "delete from product where product_id = ?";
		try (
				  Connection dbCon = JdbcConnection.getConnection(TcpConnection);
				  PreparedStatement stmt = dbCon.prepareStatement(sql);) {
			stmt.setInt(1, product.getId());
			stmt.executeUpdate();
		} catch (SQLException ex) {
			throw new DAOException(ex.getMessage(),ex);

		}
	}

	@Override
	public Product findProduct(Integer id) {
		String sql = "select * from product where Product_id = ?";
		try (
				  Connection dbCon = JdbcConnection.getConnection(TcpConnection);
				  PreparedStatement stmt = dbCon.prepareStatement(sql);) {
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				Integer productId = rs.getInt("product_id");
				String productName = rs.getString("name");
				String productDescription = rs.getString("description");
				String productCategory = rs.getString("category");
				BigDecimal productPrice = rs.getBigDecimal("price");
				Integer productQuantity = rs.getInt("quantity");
				Product searchedProduct = new Product(productId, productName,
						  productDescription, productCategory, productPrice, productQuantity);
				return searchedProduct;
			}
			return null;
		} catch (SQLException ex) {
			throw new DAOException(ex.getMessage(), ex);

		}
	}

	@Override
	public TreeSet<String> getCategories() {
		String sql = "select category from product order by category";

		try (
				  Connection dbCon = JdbcConnection.getConnection(TcpConnection);
				  PreparedStatement stmt = dbCon.prepareStatement(sql);) {
			ResultSet rs = stmt.executeQuery();
			TreeSet<String> myCategories = new TreeSet<>();
			while (rs.next()) {
				String category = rs.getString("category");
				myCategories.add(category);
			}
			return myCategories;
		} catch (SQLException ex) {
			throw new DAOException(ex.getMessage(),ex);
		}
	}

	@Override
	public Collection<Product> getProducts() {
		String sql = "select * from product order by PRODUCT_ID";

		try (
				  Connection dbCon = JdbcConnection.getConnection(TcpConnection);
				  PreparedStatement stmt = dbCon.prepareStatement(sql);) {
			ResultSet rs = stmt.executeQuery();
			List<Product> myProducts = new ArrayList<>();
			while (rs.next()) {
				Integer PRODUCT_ID = rs.getInt("product_id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				String category = rs.getString("category");
				BigDecimal price = rs.getBigDecimal("price");
				Integer quantity = rs.getInt("quantity");

				Product aProduct = new Product(PRODUCT_ID, name, description, category, price, quantity);
				myProducts.add(aProduct);
			}
			return myProducts;
		} catch (SQLException ex) {
			throw new DAOException(ex.getMessage(),ex);
		}
	}

	@Override
	public TreeSet<Product> productsByCategory(String category) {
		String sql = "select * from product where category = ? order by product_id";
		try (
				  Connection dbCon = JdbcConnection.getConnection(TcpConnection);
				  PreparedStatement stmt = dbCon.prepareStatement(sql);) {
			stmt.setString(1, category);
			TreeSet<Product> productsHaveSameCategory = new TreeSet<>();
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Integer productId = rs.getInt("product_id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				String theCategory = rs.getString("category");
				BigDecimal price = rs.getBigDecimal("price");
				Integer quantity = rs.getInt("quantity");
				Product aProduct = new Product(productId, name, description, theCategory, price, quantity);

				productsHaveSameCategory.add(aProduct);
			}
			return productsHaveSameCategory;
		} catch (SQLException ex) {
			throw new DAOException(ex.getMessage(),ex);
		}
	}
}
