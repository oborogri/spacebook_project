package utils;

import java.util.Collections;
import java.util.Comparator;
import models.Message;
import models.User;

public class UserOutboxComparator implements Comparator<User> {

	@Override
	public int compare(User a, User b) {
		return (b.outbox.size() - a.outbox.size());
	}
}