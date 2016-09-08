package utils;

import java.util.Collections;
import java.util.Comparator;
import models.Message;
import models.User;

public class UserNameComparator implements Comparator<User> {

	@Override
	public int compare(User user1, User user2) {

		return user1.firstName.compareTo(user2.firstName);
	}

}