package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class PublicProfile extends Controller {
	public static void index() {
		render();
	}

	public static void visit(Long id) {
		// redirects logged in user to own profile page rather than public profile
		Long LoggedUserId = Long.parseLong(session.get("logged_in_userid"));

		if (id == LoggedUserId) {
			String userId = session.get("logged_in_userid");
			User user = User.findById(Long.parseLong(userId));

			Logger.info(user.email + " Profile page ");
			Profile.index();
		}
		User user = User.findById(id);
		Logger.info("Just visiting the page for " + user.firstName + ' ' + user.lastName);
		render(user);
	}

	public static void sendMessage(Long id, String messageText, String messageSubject) {
		String userId = session.get("logged_in_userid");
		User fromUser = User.findById(Long.parseLong(userId));
		User toUser = User.findById(id);

		Logger.info("Message from " + fromUser.firstName + ' ' + fromUser.lastName + " to " + toUser.firstName + ' '
				+ toUser.lastName + ": " + messageText);

		fromUser.sendMessage(toUser, messageText, messageSubject);
		visit(id);
	}
}