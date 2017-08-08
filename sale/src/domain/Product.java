package domain;

import java.math.BigDecimal;

/**
 *
 * @author liji8162
 */
public class Product implements Comparable<Product>{
	private Integer id;
	private String name;
	private String description;
	private String category;
	private BigDecimal price;
	private Integer quantity;

	public Product() {
	}

	public Product(Integer id, String name, String description, String category, BigDecimal price, Integer quantity) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
	}
	

	
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

	/** a method from library to make Product collection sorted */
	@Override
	public int compareTo(Product anotherProduct) {
		Integer myId = this.getId();
		Integer anotherId = anotherProduct.getId();
		return myId.compareTo(anotherId);

	}
	
	
}
