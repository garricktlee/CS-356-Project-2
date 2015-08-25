import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextPane;


public class UserView {
	private Users User;
	private String UserID;
	private JFrame frmUserview;
	private JTextField txtUserId;
	private JButton btnPostTweet;
	private JTextField txtTweetMessage;
	private JTextPane txtpnCurrentFollowing;

	/**
	 * Launch the application.
	 * @param string 
	 */

	public void run(String user) {
		try {
			UserView window = new UserView(user);
			window.frmUserview.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 * @param string 
	 */
	public UserView(String user) {
		this.UserID = user;
		if(MiniTwitter.userMap.containsKey(user)){
			this.User = MiniTwitter.userMap.get(user);
		}
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUserview = new JFrame();
		frmUserview.setTitle(UserID);
		frmUserview.setBounds(100, 100, 505, 501);
		frmUserview.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUserview.getContentPane().setLayout(null);
		
		final JTextPane txtpnNewsFeed = new JTextPane();
		txtpnNewsFeed.setText("News Feed");
		txtpnNewsFeed.setBounds(10, 275, 469, 177);
		frmUserview.getContentPane().add(txtpnNewsFeed);
		
		txtpnCurrentFollowing = new JTextPane();
		txtpnCurrentFollowing.setText("Current Following");
		txtpnCurrentFollowing.setBounds(10, 70, 469, 135);
		frmUserview.getContentPane().add(txtpnCurrentFollowing);
		
		JButton btnFollowUser = new JButton("Follow User");
		btnFollowUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User.addFollower(txtUserId.getText());
				
				String followers = User.returnFollowers();
				txtpnCurrentFollowing.setText(followers);		
				
				System.out.println("Follor User: " + txtUserId.getText());
			}
		});
		btnFollowUser.setBounds(247, 11, 232, 48);
		frmUserview.getContentPane().add(btnFollowUser);
		
		txtUserId = new JTextField();
		txtUserId.setText("User Id");
		txtUserId.setBounds(10, 11, 223, 48);
		frmUserview.getContentPane().add(txtUserId);
		txtUserId.setColumns(10);
		
		btnPostTweet = new JButton("Post Tweet");
		btnPostTweet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User.tweet(txtTweetMessage.getText());
				String news = User.returnTweets();
				txtpnNewsFeed.setText(news);				
				}
		});
		btnPostTweet.setBounds(275, 216, 204, 48);
		frmUserview.getContentPane().add(btnPostTweet);
		
		txtTweetMessage = new JTextField();
		txtTweetMessage.setText("Tweet Message");
		txtTweetMessage.setBounds(10, 216, 255, 48);
		frmUserview.getContentPane().add(txtTweetMessage);
		txtTweetMessage.setColumns(10);
		

		

	}
}
