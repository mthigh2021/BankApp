package dev.developer.repositories;
import java.util.List;
import dev.developer.models.Customer;
import dev.developer.utils.MockDB;


public class CustomerRepositories implements GenericRepositories<Customer> {

	@Override
	public Customer add(Customer c) {
		// TODO Auto-generated method stub
		Customer customer = MockDB.cust.stream().max((c1,c2) -> c1.getId().compareTo(c2.getId())).orElse(null);
		Integer id = (customer != null) ? customer.getId() +1 : 1;
		c.setId(id);
		MockDB.cust.add(c);
		return c;

	}

	@Override
	public Customer getById(Integer id) {
		// TODO Auto-generated method stub
		 Customer c = MockDB.cust.stream().filter((customer)-> customer.getId() == id).findFirst().orElse(null);
		 return c;
		 
		//Breed b = MockDB.breeds.stream().filter((breed)-> breed.getId() == id).findFirst().orElse(null);
		
	}

	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		return MockDB.cust;
	}

	@Override
	public boolean update(Customer change) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Customer t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Customer registerNew(Customer t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer loginCheck(Customer t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getByPassword(String p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getSpecificColumnBypassword(String p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getByAccountID(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
