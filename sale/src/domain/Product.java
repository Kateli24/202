package domain;

import java.math.BigDecimal;
import java.util.Objects;
import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotNegative;
import net.sf.oval.constraint.NotNull;

/**
 *
 * @author liji8162
 */
public class Product implements Comparable<Product>{
	@NotNull(message = "ID must be provided.")
	@NotBlank(message = "ID must be provided.")
	@NotNegative(message = "ID must be zero or greater.")
	private Integer id;
	
	@NotNull(message = "Name must be provided.")
	@NotBlank(message = "Name must be provided.")
	@Length(min = 2, message = "Name must contain at least two characters.")
	private String name;
	
	
	private String description;
	
	@NotNull(message = "Category must be provided.")
	@NotBlank(message = "Category must be provided.")
	private String category;
	
	@NotNull(message = "Price must be provided.")
	@NotNegative(message = "Price must be zero or greater.")
	private BigDecimal price;
	
	@NotNull(message = "Quantity must be provided.")
	@NotNegative(message = "Quantity must be zero or greater.")
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

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 71 * hash + Objects.hashCode(this.id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Product other = (Product) obj;
		if (!Objects.equals(this.id, other.id)) {
			return false;
		}
		return true;
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
