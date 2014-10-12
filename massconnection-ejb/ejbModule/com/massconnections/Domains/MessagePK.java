package com.massconnections.Domains;

import java.io.Serializable;

import javax.persistence.Embeddable;


@Embeddable
public class MessagePK implements Serializable{

	private static final long serialVersionUID = 6817526112532637993L;
	
	
	private int senderId;
	private int recieverId;
	
	
	public int getSenderId() {
		return senderId;
	}
	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}
	public int getRecieverId() {
		return recieverId;
	}
	public void setRecieverId(int recieverId) {
		this.recieverId = recieverId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + recieverId;
		result = prime * result + senderId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MessagePK other = (MessagePK) obj;
		if (recieverId != other.recieverId)
			return false;
		if (senderId != other.senderId)
			return false;
		return true;
	}
	
	
	
	
}
