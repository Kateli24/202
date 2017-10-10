package email;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author liji8162
 */
public class EmailConnection {

	public String pathGenerated() {
		// get a connection to the database
		String path = "h:/lab11report/receipt.pdf";
		try {

			Connection con;
			con = DriverManager.getConnection("jdbc:h2:tcp://localhost:8067/labs/lab11", "sa", "");
// select from the view
			String sql = "select * from sale_receipt";

// execute the statement
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
//			if (rs.next()) {
//				Integer sale_id = rs.getInt("ID");
//				Date date = rs.getDate("DATE");
//				String name = rs.getString("name");
//				String address = rs.getString("SHIPPINGADDRESS");
//				Integer product_id = rs.getInt("PRODUCT_ID");
//				String productName = rs.getString("NAME");
//				BigDecimal price = rs.getBigDecimal("PRICE");
//				String description = rs.getString("DESCRIPTION");
//				Integer quantity = rs.getInt("QUANTITY");
//			}
// create the report using the result set as a data source

			JasperPrint report = JasperFillManager.fillReport("h:/lab11report/receipt.jasper", new HashMap<String, Object>(), new JRResultSetDataSource(rs));
// display the report
			JasperViewer.viewReport(report);
//make a PDF version
			JasperExportManager.exportReportToPdfFile(report, "h:/lab11report/receipt.pdf");
//clean up
			stmt.close();
			con.close();
		} catch (SQLException | JRException ex) {
			throw new RuntimeException(ex);
		}
		return path;
	}

}
