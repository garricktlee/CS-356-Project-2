import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;


public class UserView {

	private JFrame frame;
	private JTextField txtUserId;
	private JButton btnPostTweet;
	private JTextField txtTweetMessage;
	private JTextPane txtpnCurrentFollowing;

	/**
	 * Launch the application.
	 */

	public void run() {
		try {
			UserView window = new UserView();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public UserView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 505, 501);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnFollowUser = new JButton("Follow User");
		btnFollowUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Follor User: " + txtUserId.getText());
			}
		});
		btnFollowUser.setBounds(247, 11, 232, 48);
		frame.getContentPane().add(btnFollowUser);
		
		txtUserId = new JTextField();
		txtUserId.setText("User Id");
		txtUserId.setBounds(10, 11, 223, 48);
		frame.getContentPane().add(txtUserId);
		txtUserId.setColumns(10);
		
		btnPostTweet = new JButton("Post Tweet");
		btnPostTweet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Post Tweet: " + txtTweetMessage.toString());
				}
		});
		btnPostTweet.setBounds(275, 216, 204, 48);
		frame.getContentPane().add(btnPostTweet);
		
		txtTweetMessage = new JTextField();
		txtTweetMessage.setText("Tweet Message");
		txtTweetMessage.setBounds(10, 216, 255, 48);
		frame.getContentPane().add(txtTweetMessage);
		txtTweetMessage.setColumns(10);
		
		JTextPane txtpnNewsFeed = new JTextPane();
		txtpnNewsFeed.setText("News Feed");
		txtpnNewsFeed.setBounds(10, 275, 469, 177);
		frame.getContentPane().add(txtpnNewsFeed);
		
		txtpnCurrentFollowing = new JTextPane();
		txtpnCurrentFollowing.setText("Current Following");
		txtpnCurrentFollowing.setBounds(10, 70, 469, 135);
		frame.getContentPane().add(txtpnCurrentFollowing);
	}
}
