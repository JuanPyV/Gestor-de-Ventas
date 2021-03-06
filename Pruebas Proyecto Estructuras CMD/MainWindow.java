// Abigail Guadarrama Victoria A01635153
// Juan Pablo Velazco Velasquez A00368753

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow {

	private JFrame frmSalesReport;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmSalesReport.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSalesReport = new JFrame();
		frmSalesReport.setTitle("SALES REPORT");
		frmSalesReport.getContentPane().setBackground(new Color(250, 128, 114));
		frmSalesReport.setBounds(100, 100, 535, 366);
		frmSalesReport.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblSalesRecord = new JLabel("SALES REPORT");
		lblSalesRecord.setForeground(new Color(47, 79, 79));
		lblSalesRecord.setFont(new Font("Calibri", Font.BOLD, 29));
		lblSalesRecord.setBackground(new Color(178, 34, 34));
		lblSalesRecord.setHorizontalAlignment(SwingConstants.CENTER);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DeleteWindow.main(null);
			}
		});

		JButton btnConsultData = new JButton("Consult Data");
		btnConsultData.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		btnConsultData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConsultWindow.main(null);
			}
		});

		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddWindow.main(null);
			}
		});

		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SearchWindow.main(null);
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmSalesReport.getContentPane());
		groupLayout
				.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSalesRecord, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup().addGap(40)
								.addComponent(btnDelete, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE).addGap(264)
								.addComponent(btnAdd, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addGap(87))
						.addGroup(groupLayout.createSequentialGroup().addGap(189)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addGroup(groupLayout.createSequentialGroup().addGap(32).addComponent(btnSearch,
												GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addComponent(btnConsultData, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGap(225)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(22).addComponent(lblSalesRecord).addGap(33).addComponent(btnConsultData)
				.addGap(37)
				.addGroup(
						groupLayout.createParallelGroup(Alignment.LEADING).addComponent(btnDelete).addComponent(btnAdd))
				.addGap(31).addComponent(btnSearch).addGap(93)));
		frmSalesReport.getContentPane().setLayout(groupLayout);
	}
}
