package controllers;

import play.*;
import play.mvc.*;
import java.util.*;

import utils.*;
import models.*;

public class Leaderboard extends Controller {
	public static void index() {

		String userId = session.get("logged_in_userid");
		User user = User.findById(Long.parseLong(userId));

		List<User> users = User.findAll();

		Collections.sort(users, new UserNameComparator());
		render(user, users);
	}

	public static void social() {

		List<User> users = User.findAll();

		// sort users by number friends first
		// if no friends - sort users by outbox size and rest in alphabetical order

		Collections.sort(users, new UserNameComparator());
		Collections.sort(users, new UserOutboxComparator());
		Collections.sort(users, new UserSocialComparator());
		render(users);
	}

	public static void talkative() {

		List<User> users = User.findAll();

		Collections.sort(users, new UserNameComparator());
		Collections.sort(users, new UserOutboxComparator());
		render(users);
	}

	public static void inbox() {

		List<User> users = User.findAll();

		Collections.sort(users, new UserNameComparator());
		Collections.sort(users, new UserInboxComparator());
		render(users);
	}
}