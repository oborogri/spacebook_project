package controllers;

import play.*;
import play.mvc.*;
import java.util.*;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import models.*;

public class Accounts extends Controller {

	public static void index() {
		render();
	}

	public static void signup() {
		render();
	}

	public static void login() {
		render();
	}

	public static void error() {
		render();
	}

	public static void logout() {
		session.clear();
		index();
	}

	public static void authenticate(String email, String password) {
		Logger.info("Attempting to authenticate with " + email + " : " + password);
		User user = User.findByEmail(email);
		if ((user != null) && (user.checkPassword(password) == true)) {
			Logger.info("Authentication successful");
			session.put("logged_in_userid", user.id);
			Home.index();
		} else {
			Logger.info("Authentication failed");
			error();
		}
	}

	public static void register(User user) {
		List<User> users = User.findAll();

		for (User a : users) {
			if (equalUser(user, a)) {
				Logger.info("Error - user " + user.email + " already registered!");
				login();
			}
		}
		if (isValidEmailAddress(user.email)) {
			user.save();
			Logger
					.info("New member details: " + user.firstName + " " + user.lastName + " " + user.email + " " + user.password);
			login();
		} else {
			Logger.info("Error - user " + user.email + " not a valid email!");
			error();
		}
	}

	private static boolean equalUser(User a, User b) {
		return (a.email.equals(b.email));
	}

	public static boolean isValidEmailAddress(String email) {

		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
		java.util.regex.Matcher m = p.matcher(email);
		return m.matches();
	}
}