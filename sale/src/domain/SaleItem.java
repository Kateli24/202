package domain;

import java.math.BigDecimal;

/**
 *
 * @author liji8162
 */
public class SaleItem {
	private Integer quantityPurchused;
	private BigDecimal purchusePrice;
	private Product product;
	private Sale sale;

	public SaleItem(Integer quantityPurchused, BigDecimal purchusePrice, Product product, Sale sale) {
		this.quantityPurchused = quantityPurchused;
		this.purchusePrice = purchusePrice;
		this.product = product;
		this.sale = sale;
	}

	public Sale getSale() {
		return sale;
	}
	
	public Product getProduct() {
		return product;
	}

	public Integer getQuantityPurchused() {
		return quantityPurchused;
	}

	public BigDecimal getPurchusePrice() {
		return purchusePrice;
	}
	
	public void setSale(Sale sale) {
		this.sale = sale;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}

	public void setQuantityPurchused(Integer quantityPurchused) {
		this.quantityPurchused = quantityPurchused;
	}

	public void setPurchusePrice(BigDecimal purchusePrice) {
		this.purchusePrice = purchusePrice;
	}
	
	/**this line is to get total+=(purchsePrice*quantityPurchused)*/
	public BigDecimal getItemTotal(){
		return (purchusePrice.multiply(new BigDecimal(quantityPurchused)));
	}
	
}
