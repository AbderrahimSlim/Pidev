package com.massconnections.Services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.massconnections.Domains.Challenge;

/**
 * Session Bean implementation class ChallengeCrudEJB
 */
@Stateless
public class ChallengeService implements ChallengeServiceRemote,
		ChallengeServiceLocal {
	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public ChallengeService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addChallenge(Challenge c) {
		em.persist(c);
	}

	@Override
	public Challenge getById(int id) {
		Challenge c = null;
	
			c = em.createQuery(
					"select p from Challenge p LEFT JOIN FETCH p.solutions where p.id = :id",
					Challenge.class).setParameter("id", id).getSingleResult();

		return c;
	}

	@Override
	public void update(Challenge c) {
		em.merge(c);
	}

	@Override
	public void delete(Challenge c) {
		em.remove(em.merge(c));
	}

	@Override
	public List<Challenge> getChallenges() {
		List<Challenge> challenges = null;
		try {
			challenges = em
					.createQuery(
							"select DISTINCT(p) from Challenge p LEFT JOIN FETCH p.solutions",
							Challenge.class).getResultList();
		} catch (Exception e) {

		}
		return challenges;
	}

}
