import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JTextPane;


public class MiniTwitter {
	
	public static Map<String, Users> userMap = new HashMap<String, Users>();

	private JFrame frmMinitwitter;
	private JTextField txtUserId;
	private JTextField txtGroupId;
	
	
	//Singleton implementation
	private static MiniTwitter instance = null;
	private JTextField txtUserViewId;
	
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
		
		final JTextPane txtpnOutput = new JTextPane();
		txtpnOutput.setText("Output");
		txtpnOutput.setBounds(395, 251, 374, 72);
		frmMinitwitter.getContentPane().add(txtpnOutput);
		
		JButton btnAddUser = new JButton("Add User");
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Users user = new Users();
				user.setUserID(txtUserId.getText());
				if(!userMap.containsKey(txtUserId.getText())){
					userMap.put(txtUserId.getText(), user);
				}
				
				txtpnOutput.setText("User was added: " + user.getUserID());
				System.out.println("User was added: " + user.getUserID());
			}
		});
		btnAddUser.setBounds(395, 48, 182, 60);
		frmMinitwitter.getContentPane().add(btnAddUser);
		
		JButton btnAddGroup = new JButton("Add Group");
		btnAddGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Groups group = new Groups();
				group.setGroupID(txtGroupId.getText());
				txtpnOutput.setText("Group was added: " + group.getGroupID());
				System.out.println("Group was added: " + group.getGroupID());
			}
		});
		btnAddGroup.setBounds(587, 48, 182, 60);
		frmMinitwitter.getContentPane().add(btnAddGroup);
		
		JButton btnOpenUserView = new JButton("Open User View");
		btnOpenUserView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!userMap.containsKey(txtUserViewId.getText())){
					txtpnOutput.setText("User: "+txtUserViewId.getText() + " does not exist.");
					System.out.println("User: "+txtUserViewId.getText() + " does not exist.");
				}else{
				UserView openView = new UserView(null);
				openView.run(txtUserViewId.getText());
				txtpnOutput.setText("Open User View : " + txtUserViewId.getText());
				System.out.println("Open User View : " + txtUserViewId.getText());
				}
			}
		});
		btnOpenUserView.setBounds(395, 174, 374, 60);
		frmMinitwitter.getContentPane().add(btnOpenUserView);
		
		JButton btnShowPositivePercentage = new JButton("Show Positive Percentage");
		btnShowPositivePercentage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				positivePercentage test = new positivePercentage();
				txtpnOutput.setText("Percentage of positive Tweets : " + test.getPercentage() + "%");
				System.out.println("Percentage of positive Tweets : " + test.getPercentage() + "%");
			}
		});
		btnShowPositivePercentage.setBounds(587, 422, 182, 66);
		frmMinitwitter.getContentPane().add(btnShowPositivePercentage);
		
		JButton btnShowMessagesTotal = new JButton("Show Messages Total");
		btnShowMessagesTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtpnOutput.setText("Total number of messages: " + Users.getTotalMessages());
				System.out.println("Total number of messages: " + Users.getTotalMessages());
			}
		});
		btnShowMessagesTotal.setBounds(395, 422, 182, 66);
		frmMinitwitter.getContentPane().add(btnShowMessagesTotal);
		
		JButton btnShowUserTotal = new JButton("Show User Total");
		btnShowUserTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtpnOutput.setText("Total number of users: " + userMap.size());
				System.out.println("Total number of users: " + userMap.size());
			}
		});
		btnShowUserTotal.setBounds(395, 345, 182, 66);
		frmMinitwitter.getContentPane().add(btnShowUserTotal);
		
		JButton btnShowGroupTotal = new JButton("Show Group Total");
		btnShowGroupTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtpnOutput.setText("Total number of groups: " + Groups.getTotalGroups());
				System.out.println("Total number of groups: " + Groups.getTotalGroups());
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
		TreeView.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Root") {
				{
					DefaultMutableTreeNode node_1;
					DefaultMutableTreeNode node_2;
					add(new DefaultMutableTreeNode("john"));
					add(new DefaultMutableTreeNode("bob"));
					add(new DefaultMutableTreeNode("steve"));
					node_1 = new DefaultMutableTreeNode("CS356");
						node_1.add(new DefaultMutableTreeNode("stu1"));
						node_1.add(new DefaultMutableTreeNode("stu2"));
						node_1.add(new DefaultMutableTreeNode("stu3"));
						node_2 = new DefaultMutableTreeNode("CS356Session01");
							node_2.add(new DefaultMutableTreeNode("stu8"));
							node_2.add(new DefaultMutableTreeNode("stu9"));
							node_2.add(new DefaultMutableTreeNode("stu10"));
						node_1.add(node_2);
						node_1.add(new DefaultMutableTreeNode("stu4"));
					add(node_1);
					add(new DefaultMutableTreeNode("oostu"));
					add(new DefaultMutableTreeNode("ppstu2"));
				}
			}
		));
	
		
		
		TreeView.setBounds(10, 16, 375, 472);
		frmMinitwitter.getContentPane().add(TreeView);
		
		txtUserViewId = new JTextField();
		txtUserViewId.setText("User View Id");
		txtUserViewId.setBounds(395, 137, 374, 26);
		frmMinitwitter.getContentPane().add(txtUserViewId);
		txtUserViewId.setColumns(10);
		

		
		
	}
}
