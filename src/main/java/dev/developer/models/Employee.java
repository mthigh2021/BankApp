package dev.developer.models;

public class Employee {

	
	private Integer id;
	private String name;
	private String emp_username;
	private String emp_password;
	
	private String emp_title;

	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Employee(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}


	public Employee(String name) {
		super();
		this.name = name;
	}


	
	
	
	public Employee(String emp_username, String emp_password) {
		super();
		this.emp_username = emp_username;
		this.emp_password = emp_password;
	}
	
	


	public Employee(String name, String emp_username, String emp_password, String emp_title) {
		super();
		this.name = name;
		this.emp_username = emp_username;
		this.emp_password = emp_password;
		this.emp_title = emp_title;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmp_username() {
		return emp_username;
	}


	public void setEmp_username(String emp_username) {
		this.emp_username = emp_username;
	}


	public String getEmp_password() {
		return emp_password;
	}


	public void setEmp_password(String emp_password) {
		this.emp_password = emp_password;
	}
	


	public String getEmp_title() {
		return emp_title;
	}


	public void setEmp_title(String emp_title) {
		this.emp_title = emp_title;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Employee other = (Employee) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", emp_username=" + emp_username + ", emp_password="
				+ emp_password + "]";
	}


	

	
	
	
	
	
	
}
