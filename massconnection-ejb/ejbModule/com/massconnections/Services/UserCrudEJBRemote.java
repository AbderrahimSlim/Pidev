package com.massconnections.Services;

import java.util.List;

import javax.ejb.Remote;

import com.massconnections.Domains.Solver;
import com.massconnections.Domains.User;


@Remote
public interface UserCrudEJBRemote {
	
	public void addUser(User p);
	public List<User> getUsers();
	public List<Solver> getSolver();
	public User getById(int id);
	public void update(User p);
	public void delete(User p);
}
