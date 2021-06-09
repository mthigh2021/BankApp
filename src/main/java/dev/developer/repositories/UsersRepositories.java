package dev.developer.repositories;

import java.util.List;

import dev.developer.models.Account;
import dev.developer.models.Users;
import dev.developer.utils.MockDB;

public class UsersRepositories implements GenericRepositories<Users> {

	@Override
	public Users add(Users u) {
		// TODO Auto-generated method stub
		Users user = MockDB.usr.stream().max((u1,u2) -> u1.getUsr_id().compareTo(u2.getUsr_id())).orElse(null);
		Integer id = (user != null) ? user.getUsr_id() +1 : 1;
		u.setUsr_id(id);
		MockDB.usr.add(u);
		return u;
		
		
	}

	@Override
	public Users getById(Integer id) {
		// TODO Auto-generated method stub
		Users u = MockDB.usr.stream().filter((user)-> user.getUsr_id() == id).findFirst().orElse(null);
		return u;
	}

	@Override
	public List<Users> getAll() {
		// TODO Auto-generated method stub
		return MockDB.usr;
	}

	@Override
	public boolean update(Users change) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Users t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Users registerNew(Users t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users loginCheck(Users t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users getByPassword(String p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users getSpecificColumnBypassword(String p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users getByAccountID(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
