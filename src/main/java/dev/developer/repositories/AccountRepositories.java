package dev.developer.repositories;

import java.util.List;

import dev.developer.models.Account;
import dev.developer.models.Customer;
import dev.developer.utils.MockDB;

public class AccountRepositories implements GenericRepositories<Account> {

	@Override
	public Account add(Account a) {
		Account account = MockDB.acct.stream().max((a1,a2) -> a1.getId().compareTo(a2.getId())).orElse(null);
		Integer id = (account != null) ? account.getId() +1 : 1;
		a.setId(id);
		MockDB.acct.add(a);
		return a;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Account getById(Integer id) {
		// TODO Auto-generated method stub
		Account a = MockDB.acct.stream().filter((account)-> account.getId() == id).findFirst().orElse(null);
		return a;
	}

	@Override
	public List<Account> getAll() {
		// TODO Auto-generated method stub
		return MockDB.acct;
	}

	@Override
	public boolean update(Account change) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Account t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Account registerNew(Account t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account loginCheck(Account t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account getByPassword(String p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account getSpecificColumnBypassword(String p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account getByAccountID(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
