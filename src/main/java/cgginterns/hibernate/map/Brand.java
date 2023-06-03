package cgginterns.hibernate.map;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Brand {
	@Id
	@Column(name="brand_id")
	private int brandId;
	@Column(name="brand_name")
	private String brandname;
	
	@OneToMany(mappedBy="brand")
	List<Products> products;
	
	public List<Products> getProducts() {
		return products;
	}
	public void setProducts(List<Products> products) {
		this.products = products;
	}
	public Brand() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Brand(int brandId, String brandname) {
		super();
		this.brandId = brandId;
		this.brandname = brandname;
	}
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	public String getBrandname() {
		return brandname;
	}
	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}
	
	

}
