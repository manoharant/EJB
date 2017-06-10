package com.foshanshop.ejb3.impl;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.foshanshop.ejb3.Friend;
import com.foshanshop.ejb3.Person;
import com.foshanshop.ejb3.PersonInject;

@Stateless
@Remote (Friend.class)
public class FriendBean implements Friend {
	@PersonInject(name="Ë§¸ç", age=27) private Person person;

	public Person getFriend() {
		return person;
	}
}
