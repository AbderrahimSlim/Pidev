package com.massconnections.Services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.massconnections.Domains.Crowd;
import com.massconnections.Domains.Message;

/**
 * Session Bean implementation class MessageCrudEJB
 */

@Stateless
@LocalBean
public class MessageCrudEJB implements MessageCrudEJBRemote, MessageCrudEJBLocal {
	
	@PersistenceContext
    private EntityManager em;
    /**
     * Default constructor. 
     */
    public MessageCrudEJB() {
    }

	@Override
	public void SendMessage(Crowd sender, Crowd reciever, String subject, String content) {
		Message msg = new Message(subject, content, sender, reciever);
		em.persist(msg);
	}

	@Override
	public void delete(Message msg) {
		em.remove(em.merge(msg));
	}

	@Override
	public List<Message> getInboxMessages(Crowd reciever) {
		Query query =  em.createQuery("select u from Message u  where u.reciever = :r ");
		query.setParameter("r", reciever);
		return query.getResultList();
	}

	@Override
	public List<Message> getOutboxMessages(Crowd sender) {
		Query query =  em.createQuery("select u from Message u  where u.sender = :r ");
		query.setParameter("r", sender);
		return query.getResultList();
	}

	


    
    
}
