package controllers;

import utils.*;
import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Home extends Controller {

	public static void index() {
		if (session.get("logged_in_userid") == null) {
			Accounts.login();
		}

		else {
			String userId = session.get("logged_in_userid");
			User user = User.findById(Long.parseLong(userId));
			render(user);
		}
	}

	public static void drop(Long id) {
		String userId = session.get("logged_in_userid");
		User user = User.findById(Long.parseLong(userId));

		User friend = User.findById(id);

		user.unfriend(friend);
		Logger.info("Dropping " + friend.email);
		index();
	}

	public static void byUser() {
		String userId = session.get("logged_in_userid");
		User user = User.findById(Long.parseLong(userId));

		Collections.sort(user.inbox, new MessageFromComparator());
		user.save();

		Logger.info("Sorting messages by Sender name for " + user.email);
		render(user);
	}

	public static void bySubject() {
		String userId = session.get("logged_in_userid");
		User user = User.findById(Long.parseLong(userId));

		Collections.sort(user.inbox, new MessageSubjectComparator());
		user.save();

		Logger.info("Sorting messages by Subject for " + user.email);
		render(user);
	}

	public static void byDate() {
		String userId = session.get("logged_in_userid");
		User user = User.findById(Long.parseLong(userId));

		Collections.sort(user.inbox, new MessageDateComparator());
		user.save();

		Logger.info("Sorting messages by Date for " + user.email);
		render(user);
	}

	public static void byConversation() {
		String userId = session.get("logged_in_userid");
		User user = User.findById(Long.parseLong(userId));

		ArrayList<ArrayList<Message>> conversations = new ArrayList<ArrayList<Message>>();

		for (Friendship f : user.friendships) {
			ArrayList<Message> conversation = new ArrayList<Message>(getConversation(f.targetUser));
			conversations.add(conversation);
		}
		Logger.info("Sorting messages by Conversation for " + user.email);
		render(user, conversations);
	}

	static ArrayList<Message> getConversation(User friend) {
		String userId = session.get("logged_in_userid");
		User user = User.findById(Long.parseLong(userId));

		ArrayList<Message> conversation = new ArrayList<Message>();

		// if message in user's outbox is addresed to friend - add the messages to
		// conversation list
		for (Message message : user.outbox) {
			if (message.to == friend) {
				conversation.add(message);
			}
		}

		// if the message in user's inbox is from friend - add message to
		// conversation list
		for (Message message : user.inbox) {
			if (message.from == friend) {
				conversation.add(message);
			}
		}
		// sorting the conversation by date
		Collections.sort(conversation, new MessageDateComparator());
		return conversation;
	}
}
