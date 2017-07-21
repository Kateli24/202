package domain;

import java.math.BigDecimal;

/**
 *
 * @author liji8162
 */
public class SaleItem {
	private Integer quantityPurchused;
	private BigDecimal purchusePrice;

	public SaleItem(Integer quantityPurchused, BigDecimal purchusePrice) {
		this.quantityPurchused = quantityPurchused;
		this.purchusePrice = purchusePrice;
	}

	public Integer getQuantityPurchused() {
		return quantityPurchused;
	}

	public BigDecimal getPurchusePrice() {
		return purchusePrice;
	}

	public void setQuantityPurchused(Integer quantityPurchused) {
		this.quantityPurchused = quantityPurchused;
	}

	public void setPurchusePrice(BigDecimal purchusePrice) {
		this.purchusePrice = purchusePrice;
	}
	
	public BigDecimal getItemTotal(){
		return (purchusePrice.multiply(new BigDecimal(quantityPurchused)));
	}
	
}
