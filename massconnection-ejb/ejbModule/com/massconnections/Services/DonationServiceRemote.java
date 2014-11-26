package com.massconnections.Services;

import java.util.List;

import javax.ejb.Remote;

import com.massconnections.Domains.Donation;

@Remote
public interface DonationServiceRemote {
	
	public void addDonation(Donation p);
	public Donation getById(int id);
	public void update(Donation p);
	public void delete(Donation p);
	List<Donation> getDonations();
	
}
