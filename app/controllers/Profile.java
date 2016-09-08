package controllers;

import play.*;
import play.mvc.*;

import java.util.*;
import play.db.jpa.Blob;

import models.*;

public class Profile extends Controller {
	public static void index() {
		String userId = session.get("logged_in_userid");
		User user = User.findById(Long.parseLong(userId));
		render(user);
	}

	public static void changestatus(String profiletext) {
		String userId = session.get("logged_in_userid");
		User user = User.findById(Long.parseLong(userId));

		if (profiletext != null && !profiletext.isEmpty()) {
			user.statusText = profiletext;
		}

		user.save();
		Logger.info(user.email + " Status changed to " + profiletext);
		index();
	}

	public static void getPicture(Long id) {
		User user = User.findById(id);
		Blob picture = user.profilePicture;
		if (picture.exists()) {
			response.setContentTypeIfNotSet(picture.type());
			renderBinary(picture.get());
		}
	}

	public static void uploadPicture(Long id, Blob picture) {
		User user = User.findById(id);
		user.profilePicture = picture;
		user.save();
		index();
	}

	public static void editProfile() {
		String userId = session.get("logged_in_userid");
		User user = User.findById(Long.parseLong(userId));
		render(user);
	}

	public static void updateProfile(int age, String email, String password) {
		String userId = session.get("logged_in_userid");
		User user = User.findById(Long.parseLong(userId));

		// validate new details and only update if not null and valid email

		if ((age != 0) && (age != user.age)) {
			user.age = age;
		}

		if ((password != null) && (!email.isEmpty()) && (password != user.password)) {
			user.password = password;

		}

		if (Accounts.isValidEmailAddress(email)) {
			user.email = email;

			user.save();
			Logger.info("Updating profile for: " + user.firstName);
			index();
		} else

			Logger.info("Error - invalid details entered for: " + user.firstName);
		  index();
	}

}