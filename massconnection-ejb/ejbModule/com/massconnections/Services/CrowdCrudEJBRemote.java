package com.massconnections.Services;

import java.util.List;

import javax.ejb.Remote;

import com.massconnections.Domains.Crowd;


@Remote
public interface CrowdCrudEJBRemote {
	
	public void addCrowd(Crowd p);
	public List<Crowd> getCrowds();
	public Crowd getById(int id);
	public void update(Crowd p);
	public void delete(Crowd p);
}
