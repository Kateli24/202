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
	public static void main(String[] args) {
	// get a connection to the database
	try{
Connection con;
		con = DriverManager.getConnection("jdbc:h2:tcp://localhost:8067/labs/lab11", "sa", "");
// select from the view
String sql = "select * from sale_receipt";
// execute the statement
PreparedStatement stmt = con.prepareStatement(sql);

ResultSet rs = stmt.executeQuery();
// create the report using the result set as a data source
JasperPrint report =JasperFillManager.fillReport("h:/lab11report/receipt.jasper", new HashMap<String, Object>(), new JRResultSetDataSource(rs));
// display the report
JasperViewer.viewReport(report);
//make a PDF version
JasperExportManager.exportReportToPdfFile(report, "h:/lab11report/receipt.pdf");
//clean up
stmt.close();
con.close();
	}catch(SQLException | JRException ex){
		throw new RuntimeException(ex);
	}
}
}