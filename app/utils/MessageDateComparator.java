package utils;

import java.util.Comparator;
import models.Message;

public class MessageDateComparator implements Comparator<Message> {

	@Override
	public int compare(Message a, Message b) {
		return a.postedAt.compareTo(b.postedAt);
	}
}
