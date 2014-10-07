package com.massconnections.Services;

import java.util.List;

import javax.ejb.Remote;

import com.massconnections.Domains.ChallengeCategory;

@Remote
public interface ChallengeCategoryCrudEJBRemote {
	public void addChallengeCategory(ChallengeCategory p);
	public List<ChallengeCategory> getChallengeCategorys();
	public ChallengeCategory getById(int id);
	public void update(ChallengeCategory p);
	public void delete(ChallengeCategory p);
}
