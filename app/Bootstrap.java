import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import play.*;
import play.db.jpa.Blob;
import play.jobs.*;
import play.libs.MimeTypes;
import play.test.*;

import models.*;

@OnApplicationStart
public class Bootstrap extends Job {
	public void doJob() throws FileNotFoundException
	 {
		 //Fixtures.deleteDatabase();
		 Fixtures.loadModels("data.yml");

		 String homerPhoto = "app/homer.jpg";
		 Blob homerBlob = new Blob ();
		 homerBlob.set(new FileInputStream(homerPhoto), MimeTypes.getContentType(homerPhoto));
		 User homer = User.findByEmail("homer@simpson.com");
		 homer.profilePicture = homerBlob;
		 homer.save();
		 
		 String bartPhoto = "app/bart.jpg";
		 Blob bartBlob = new Blob ();
		 bartBlob.set(new FileInputStream(bartPhoto), MimeTypes.getContentType(bartPhoto));
		 User bart = User.findByEmail("bart@simpson.com");
		 bart.profilePicture = bartBlob;
		 bart.save();
		 
		 String margePhoto = "app/marge.jpg";
		 Blob margeBlob = new Blob ();
		 margeBlob.set(new FileInputStream(margePhoto), MimeTypes.getContentType(margePhoto));
		 User marge = User.findByEmail("marge@simpson.com");
		 marge.profilePicture = margeBlob;
		 marge.save();
		 
		 String maggiePhoto = "app/maggie.jpg";
		 Blob maggieBlob = new Blob ();
		 maggieBlob.set(new FileInputStream(maggiePhoto), MimeTypes.getContentType(maggiePhoto));
		 User maggie = User.findByEmail("maggie@simpson.com");
		 maggie.profilePicture = maggieBlob;
		 maggie.save();
		 
		 String lisaPhoto = "app/lisa.jpg";
		 Blob lisaBlob = new Blob ();
		 lisaBlob.set(new FileInputStream(lisaPhoto), MimeTypes.getContentType(lisaPhoto));
		 User lisa = User.findByEmail("lisa@simpson.com");
		 lisa.profilePicture = lisaBlob;
		 lisa.save();
	 }
}