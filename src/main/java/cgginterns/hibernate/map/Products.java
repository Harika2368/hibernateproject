package cgginterns.hibernate.map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Products {
	
	@Id
	@Column(name="product_id")
	private int productId;
	@Column(name="product_name")
	private String productname;
	
	@ManyToOne
	@JoinColumn(name="p_id")
	private Brand brand;
	
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	public Products(int productId, String productname) {
		super();
		this.productId = productId;
		this.productname = productname;
	}
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}

}
