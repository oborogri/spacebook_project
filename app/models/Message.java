package models;

import java.util.Date;
import java.sql.Timestamp;

import javax.persistence.*;
import play.db.jpa.*;

@Entity
public class Message extends Model {
	public String messageText;
	public String messageSubject;
	public Date postedAt;

	@ManyToOne
	public User from;

	@ManyToOne
	public User to;

	public Message(User from, User to, String messageText, String messageSubject) {
		this.from = from;
		this.to = to;
		this.messageText = messageText;
		this.messageSubject = messageSubject;
		postedAt = new Date();
	}
}
