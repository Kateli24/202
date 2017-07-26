package domain;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

/**
 *
 * @author liji8162
 */
public class Sale {
	private Integer id;
	private Date date;
	/**SaleItems should be in a HashSet because when users try to buy same 
	 * type of product in one sale, we don't wanna them to be two elements 
	 * in the collection, we wanna them to be able to combine together. 
	 * i.e.we wannt them still be unique*/
	private Collection<SaleItem> items  = new HashSet<>();
	private Customer customer;

	public Sale(Customer customer, Integer id, Date date) {
		this.customer = customer;
		this.id = id;
		this.date = date;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public Customer getCustomer() {
		return customer;
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
		items.add(orderItem);
		
	}
	
	public BigDecimal getTotal(){
		BigDecimal amount =  BigDecimal.ZERO;
		for(SaleItem item:items){
			amount = amount.add(item.getItemTotal());
		}
		return amount;
	}
		
	
	
	
	
}
