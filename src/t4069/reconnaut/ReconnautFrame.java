package t4069.reconnaut;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class ReconnautFrame extends JFrame {

	private final HashMap<String, HashMap<String, HashMap<String,  HashMap<String, Object>>>> entryMap = 
			new HashMap<String, HashMap<String, HashMap<String,  HashMap<String, Object>>>>();
	private static final long serialVersionUID = -4388059251901151481L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReconnautFrame frame = new ReconnautFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ReconnautFrame() { // form generation
		setResizable(false);
		setTitle("Reconnaut");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTeamNumber = new JLabel("Team Number:");
		lblTeamNumber.setBounds(31, 12, 107, 15);
		contentPane.add(lblTeamNumber);
		
		JLabel lblMatchDate = new JLabel("Match Date:");
		lblMatchDate.setBounds(251, 12, 86, 15);
		contentPane.add(lblMatchDate);
		
		JLabel lblMatchTime = new JLabel("Match Time:");
		lblMatchTime.setBounds(440, 12, 86, 15);
		contentPane.add(lblMatchTime);
		ActionListener comboBoxListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox box = (JComboBox) e.getSource();
				String str = ((JTextField)box.getEditor().getEditorComponent()).getText().toString()s;
			}};
		
		JComboBox comboBox = new JComboBox();
		comboBox.setEditable(true);
		comboBox.setBounds(147, 7, 86, 24);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setEditable(true);
		comboBox_1.setBounds(345, 7, 77, 24);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.addActionListener(comboBoxListener);
		comboBox_2.setEditable(true);
		comboBox_2.setBounds(544, 7, 67, 24);
		contentPane.add(comboBox_2);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(147, 325, 117, 25);
		contentPane.add(btnSave);
	}
}
