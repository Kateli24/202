package domain;

import java.math.BigDecimal;

/**
 *
 * @author liji8162
 */
public class Product {
	private Integer id;
	private String name;
	private String description;
	private String category;
	private BigDecimal price;
	private Integer quantity;

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getCategory() {
		return category;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	@Override
	public String toString() {
		return "Product{" + "id=" + id + ", name=" + name +
				  ", category=" + category + '}';
	}
	
	
}
