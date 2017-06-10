package junit.test;

import org.junit.BeforeClass;
import org.junit.Test;

import com.foshanshop.ejb3.Friend;

public class FriendTest {
	private static Friend friend;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		friend = (Friend) EJBFactory.getEJB("FriendBean/remote");
	}

	@Test
	public void testGetFriend() {
		System.out.println(friend.getFriend());
	}

}
