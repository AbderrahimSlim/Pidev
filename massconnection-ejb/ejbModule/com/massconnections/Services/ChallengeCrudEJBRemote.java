package com.massconnections.Services;

import java.util.List;

import javax.ejb.Remote;

import com.massconnections.Domains.Challenge;

@Remote
public interface ChallengeCrudEJBRemote {

	public void addChallenge(Challenge c);
	public Challenge getById(int id);
	public void update(Challenge c);
	public void delete(Challenge c);
	public List<Challenge> getChallenges();
	
}
