package domain;

import java.math.BigDecimal;

/**
 *
 * @author liji8162
 */
public class SaleItem {
	private Integer quantityPurchased;
	private BigDecimal purchasePrice;
	private Product product;
	private Sale sale;

	public SaleItem(Integer quantityPurchased, BigDecimal purchasePrice, Product product, Sale sale) {
		this.quantityPurchased = quantityPurchased;
		this.purchasePrice = purchasePrice;
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
		return quantityPurchased;
	}

	public BigDecimal getPurchusePrice() {
		return purchasePrice;
	}
	
	public void setSale(Sale sale) {
		this.sale = sale;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}

	public void setQuantityPurchused(Integer quantityPurchused) {
		this.quantityPurchased = quantityPurchused;
	}

	public void setPurchusePrice(BigDecimal purchusePrice) {
		this.purchasePrice = purchusePrice;
	}
	
	/**this line is to get total=(purchsePrice*quantityPurchused)
	 to make them as the same type, we need to convert Integer to BigDecimal*/
	public BigDecimal getItemTotal(){
		return (purchasePrice.multiply(new BigDecimal(quantityPurchased)));
	}
	
}
