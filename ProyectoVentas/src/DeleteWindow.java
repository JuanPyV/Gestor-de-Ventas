// Abigail Guadarrama Victoria A01635153
// Juan Pablo Velazco Velasquez A00368753

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.NoSuchElementException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class DeleteWindow {

	private JFrame frmDeleteForm;
	private JTextField textFieldID;

	private LeerCSV datos;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteWindow window = new DeleteWindow();
					window.frmDeleteForm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DeleteWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDeleteForm = new JFrame();
		frmDeleteForm.setTitle("DELETE FORM");
		frmDeleteForm.getContentPane().setBackground(new Color(238, 232, 170));
		frmDeleteForm.setBounds(100, 100, 885, 309);

		JLabel deleteLabel = new JLabel("DELETE AN ITEM");
		deleteLabel.setForeground(new Color(32, 178, 170));
		deleteLabel.setBackground(new Color(238, 232, 170));
		deleteLabel.setHorizontalAlignment(SwingConstants.CENTER);
		deleteLabel.setFont(new Font("Calibri", Font.BOLD, 27));

		JLabel lblOrderid = new JLabel("OrderID:");
		lblOrderid.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrderid.setFont(new Font("Calibri Light", Font.PLAIN, 26));
		lblOrderid.setForeground(new Color(128, 0, 0));
		lblOrderid.setBackground(new Color(238, 232, 170));

		textFieldID = new JTextField();
		textFieldID.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		table = new JTable();
		table.setRowSelectionAllowed(false);
		table.setEnabled(false);
		table.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "Region", "Country", "Item Type", "Sales Channel", "Order Priority", "Order Date", "Order ID",
				"Ship Date", "Units Sold", "Unit Price", "Unit Cost", "Total Revenue", "Total Cost", "Total Profit" }) {
			/**
					 * 
					 */
			private static final long serialVersionUID = 1L;
			boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, false, false,
					false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		DefaultTableModel model = (DefaultTableModel) table.getModel();

		JButton deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//// para setear la jtable vacia
				model.setRowCount(0);
				try {
					datos = LeerCSV.cargarListaDatos(new File("salesReport.bin"));
					SalesData objeto = datos.encontrar(textFieldID.getText());
					String ref = textFieldID.getText();
					datos.getLista().delete(ref);
					datos.lecturaDatos();
					String datosList = objeto.getRegion() + ", " + objeto.getCountry() + ", " + objeto.getItem_Type()
							+ ", " + objeto.getSales_Channel() + ", " + objeto.getOrder_Priority() + ", "
							+ objeto.getOrder_Date() + ", " + objeto.getOrder_ID() + ", " + objeto.getShip_Date() + ", "
							+ objeto.getUnits_Sold() + ", " + objeto.getUnit_Price() + ", " + objeto.getUnit_Cost()
							+ ", " + objeto.getTotal_Revenue() + ", " + objeto.getTotal_Cost() + ", "
							+ objeto.getTotal_Profit();
					String[] dataRow = datosList.split(",");
					model.addRow(dataRow);
				} catch (NoSuchElementException exp) {
					JOptionPane.showMessageDialog(frmDeleteForm, "No se encontro esta referencia");
				}
			}
		});

		JLabel lblNewLabel = new JLabel("Deleted Item:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));

		GroupLayout groupLayout = new GroupLayout(frmDeleteForm.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(deleteLabel,
								GroupLayout.DEFAULT_SIZE, 856, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup().addGap(36)
								.addComponent(lblOrderid, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textFieldID, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
								.addGap(48).addComponent(deleteButton, GroupLayout.PREFERRED_SIZE, 120,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(lblNewLabel))
						.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(scrollPane,
								GroupLayout.DEFAULT_SIZE, 849, Short.MAX_VALUE)))
				.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(30).addComponent(deleteLabel).addGap(43)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblOrderid, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(deleteButton, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGap(18).addComponent(lblNewLabel).addGap(18)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE).addGap(22)));

		frmDeleteForm.getContentPane().setLayout(groupLayout);
	}
}
