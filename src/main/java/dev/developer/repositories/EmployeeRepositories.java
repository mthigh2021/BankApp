package dev.developer.repositories;

import java.util.List;

import dev.developer.models.Account;
import dev.developer.models.Employee;
import dev.developer.utils.MockDB;

public class EmployeeRepositories implements GenericRepositories<Employee> {

	@Override
	public Employee add(Employee e) {
		// TODO Auto-generated method stub
		Employee employee = MockDB.emp.stream().max((e1,e2) -> e1.getId().compareTo(e2.getId())).orElse(null);
		Integer id = (employee != null) ? employee.getId() +1 : 1;
		e.setId(id);
		MockDB.emp.add(e);
		return e;
		
	}

	@Override
	public Employee getById(Integer id) {
		// TODO Auto-generated method stub
		Employee e = MockDB.emp.stream().filter((employee)-> employee.getId() == id).findFirst().orElse(null);
		return e;
	}

	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return MockDB.emp;
	}

	@Override
	public boolean update(Employee change) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Employee t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Employee registerNew(Employee t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee loginCheck(Employee t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getByPassword(String p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getSpecificColumnBypassword(String p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getByAccountID(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
