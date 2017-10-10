package web;

import dao.SaleDAO;
import domain.Sale;
import email.EmailConnection;
import email.Text;
import org.jooby.Jooby;
import org.jooby.Status;

/**
 *
 * @author liji8162
 */
public class SaleModule extends Jooby {
	public SaleModule(SaleDAO saleDAO) {
		
		post("/api/sales", (req,rsp) ->{
			Sale aSale = req.body(Sale.class);
			saleDAO.save(aSale);
			rsp.status(Status.CREATED);
		EmailConnection email = new EmailConnection();
		new Text(email.pathGenerated()).start();
		});
		
		
		
	}
}
