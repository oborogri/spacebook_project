package utils;

import java.util.Comparator;
import models.Message;

public class MessageSubjectComparator implements Comparator<Message> {

	@Override
	public int compare(Message o1, Message o2) {
		return o1.messageSubject.compareTo(o2.messageSubject);
	}
}