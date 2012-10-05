
package t4069.reconnaut;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ReconnautFrame extends JFrame {

	private final HashMap<String, HashMap<String, HashMap<String, HashMap<String, Object>>>> entryMap =
			new HashMap<String, HashMap<String, HashMap<String, HashMap<String, Object>>>>();
	private static final long serialVersionUID = -4388059251901151481L;

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

	private JPanel contentPane;
	private JComboBox dateBox;
	private JComboBox numberBox;
	private JComboBox timeBox;

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
		lblMatchDate.setBounds(222, 12, 86, 15);
		contentPane.add(lblMatchDate);

		JLabel lblMatchTime = new JLabel("Match Time:");
		lblMatchTime.setBounds(440, 12, 86, 15);
		contentPane.add(lblMatchTime);

		numberBox = new JComboBox();
		numberBox.setEditable(true);
		numberBox.setBounds(126, 7, 86, 24);
		contentPane.add(numberBox);

		dateBox = new JComboBox();
		dateBox.setEditable(true);
		dateBox.setBounds(303, 7, 107, 24);
		contentPane.add(dateBox);

		timeBox = new JComboBox();
		timeBox.setEditable(true);
		timeBox.setBounds(519, 7, 86, 24);
		contentPane.add(timeBox);
		ItemListener dateListener = new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				numberBox.setSelectedItem(arg0.getItem());
				if (entryMap.get(arg0.getItem().toString()) != null) {
					dateBox.removeAllItems();
					for (String s : entryMap
							.get(arg0.getItem().toString()).keySet()) {
						dateBox.addItem(s);
					}
				}
			}
		};
		numberBox.addItemListener(dateListener);

		JButton btnSave = new JButton("Save");
		btnSave.setBounds(190, 329, 117, 23);
		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		contentPane.add(btnSave);

		JButton btnNewButton = new JButton("Load");
		btnNewButton.setBounds(318, 329, 126, 23);
		contentPane.add(btnNewButton);

		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(268, 364, 89, 23);
		contentPane.add(btnExit);
		btnExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
	}

	private void refreshBoxes() {

	}

	private void save() {
		String number = numberBox.getSelectedItem().toString().trim();
		if (entryMap.get(number) == null) {
			entryMap.put(
					number,
					new HashMap<String, HashMap<String, HashMap<String, Object>>>());
			numberBox.addItem(number);
		}
		String date = dateBox.getSelectedItem().toString().trim();
		if (entryMap.get(number).get(date) == null) {
			entryMap.get(number).put(date,
					new HashMap<String, HashMap<String, Object>>());
			dateBox.addItem(date);
		}
		String time = timeBox.getSelectedItem().toString().trim();
		if (entryMap.get(number).get(date).get(time) == null) {
			entryMap.get(number).get(date)
					.put(time, new HashMap<String, Object>());
			timeBox.addItem(time);
		}
		refreshBoxes();

	}
}
