package cz.profinit.sep.civka6.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ObjektKUlozeni {

	@Id
	@GeneratedValue
	private Long id;
	
	private String targetAbo;

	private String sourceAbo;
	
	private BigDecimal amount;
	
	private Date date;

	public ObjektKUlozeni() {
		//nothing
	}
	
	public ObjektKUlozeni(String sourceIban, String targetIban, BigDecimal amount) {
		super();
		this.targetAbo = targetIban;
		this.sourceAbo = sourceIban;
		this.amount = amount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getTargetAbo() {
		return targetAbo;
	}

	public void setTargetAbo(String targetIban) {
		this.targetAbo = targetIban;
	}

	public String getSourceAbo() {
		return sourceAbo;
	}

	public void setSourceAbo(String sourceIban) {
		this.sourceAbo = sourceIban;
	}

	@Override
	public String toString() {
		return "ObjektKUlozeni [id=" + id + ", targetIban=" + targetAbo + ", sourceIban=" + sourceAbo + ", amount="
				+ amount + ", date=" + date + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ObjektKUlozeni other = (ObjektKUlozeni) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
