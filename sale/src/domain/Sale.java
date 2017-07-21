package domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author liji8162
 */
public class Sale {
	private Integer id;
	private Date date;
	private List<SaleItem> saleItem  = new ArrayList<>();

	public Sale(Integer id, Date date) {
		this.id = id;
		this.date = date;
	}

	public Integer getId() {
		return id;
	}

	public Date getDate() {
		return date;
	}

	@Override
	public String toString() {
		return "Sale{" + "id=" + id + ", date=" + date + '}';
	}
	
	public void addItem(SaleItem orderItem){
		saleItem.add(orderItem);
		
	}
	
	public BigDecimal getTotal(){
		BigDecimal amount =  BigDecimal.ZERO;
		for(SaleItem item:saleItem){
			amount = amount.add(item.getItemTotal());
		}
		return amount;
	}
		
	
	
	
	
}
