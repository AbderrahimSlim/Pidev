package com.massconnections.Services;

import java.util.List;

import javax.ejb.Remote;

import com.massconnections.Domains.Crowd;
import com.massconnections.Domains.Message;

@Remote
public interface MessageCrudEJBRemote {
	public void SendMessage (Crowd sender, Crowd reciever, String subject,String content);
	public void delete (Message msg);
}