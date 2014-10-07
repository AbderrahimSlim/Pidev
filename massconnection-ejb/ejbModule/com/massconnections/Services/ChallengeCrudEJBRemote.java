package com.massconnections.Services;

import javax.ejb.Remote;

import com.massconnections.Domains.Challenge;

@Remote
public interface ChallengeCrudEJBRemote {

	public void addChallenge(Challenge c);
	public Challenge getById(int id);
	public void update(Challenge c);
	public void delete(Challenge c);
	
}
