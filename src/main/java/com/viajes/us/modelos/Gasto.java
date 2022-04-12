package com.viajes.us.modelos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="gastos")
public class Gasto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=5, max=100)
	private String expense_name;
	
	@NotNull
	@Size(min=5, max=100)
	private String vendor;
	
	@NotNull
	@Min(1)
	private Double amount;
	
	@NotNull
	@Size(min=5, max=255)
	private String description;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date created_at;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updated_at;

	public Gasto() {
		
	}
	
	public Gasto(String expense_name,
				 String vendor,
				 Double amount,
				 String description) {
		this.expense_name = expense_name;
		this.vendor = vendor;
		this.amount = amount;
		this.description = description;
	}
	
	

	public Gasto(Long id, String expense_name,
			 String vendor,
			 Double amount,
			 String description) {
		this.id = id;
		this.expense_name = expense_name;
		this.vendor = vendor;
		this.amount = amount;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getExpense_name() {
		return expense_name;
	}

	public void setExpense_name(String expense_name) {
		this.expense_name = expense_name;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@PrePersist
    protected void onCreate(){
        this.created_at = new Date();
    }
	
    @PreUpdate
    protected void onUpdate(){
        this.updated_at = new Date();
    }
	
	
}