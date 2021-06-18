package com.it.entity;

import java.util.Date;
import java.math.BigDecimal;

public class TestUser {
	private Integer id;
	private String name;
	private Integer age;
	private Date createDate;
	private BigDecimal money;
	private Byte type;

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public Integer getAge() {
		return this.age;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public Date getCreateDate() {
		return this.createDate;
	}
	
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	
	public BigDecimal getMoney() {
		return this.money;
	}
	
	public void setType(Byte type) {
		this.type = type;
	}
	
	public Byte getType() {
		return this.type;
	}
	

	@Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) {return false;}
        TestUser that = (TestUser) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id);
    }
    
    @Override
    public String toString() {
        return "TestUser{" +
				"id=" + id +
						",name='" + name + "'" + 
						",age='" + age + "'" + 
						",createDate='" + createDate + "'" + 
						",money='" + money + "'" + 
						",type='" + type + "'" + 
		                '}';
    }
	
}