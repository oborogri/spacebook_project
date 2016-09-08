package utils;

import java.util.Comparator;
import models.Message;

public class MessageFromComparator implements Comparator<Message> {

	@Override
	public int compare(Message o1, Message o2) {
		return o1.from.firstName.compareTo(o2.from.firstName);
	}
}