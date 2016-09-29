-- spacebook_project 
### code imported from bitbucket account https://bitbucket.org/oborogri/spacebook_project ###

# Author: Grigore Oboroceanu
# version: 19-05-2016

# Application name: Spacebook
# Project created in Eclipse using Play framework

A prototype social networking aplication, allowing users to signup, view members list, follow/drop a memeber, send/view friends messages

# login with:
# username:  homer@simpson.com
# password: secret

# Assignment Specification
• 15 Spacebook ‘Stories’

Story 1
Extend data.yml file to include the full
Homer Simpson clan (and friends). 

Story 2
• Extend the User Model to include the following new fields:
• Age
• Nationality
• These fields must be filled in when a user registers.

Story 3
• For the new fields accepted in Story 2, display them on the users Home
Profile page.
• In addition, on the users 'Public' profile (then one a friend can see),
display just the 'Nationality' field

Story 4
• Provide a way for a user, once logged in, to change some of their profile
information. You could take two approaches to this:
• Provide some extra fields on the home profile which could all be changed
when the 'changeText' button is pressed.
• Provide a link on the home profile - say 'edit details' - which takes you to a
new page where you can edit the details.

Story 5
• The Members page now shows a list of all members - including the
currently logged in member. This clearly makes no sense and we should
try to remove the current member from the list.
• HINT: This is the Members controller index method:
 public static void index()
 {
 List<User> users = User.findAll();
 render(users);
 }
• The challenge is to remove the current user from the users list before we
send it to the view. 

Story 6
• In the members page - show each users name + their current status
message.

Story 7
• If a user attempts to use a url (say http://localhost:9000/home) without
being logged in, then the app immediately display the start screen..

Story 8
• Turn the list of messages on the home page into a table - with two
columns. One column for the message text, one for the senders name

Story 9
• In the messages table on the home page (story 8), make the senders name
into a link to the senders profile. In this way users can easily navigate from
a message directly to the sender, and perhaps leave a message

Story 10
• Change the Message structure such that it will have a ‘Subject’ field.
Make appropriate changes in the UI to support this new field

Story 11
• Deploy the application to heroku.com 
### done ###
https://spacebook20073381.herokuapp.com

Story 12
• Show a small version of the users picture in the friends and messages
lists on the users home page.

Story 13
• In the home page, allow the user to list all messages sorted by:
• by Date message sent
• by Sender Name
• by Conversation, including messages sent and received 

Story 14
• Introduce a new View called ‘Leaderboard’, which will show all users ordered
as follows:
• By most ‘social’ (most fiends)
• By most ‘talkative’ (most messages sent)

Story 15
• Preload on launch:
• Users
• Messages
• Friendships
• Images
 
 
