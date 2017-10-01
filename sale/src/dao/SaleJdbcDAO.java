package dao;

import dao.DAOException;
import dao.SaleDAO;
import domain.Customer;
import domain.Product;
import domain.Sale;
import domain.SaleItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SaleJdbcDAO implements SaleDAO {

	private static final String url = "jdbc:h2:tcp://localhost:8067/project;IFEXISTS=TRUE";

	@Override
	public void save(Sale sale) {

		Connection con = JdbcConnection.getConnection(url);
		try {
			try (
					PreparedStatement insertOrderStmt = con.prepareStatement(
							"merge into sale (PRODUCT_ID, username,date) values (?,?,?)",
							Statement.RETURN_GENERATED_KEYS);

					PreparedStatement insertOrderItemStmt = con.prepareStatement(
							"merge into sale_item(Product_ID,quantityPurchased,purchasePrice)values (?,?,?)");

					PreparedStatement updateProductStmt = con.prepareStatement(
							"UPDATE sale_item SET quantityPurchased = '?' WHERE Product_ID = ?");

					) {

				// since saving and order involves multiple statements across
				// multiple tables we need to control the transaction ourselves
				// to ensure our DB remains consistent
				// turn off auto-commit which effectively starts a new transaction
				con.setAutoCommit(false);

				Customer customer = sale.getCustomer();

				// #### save the order ### //

				// add a date to the sale if one doesn't already exist
				if(sale.getDate() == null) {
					sale.setDate(new Date());
				}

				// convert sale date into to java.sql.Timestamp
				Date date = sale.getDate();
				Timestamp timestamp = new Timestamp(date.getTime());


				// ****
				// write code here that saves the timestamp and username in the
				// sale table using the insertOrderStmt statement.
				// ****
				insertOrderStmt.setString(2,customer.getUsername());
				insertOrderStmt.setTimestamp(3, timestamp);


				// get the auto-generated order ID from the database
				ResultSet rs = insertOrderStmt.getGeneratedKeys();

				Integer orderId = null;

				if (rs.next()) {
					orderId = rs.getInt(1);
				} else {
					throw new DAOException("Problem getting generated Order ID");
				}

				// ## save the order items ## //

				Collection<SaleItem> items = sale.getItems();


				// ****
				// write code here that iterates through the order items and
				// saves them using the insertOrderItemStmt statement.
				// ****


				// ## update the product quantities ## //
				for (SaleItem item : items) {

					Product product = item.getProduct();


					// ****
					// write code here that updates the product quantity using
					// the using the updateProductStmt statement.
					// ****


				}

				// commit the transaction
				con.setAutoCommit(true);
			}
		} catch (SQLException ex) {

			Logger.getLogger(SaleJdbcDAO.class.getName()).log(Level.SEVERE, null, ex);

			try {
				// something went wrong so rollback
				con.rollback();

				// turn auto-commit back on
				con.setAutoCommit(true);

				// and throw an exception to tell the user something bad happened
				throw new DAOException(ex.getMessage(), ex);
			} catch (SQLException ex1) {
				throw new DAOException(ex1.getMessage(), ex1);
			}

		} finally {
			try {
				con.close();
			} catch (SQLException ex) {
				Logger.getLogger(SaleJdbcDAO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

}
