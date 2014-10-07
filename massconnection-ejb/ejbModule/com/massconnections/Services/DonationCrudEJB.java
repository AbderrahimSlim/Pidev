package com.massconnections.Services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.massconnections.Domains.Donation;

/**
 * Session Bean implementation class DonationCrudEJB
 */
@Stateless
public class DonationCrudEJB implements DonationCrudEJBRemote, DonationCrudEJBLocal {

	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public DonationCrudEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addDonation(Donation p) {
		em.persist(p);
		
	}

	@Override
	public List<Donation> getDonations() {
		return em.createQuery("select * from Donation").getResultList();
	}

	@Override
	public Donation getById(int id) {
		return em.find(Donation.class, id);
	}

	@Override
	public void update(Donation p) {
		em.merge(p);
	}

	@Override
	public void delete(Donation p) {
		em.detach(em.merge(p));
	}

}
