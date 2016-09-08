package utils;

import java.util.Collections;
import java.util.Comparator;
import models.Message;
import models.User;

public class UserSocialComparator implements Comparator<User> {

	@Override
	public int compare(User a, User b) {
		return (b.friendships.size() - a.friendships.size());
	}
}