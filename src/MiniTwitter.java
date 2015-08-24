import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTree;


public class MiniTwitter {

	private JFrame frmMinitwitter;
	private JTextField txtUserId;
	private JTextField txtGroupId;
	
	
	//Singleton implementation
	private static MiniTwitter instance = null;
	
	protected static MiniTwitter getInstance(){
		
		if(instance == null){
			instance = new MiniTwitter();
			instance.run();			
		}
		return instance;
	}

	/**
	 * Launch the application.
	 */

	private void run() {
		try {
			MiniTwitter window = new MiniTwitter();
			window.frmMinitwitter.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	private MiniTwitter() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMinitwitter = new JFrame();
		frmMinitwitter.setTitle("MiniTwitter");
		frmMinitwitter.setBounds(100, 100, 795, 537);
		frmMinitwitter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMinitwitter.getContentPane().setLayout(null);
		
		JButton btnAddUser = new JButton("Add User");
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Add User: " + txtUserId.getText());
			}
		});
		btnAddUser.setBounds(395, 48, 182, 60);
		frmMinitwitter.getContentPane().add(btnAddUser);
		
		JButton btnAddGroup = new JButton("Add Group");
		btnAddGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Add Group: " + txtGroupId.getText());
			}
		});
		btnAddGroup.setBounds(587, 48, 182, 60);
		frmMinitwitter.getContentPane().add(btnAddGroup);
		
		JButton btnOpenUserView = new JButton("Open User View");
		btnOpenUserView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserView openView = new UserView();
				openView.run();
				System.out.println("Open User View");
			}
		});
		btnOpenUserView.setBounds(395, 119, 374, 60);
		frmMinitwitter.getContentPane().add(btnOpenUserView);
		
		JButton btnShowPositivePercentage = new JButton("Show Positive Percentage");
		btnShowPositivePercentage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Show Positive Percentage");
			}
		});
		btnShowPositivePercentage.setBounds(587, 422, 182, 66);
		frmMinitwitter.getContentPane().add(btnShowPositivePercentage);
		
		JButton btnShowMessagesTotal = new JButton("Show Messages Total");
		btnShowMessagesTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Show Messages Total");
			}
		});
		btnShowMessagesTotal.setBounds(395, 422, 182, 66);
		frmMinitwitter.getContentPane().add(btnShowMessagesTotal);
		
		JButton btnShowUserTotal = new JButton("Show User Total");
		btnShowUserTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Show User Total");
			}
		});
		btnShowUserTotal.setBounds(395, 345, 182, 66);
		frmMinitwitter.getContentPane().add(btnShowUserTotal);
		
		JButton btnShowGroupTotal = new JButton("Show Group Total");
		btnShowGroupTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Show Group Total");
			}
		});
		btnShowGroupTotal.setBounds(587, 345, 182, 66);
		frmMinitwitter.getContentPane().add(btnShowGroupTotal);
		
		txtUserId = new JTextField();
		txtUserId.setText("User Id");
		txtUserId.setBounds(395, 11, 182, 26);
		frmMinitwitter.getContentPane().add(txtUserId);
		txtUserId.setColumns(10);
		
		txtGroupId = new JTextField();
		txtGroupId.setText("Group Id");
		txtGroupId.setBounds(587, 11, 182, 26);
		frmMinitwitter.getContentPane().add(txtGroupId);
		txtGroupId.setColumns(10);
		
		JTree TreeView = new JTree();
		TreeView.setBounds(10, 16, 375, 472);
		frmMinitwitter.getContentPane().add(TreeView);
	}
}
