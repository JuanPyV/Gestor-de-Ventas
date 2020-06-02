// Abigail Guadarrama Victoria A01635153
// Juan Pablo Velazco Velasquez A00368753

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

public class SearchWindow {

	private JFrame frmSearchForm;
	private JTextField regionTextField;
	private JTextField countyTextField;
	private JTextField orderIDTextField;
	private JTextField unitsTextField;
	private JTextField unitPriceTextField;
	private JTextField unitCostTextField;
	private JTextField revenueTextField;
	private JTextField costTextField;
	private JTextField profitTextField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchWindow window = new SearchWindow();
					window.frmSearchForm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SearchWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSearchForm = new JFrame();
		frmSearchForm.setResizable(false);
		frmSearchForm.getContentPane().setBackground(new Color(176, 224, 230));
		frmSearchForm.setTitle("SEARCH FORM");
		frmSearchForm.setBounds(100, 100, 948, 734);
		frmSearchForm.getContentPane().setLayout(null);

		JLabel lblSearchForAn = new JLabel("SEARCH FOR AN ITEM");
		lblSearchForAn.setBounds(10, 11, 864, 31);
		lblSearchForAn.setBackground(new Color(176, 224, 230));
		lblSearchForAn.setForeground(new Color(139, 69, 19));
		lblSearchForAn.setFont(new Font("Calibri", Font.BOLD, 25));
		lblSearchForAn.setHorizontalAlignment(SwingConstants.CENTER);
		frmSearchForm.getContentPane().add(lblSearchForAn);

		JLabel regionLabel = new JLabel("Region:");
		regionLabel.setForeground(new Color(139, 69, 19));
		regionLabel.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		regionLabel.setBackground(new Color(176, 224, 230));
		regionLabel.setBounds(42, 54, 70, 19);
		frmSearchForm.getContentPane().add(regionLabel);

		regionTextField = new JTextField();
		regionTextField.setBounds(91, 53, 122, 25);
		frmSearchForm.getContentPane().add(regionTextField);
		regionTextField.setColumns(10);

		JLabel countryLabel = new JLabel("Country:");
		countryLabel.setForeground(new Color(139, 69, 19));
		countryLabel.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		countryLabel.setBackground(new Color(176, 224, 230));
		countryLabel.setBounds(283, 54, 62, 19);
		frmSearchForm.getContentPane().add(countryLabel);

		countyTextField = new JTextField();
		countyTextField.setBounds(341, 53, 111, 25);
		frmSearchForm.getContentPane().add(countyTextField);
		countyTextField.setColumns(10);

		JLabel lblItemType = new JLabel("Item Type:");
		lblItemType.setForeground(new Color(139, 69, 19));
		lblItemType.setBackground(new Color(176, 224, 230));
		lblItemType.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		lblItemType.setBounds(510, 52, 77, 19);
		frmSearchForm.getContentPane().add(lblItemType);

		JComboBox<String> itemTypeComboBox = new JComboBox<String>();
		itemTypeComboBox.setBounds(580, 50, 86, 22);
		frmSearchForm.getContentPane().add(itemTypeComboBox);
		itemTypeComboBox.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Baby Food", "Beverages", "Cereal", "Clothes", "Cosmetics", "Fruits", "Household",
						"Meat", "Office Suplies", "Personal care", "Snack", "Vegetables" }));

		JButton btnRegion = new JButton("Search");
		btnRegion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				LeerCSV datos = LeerCSV.cargarListaDatos(new File("salesReport.bin"));
				LinkedList<SalesData> lista = datos.findRegion(regionTextField.getText().replaceAll("\\s", "-"));
				if (lista.size() == 0) {
					JOptionPane.showMessageDialog(frmSearchForm, "No se encontraron registros con ese valor");
				}
				for (int i = 0; i < lista.size(); i++) {
					SalesData objeto = lista.get(i);
					String datosList = objeto.getRegion().replaceAll("-", " ") + ", "
							+ objeto.getCountry().replaceAll("-", " ") + ", "
							+ objeto.getItem_Type().replaceAll("-", " ") + ", " + objeto.getSales_Channel() + ", "
							+ objeto.getOrder_Priority() + ", " + objeto.getOrder_Date() + ", " + objeto.getOrder_ID()
							+ ", " + objeto.getShip_Date() + ", " + objeto.getUnits_Sold() + ", "
							+ objeto.getUnit_Price() + ", " + objeto.getUnit_Cost() + ", " + objeto.getTotal_Revenue()
							+ ", " + objeto.getTotal_Cost() + ", " + objeto.getTotal_Profit() + "\n";
					String[] dataRow = datosList.split(",");
					model.addRow(dataRow);
				}

			}
		});
		btnRegion.setBounds(42, 84, 89, 23);
		frmSearchForm.getContentPane().add(btnRegion);

		JButton btnCountry = new JButton("Search");
		btnCountry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				LeerCSV datos = LeerCSV.cargarListaDatos(new File("salesReport.bin"));
				LinkedList<SalesData> lista = datos.findCountry(countyTextField.getText().replaceAll("\\s", "-"));
				if (lista.size() == 0) {
					JOptionPane.showMessageDialog(frmSearchForm, "No se encontraron registros con ese valor");
				}
				for (int i = 0; i < lista.size(); i++) {
					SalesData objeto = lista.get(i);
					String datosList = objeto.getRegion().replaceAll("-", " ") + ", "
							+ objeto.getCountry().replaceAll("-", " ") + ", "
							+ objeto.getItem_Type().replaceAll("-", " ") + ", " + objeto.getSales_Channel() + ", "
							+ objeto.getOrder_Priority() + ", " + objeto.getOrder_Date() + ", " + objeto.getOrder_ID()
							+ ", " + objeto.getShip_Date() + ", " + objeto.getUnits_Sold() + ", "
							+ objeto.getUnit_Price() + ", " + objeto.getUnit_Cost() + ", " + objeto.getTotal_Revenue()
							+ ", " + objeto.getTotal_Cost() + ", " + objeto.getTotal_Profit() + "\n";
					String[] dataRow = datosList.split(",");
					model.addRow(dataRow);
				}

			}
		});
		btnCountry.setBounds(283, 84, 89, 23);
		frmSearchForm.getContentPane().add(btnCountry);

		JButton btnItem = new JButton("Search");
		btnItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				LeerCSV datos = LeerCSV.cargarListaDatos(new File("salesReport.bin"));
				LinkedList<SalesData> lista = datos
						.findItem(itemTypeComboBox.getSelectedItem().toString().replaceAll("\\s+", "-"));
				for (int i = 0; i < lista.size(); i++) {
					SalesData objeto = lista.get(i);
					String datosList = objeto.getRegion().replaceAll("-", " ") + ", "
							+ objeto.getCountry().replaceAll("-", " ") + ", "
							+ objeto.getItem_Type().replaceAll("-", " ") + ", " + objeto.getSales_Channel() + ", "
							+ objeto.getOrder_Priority() + ", " + objeto.getOrder_Date() + ", " + objeto.getOrder_ID()
							+ ", " + objeto.getShip_Date() + ", " + objeto.getUnits_Sold() + ", "
							+ objeto.getUnit_Price() + ", " + objeto.getUnit_Cost() + ", " + objeto.getTotal_Revenue()
							+ ", " + objeto.getTotal_Cost() + ", " + objeto.getTotal_Profit() + "\n";
					String[] dataRow = datosList.split(",");
					model.addRow(dataRow);
				}

			}

		});
		btnItem.setBounds(510, 82, 89, 23);
		frmSearchForm.getContentPane().add(btnItem);

		JLabel label = new JLabel(
				"-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		label.setBounds(10, 116, 915, 14);
		frmSearchForm.getContentPane().add(label);

		JLabel salesLabel = new JLabel("Sales Channel:");
		salesLabel.setForeground(new Color(139, 69, 19));
		salesLabel.setBackground(new Color(176, 224, 230));
		salesLabel.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		salesLabel.setBounds(720, 56, 89, 14);
		frmSearchForm.getContentPane().add(salesLabel);

		JLabel lblOrderPriority = new JLabel("Order Priority:");
		lblOrderPriority.setForeground(new Color(139, 69, 19));
		lblOrderPriority.setBackground(new Color(176, 224, 230));
		lblOrderPriority.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		lblOrderPriority.setBounds(42, 146, 89, 14);
		frmSearchForm.getContentPane().add(lblOrderPriority);

		JLabel lblOrderDate = new JLabel("Order Date:");
		lblOrderDate.setForeground(new Color(139, 69, 19));
		lblOrderDate.setBackground(new Color(176, 224, 230));
		lblOrderDate.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		lblOrderDate.setBounds(279, 146, 71, 14);
		frmSearchForm.getContentPane().add(lblOrderDate);

		JComboBox<String> SalesChComboBox = new JComboBox<String>();
		SalesChComboBox.setBounds(815, 50, 74, 22);
		frmSearchForm.getContentPane().add(SalesChComboBox);
		SalesChComboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "Online", "Offline" }));

		JButton btnSalesCha = new JButton("Search");
		btnSalesCha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				LeerCSV datos = LeerCSV.cargarListaDatos(new File("salesReport.bin"));
				LinkedList<SalesData> lista = datos.findSalesCh(SalesChComboBox.getSelectedItem().toString());
				for (int i = 0; i < lista.size(); i++) {
					SalesData objeto = lista.get(i);
					String datosList = objeto.getRegion().replaceAll("-", " ") + ", "
							+ objeto.getCountry().replaceAll("-", " ") + ", "
							+ objeto.getItem_Type().replaceAll("-", " ") + ", " + objeto.getSales_Channel() + ", "
							+ objeto.getOrder_Priority() + ", " + objeto.getOrder_Date() + ", " + objeto.getOrder_ID()
							+ ", " + objeto.getShip_Date() + ", " + objeto.getUnits_Sold() + ", "
							+ objeto.getUnit_Price() + ", " + objeto.getUnit_Cost() + ", " + objeto.getTotal_Revenue()
							+ ", " + objeto.getTotal_Cost() + ", " + objeto.getTotal_Profit() + "\n";
					String[] dataRow = datosList.split(",");
					model.addRow(dataRow);
				}

			}

		});
		btnSalesCha.setBounds(720, 81, 89, 23);
		frmSearchForm.getContentPane().add(btnSalesCha);

		JComboBox<String> OrderPrioComboBox = new JComboBox<String>();
		OrderPrioComboBox.setBounds(141, 140, 57, 22);
		frmSearchForm.getContentPane().add(OrderPrioComboBox);
		OrderPrioComboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "L", "M", "H", "C" }));

		JButton btnOrderPrio = new JButton("Search");
		btnOrderPrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				LeerCSV datos = LeerCSV.cargarListaDatos(new File("salesReport.bin"));
				LinkedList<SalesData> lista = datos.findOrderPrio(OrderPrioComboBox.getSelectedItem().toString());
				for (int i = 0; i < lista.size(); i++) {
					SalesData objeto = lista.get(i);
					String datosList = objeto.getRegion().replaceAll("-", " ") + ", "
							+ objeto.getCountry().replaceAll("-", " ") + ", "
							+ objeto.getItem_Type().replaceAll("-", " ") + ", " + objeto.getSales_Channel() + ", "
							+ objeto.getOrder_Priority() + ", " + objeto.getOrder_Date() + ", " + objeto.getOrder_ID()
							+ ", " + objeto.getShip_Date() + ", " + objeto.getUnits_Sold() + ", "
							+ objeto.getUnit_Price() + ", " + objeto.getUnit_Cost() + ", " + objeto.getTotal_Revenue()
							+ ", " + objeto.getTotal_Cost() + ", " + objeto.getTotal_Profit() + "\n";
					String[] dataRow = datosList.split(",");
					model.addRow(dataRow);
				}

			}
		});
		btnOrderPrio.setBounds(42, 174, 89, 23);
		frmSearchForm.getContentPane().add(btnOrderPrio);

		JLabel label_1 = new JLabel(
				"-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		label_1.setBounds(10, 200, 915, 14);
		frmSearchForm.getContentPane().add(label_1);

		JLabel lblOrderId = new JLabel("Order ID:");
		lblOrderId.setForeground(new Color(139, 69, 19));
		lblOrderId.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		lblOrderId.setBackground(new Color(176, 224, 230));
		lblOrderId.setBounds(510, 144, 62, 14);
		frmSearchForm.getContentPane().add(lblOrderId);

		orderIDTextField = new JTextField();
		orderIDTextField.setBounds(570, 141, 86, 25);
		frmSearchForm.getContentPane().add(orderIDTextField);
		orderIDTextField.setColumns(10);

		JLabel shipLabel = new JLabel("Ship Date:");
		shipLabel.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		shipLabel.setBackground(new Color(176, 224, 230));
		shipLabel.setForeground(new Color(139, 69, 19));
		shipLabel.setBounds(720, 144, 77, 14);
		frmSearchForm.getContentPane().add(shipLabel);

		JLabel lblUnitsSold = new JLabel("Units Sold:");
		lblUnitsSold.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		lblUnitsSold.setBackground(new Color(176, 224, 230));
		lblUnitsSold.setForeground(new Color(139, 69, 19));
		lblUnitsSold.setBounds(42, 230, 70, 14);
		frmSearchForm.getContentPane().add(lblUnitsSold);

		unitsTextField = new JTextField();
		unitsTextField.setBounds(113, 227, 111, 25);
		frmSearchForm.getContentPane().add(unitsTextField);
		unitsTextField.setColumns(10);

		JButton btnOrderID = new JButton("Search");
		btnOrderID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					((DefaultTableModel) table.getModel()).setRowCount(0);
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					LeerCSV datos = LeerCSV.cargarListaDatos(new File("salesReport.bin"));
					SalesData objeto = datos.encontrar(orderIDTextField.getText());
					String datosList = objeto.getRegion().replaceAll("-", " ") + ", "
							+ objeto.getCountry().replaceAll("-", " ") + ", "
							+ objeto.getItem_Type().replaceAll("-", " ") + ", " + objeto.getSales_Channel() + ", "
							+ objeto.getOrder_Priority() + ", " + objeto.getOrder_Date() + ", " + objeto.getOrder_ID()
							+ ", " + objeto.getShip_Date() + ", " + objeto.getUnits_Sold() + ", "
							+ objeto.getUnit_Price() + ", " + objeto.getUnit_Cost() + ", " + objeto.getTotal_Revenue()
							+ ", " + objeto.getTotal_Cost() + ", " + objeto.getTotal_Profit() + "\n";
					String[] dataRow = datosList.split(",");
					model.addRow(dataRow);
				} catch (NoSuchElementException d) {
					JOptionPane.showMessageDialog(frmSearchForm, "No se encontro esta referencia");
				}

			}
		});
		btnOrderID.setBounds(510, 169, 89, 23);
		frmSearchForm.getContentPane().add(btnOrderID);

		JButton btnUnitsSoldEqual = new JButton("=");
		btnUnitsSoldEqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((DefaultTableModel) table.getModel()).setRowCount(0);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				LeerCSV datos = LeerCSV.cargarListaDatos(new File("salesReport.bin"));
				try {
					LinkedList<SalesData> lista = datos.findUnitsSoldEqual(Integer.parseInt(unitsTextField.getText()));
					if (lista.size() == 0) {
						JOptionPane.showMessageDialog(frmSearchForm, "No se encontraron registros con ese valor");
					}
					for (int i = 0; i < lista.size(); i++) {
						SalesData objeto = lista.get(i);
						String datosList = objeto.getRegion().replaceAll("-", " ") + ", "
								+ objeto.getCountry().replaceAll("-", " ") + ", "
								+ objeto.getItem_Type().replaceAll("-", " ") + ", " + objeto.getSales_Channel() + ", "
								+ objeto.getOrder_Priority() + ", " + objeto.getOrder_Date() + ", "
								+ objeto.getOrder_ID() + ", " + objeto.getShip_Date() + ", " + objeto.getUnits_Sold()
								+ ", " + objeto.getUnit_Price() + ", " + objeto.getUnit_Cost() + ", "
								+ objeto.getTotal_Revenue() + ", " + objeto.getTotal_Cost() + ", "
								+ objeto.getTotal_Profit() + "\n";
						String[] dataRow = datosList.split(",");
						model.addRow(dataRow);
					}

				} catch (NumberFormatException a) {
					JOptionPane.showMessageDialog(frmSearchForm, "Ingresa un dato numerico valido");
				}

			}
		});
		btnUnitsSoldEqual.setBounds(113, 255, 45, 23);
		frmSearchForm.getContentPane().add(btnUnitsSoldEqual);

		JLabel label_2 = new JLabel(
				"-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		label_2.setBounds(10, 284, 915, 14);
		frmSearchForm.getContentPane().add(label_2);

		JLabel unitPriceLabel = new JLabel("Unit Price:");
		unitPriceLabel.setBackground(new Color(176, 224, 230));
		unitPriceLabel.setForeground(new Color(139, 69, 19));
		unitPriceLabel.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		unitPriceLabel.setBounds(287, 228, 62, 14);
		frmSearchForm.getContentPane().add(unitPriceLabel);

		unitPriceTextField = new JTextField();
		unitPriceTextField.setBounds(357, 226, 86, 25);
		frmSearchForm.getContentPane().add(unitPriceTextField);
		unitPriceTextField.setColumns(10);

		JLabel lblUnitCost = new JLabel("Unit Cost:");
		lblUnitCost.setBackground(new Color(176, 224, 230));
		lblUnitCost.setForeground(new Color(139, 69, 19));
		lblUnitCost.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		lblUnitCost.setBounds(518, 228, 69, 14);
		frmSearchForm.getContentPane().add(lblUnitCost);

		unitCostTextField = new JTextField();
		unitCostTextField.setBounds(580, 225, 86, 25);
		frmSearchForm.getContentPane().add(unitCostTextField);
		unitCostTextField.setColumns(10);

		JLabel lblTotalRevenue = new JLabel("Total Revenue:");
		lblTotalRevenue.setBackground(new Color(176, 224, 230));
		lblTotalRevenue.setForeground(new Color(139, 69, 19));
		lblTotalRevenue.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		lblTotalRevenue.setBounds(720, 228, 95, 14);
		frmSearchForm.getContentPane().add(lblTotalRevenue);

		revenueTextField = new JTextField();
		revenueTextField.setBounds(825, 225, 76, 25);
		frmSearchForm.getContentPane().add(revenueTextField);
		revenueTextField.setColumns(10);

		JButton btnUnitPriceEqual = new JButton("=");
		btnUnitPriceEqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((DefaultTableModel) table.getModel()).setRowCount(0);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				LeerCSV datos = LeerCSV.cargarListaDatos(new File("salesReport.bin"));
				try {
					LinkedList<SalesData> lista = datos
							.findUnitPriceEqual(Double.parseDouble(unitPriceTextField.getText()));
					if (lista.size() == 0) {
						JOptionPane.showMessageDialog(frmSearchForm, "No se encontraron registros con ese valor");
					}
					for (int i = 0; i < lista.size(); i++) {
						SalesData objeto = lista.get(i);
						String datosList = objeto.getRegion() + ", " + objeto.getCountry() + ", "
								+ objeto.getItem_Type() + ", " + objeto.getSales_Channel() + ", "
								+ objeto.getOrder_Priority() + ", " + objeto.getOrder_Date() + ", "
								+ objeto.getOrder_ID() + ", " + objeto.getShip_Date() + ", " + objeto.getUnits_Sold()
								+ ", " + objeto.getUnit_Price() + ", " + objeto.getUnit_Cost() + ", "
								+ objeto.getTotal_Revenue() + ", " + objeto.getTotal_Cost() + ", "
								+ objeto.getTotal_Profit();
						String[] dataRow = datosList.split(",");
						model.addRow(dataRow);
					}

				} catch (NumberFormatException a) {
					JOptionPane.showMessageDialog(frmSearchForm, "Ingresa un dato numerico valido");
				}

			}
		});
		btnUnitPriceEqual.setBounds(353, 255, 45, 23);
		frmSearchForm.getContentPane().add(btnUnitPriceEqual);

		JButton btnUnitCostEqual = new JButton("=");
		btnUnitCostEqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((DefaultTableModel) table.getModel()).setRowCount(0);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				LeerCSV datos = LeerCSV.cargarListaDatos(new File("salesReport.bin"));
				try {
					LinkedList<SalesData> lista = datos
							.findUnitCostEqual(Double.parseDouble(unitCostTextField.getText()));
					if (lista.size() == 0) {
						JOptionPane.showMessageDialog(frmSearchForm, "No se encontraron registros con ese valor");
					}
					for (int i = 0; i < lista.size(); i++) {
						SalesData objeto = lista.get(i);
						String datosList = objeto.getRegion() + ", " + objeto.getCountry() + ", "
								+ objeto.getItem_Type() + ", " + objeto.getSales_Channel() + ", "
								+ objeto.getOrder_Priority() + ", " + objeto.getOrder_Date() + ", "
								+ objeto.getOrder_ID() + ", " + objeto.getShip_Date() + ", " + objeto.getUnits_Sold()
								+ ", " + objeto.getUnit_Price() + ", " + objeto.getUnit_Cost() + ", "
								+ objeto.getTotal_Revenue() + ", " + objeto.getTotal_Cost() + ", "
								+ objeto.getTotal_Profit();
						String[] dataRow = datosList.split(",");
						model.addRow(dataRow);
					}

				} catch (NumberFormatException a) {
					JOptionPane.showMessageDialog(frmSearchForm, "Ingresa un dato numerico valido");
				}

			}
		});
		btnUnitCostEqual.setBounds(579, 255, 45, 23);
		frmSearchForm.getContentPane().add(btnUnitCostEqual);

		JButton btnTotalRevenueEqual = new JButton("=");
		btnTotalRevenueEqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((DefaultTableModel) table.getModel()).setRowCount(0);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				LeerCSV datos = LeerCSV.cargarListaDatos(new File("salesReport.bin"));
				try {
					LinkedList<SalesData> lista = datos
							.findTotalRevenueEqual(Double.parseDouble(revenueTextField.getText()));
					if (lista.size() == 0) {
						JOptionPane.showMessageDialog(frmSearchForm, "No se encontraron registros con ese valor");
					}
					for (int i = 0; i < lista.size(); i++) {
						SalesData objeto = lista.get(i);
						String datosList = objeto.getRegion() + ", " + objeto.getCountry() + ", "
								+ objeto.getItem_Type() + ", " + objeto.getSales_Channel() + ", "
								+ objeto.getOrder_Priority() + ", " + objeto.getOrder_Date() + ", "
								+ objeto.getOrder_ID() + ", " + objeto.getShip_Date() + ", " + objeto.getUnits_Sold()
								+ ", " + objeto.getUnit_Price() + ", " + objeto.getUnit_Cost() + ", "
								+ objeto.getTotal_Revenue() + ", " + objeto.getTotal_Cost() + ", "
								+ objeto.getTotal_Profit();
						String[] dataRow = datosList.split(",");
						model.addRow(dataRow);
					}

				} catch (NumberFormatException a) {
					JOptionPane.showMessageDialog(frmSearchForm, "Ingresa un dato numerico valido");
				}

			}
		});
		btnTotalRevenueEqual.setBounds(785, 255, 45, 23);
		frmSearchForm.getContentPane().add(btnTotalRevenueEqual);

		JLabel label_4 = new JLabel(
				"-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		label_4.setBounds(10, 365, 915, 14);
		frmSearchForm.getContentPane().add(label_4);

		JLabel lblTotalCost = new JLabel("Total Cost:");
		lblTotalCost.setBackground(new Color(176, 224, 230));
		lblTotalCost.setForeground(new Color(139, 69, 19));
		lblTotalCost.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		lblTotalCost.setBounds(42, 314, 70, 14);
		frmSearchForm.getContentPane().add(lblTotalCost);

		costTextField = new JTextField();
		costTextField.setBounds(112, 311, 86, 25);
		frmSearchForm.getContentPane().add(costTextField);
		costTextField.setColumns(10);

		JLabel lblTotalProfit = new JLabel("Total Profit:");
		lblTotalProfit.setForeground(new Color(139, 69, 19));
		lblTotalProfit.setBackground(new Color(176, 224, 230));
		lblTotalProfit.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		lblTotalProfit.setBounds(283, 312, 77, 14);
		frmSearchForm.getContentPane().add(lblTotalProfit);

		profitTextField = new JTextField();
		profitTextField.setBounds(360, 309, 86, 25);
		frmSearchForm.getContentPane().add(profitTextField);
		profitTextField.setColumns(10);

		JButton btnTotalCostEqual = new JButton("=");
		btnTotalCostEqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((DefaultTableModel) table.getModel()).setRowCount(0);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				LeerCSV datos = LeerCSV.cargarListaDatos(new File("salesReport.bin"));
				try {
					LinkedList<SalesData> lista = datos.findTotalCostEqual(Double.parseDouble(costTextField.getText()));
					if (lista.size() == 0) {
						JOptionPane.showMessageDialog(frmSearchForm, "No se encontraron registros con ese valor");
					}
					for (int i = 0; i < lista.size(); i++) {
						SalesData objeto = lista.get(i);
						String datosList = objeto.getRegion() + ", " + objeto.getCountry() + ", "
								+ objeto.getItem_Type() + ", " + objeto.getSales_Channel() + ", "
								+ objeto.getOrder_Priority() + ", " + objeto.getOrder_Date() + ", "
								+ objeto.getOrder_ID() + ", " + objeto.getShip_Date() + ", " + objeto.getUnits_Sold()
								+ ", " + objeto.getUnit_Price() + ", " + objeto.getUnit_Cost() + ", "
								+ objeto.getTotal_Revenue() + ", " + objeto.getTotal_Cost() + ", "
								+ objeto.getTotal_Profit();
						String[] dataRow = datosList.split(",");
						model.addRow(dataRow);
					}

				} catch (NumberFormatException a) {
					JOptionPane.showMessageDialog(frmSearchForm, "Ingresa un dato numerico valido");
				}

			}
		});
		btnTotalCostEqual.setBounds(86, 339, 45, 23);
		frmSearchForm.getContentPane().add(btnTotalCostEqual);

		JButton btnTotalProfitEqual = new JButton("=");
		btnTotalProfitEqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((DefaultTableModel) table.getModel()).setRowCount(0);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				LeerCSV datos = LeerCSV.cargarListaDatos(new File("salesReport.bin"));
				try {
					LinkedList<SalesData> lista = datos
							.findTotalProfitEqual(Double.parseDouble(profitTextField.getText()));
					if (lista.size() == 0) {
						JOptionPane.showMessageDialog(frmSearchForm, "No se encontraron registros con ese valor");
					}
					for (int i = 0; i < lista.size(); i++) {
						SalesData objeto = lista.get(i);
						String datosList = objeto.getRegion() + ", " + objeto.getCountry() + ", "
								+ objeto.getItem_Type() + ", " + objeto.getSales_Channel() + ", "
								+ objeto.getOrder_Priority() + ", " + objeto.getOrder_Date() + ", "
								+ objeto.getOrder_ID() + ", " + objeto.getShip_Date() + ", " + objeto.getUnits_Sold()
								+ ", " + objeto.getUnit_Price() + ", " + objeto.getUnit_Cost() + ", "
								+ objeto.getTotal_Revenue() + ", " + objeto.getTotal_Cost() + ", "
								+ objeto.getTotal_Profit();
						String[] dataRow = datosList.split(",");
						model.addRow(dataRow);
					}

				} catch (NumberFormatException a) {
					JOptionPane.showMessageDialog(frmSearchForm, "Ingresa un dato numerico valido");
				}

			}
		});
		btnTotalProfitEqual.setBounds(341, 337, 45, 23);
		frmSearchForm.getContentPane().add(btnTotalProfitEqual);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 403, 915, 266);
		frmSearchForm.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

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

		JButton btnUnitsSoldHigh = new JButton(">");
		btnUnitsSoldHigh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((DefaultTableModel) table.getModel()).setRowCount(0);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				LeerCSV datos = LeerCSV.cargarListaDatos(new File("salesReport.bin"));
				try {
					LinkedList<SalesData> lista = datos.findUnitsSoldHigh(Integer.parseInt(unitsTextField.getText()));
					if (lista.size() == 0) {
						JOptionPane.showMessageDialog(frmSearchForm, "No se encontraron registros con ese valor");
					}
					for (int i = 0; i < lista.size(); i++) {
						SalesData objeto = lista.get(i);
						String datosList = objeto.getRegion() + ", " + objeto.getCountry() + ", "
								+ objeto.getItem_Type() + ", " + objeto.getSales_Channel() + ", "
								+ objeto.getOrder_Priority() + ", " + objeto.getOrder_Date() + ", "
								+ objeto.getOrder_ID() + ", " + objeto.getShip_Date() + ", " + objeto.getUnits_Sold()
								+ ", " + objeto.getUnit_Price() + ", " + objeto.getUnit_Cost() + ", "
								+ objeto.getTotal_Revenue() + ", " + objeto.getTotal_Cost() + ", "
								+ objeto.getTotal_Profit();
						String[] dataRow = datosList.split(",");
						model.addRow(dataRow);
					}

				} catch (NumberFormatException a) {
					JOptionPane.showMessageDialog(frmSearchForm, "Ingresa un dato numerico valido");
				}
			}
		});
		btnUnitsSoldHigh.setBounds(168, 255, 45, 23);
		frmSearchForm.getContentPane().add(btnUnitsSoldHigh);

		JButton btnUnitsSoldLow = new JButton("<");
		btnUnitsSoldLow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((DefaultTableModel) table.getModel()).setRowCount(0);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				LeerCSV datos = LeerCSV.cargarListaDatos(new File("salesReport.bin"));
				try {
					LinkedList<SalesData> lista = datos.findUnitsSoldLow(Integer.parseInt(unitsTextField.getText()));
					if (lista.size() == 0) {
						JOptionPane.showMessageDialog(frmSearchForm, "No se encontraron registros con ese valor");
					}
					for (int i = 0; i < lista.size(); i++) {
						SalesData objeto = lista.get(i);
						String datosList = objeto.getRegion() + ", " + objeto.getCountry() + ", "
								+ objeto.getItem_Type() + ", " + objeto.getSales_Channel() + ", "
								+ objeto.getOrder_Priority() + ", " + objeto.getOrder_Date() + ", "
								+ objeto.getOrder_ID() + ", " + objeto.getShip_Date() + ", " + objeto.getUnits_Sold()
								+ ", " + objeto.getUnit_Price() + ", " + objeto.getUnit_Cost() + ", "
								+ objeto.getTotal_Revenue() + ", " + objeto.getTotal_Cost() + ", "
								+ objeto.getTotal_Profit();
						String[] dataRow = datosList.split(",");
						model.addRow(dataRow);
					}

				} catch (NumberFormatException a) {
					JOptionPane.showMessageDialog(frmSearchForm, "Ingresa un dato numerico valido");
				}

			}
		});
		btnUnitsSoldLow.setBounds(55, 255, 45, 23);
		frmSearchForm.getContentPane().add(btnUnitsSoldLow);

		JButton btnUnitPriceLow = new JButton("<");
		btnUnitPriceLow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((DefaultTableModel) table.getModel()).setRowCount(0);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				LeerCSV datos = LeerCSV.cargarListaDatos(new File("salesReport.bin"));
				try {
					LinkedList<SalesData> lista = datos
							.findUnitPriceLow(Double.parseDouble(unitPriceTextField.getText()));
					if (lista.size() == 0) {
						JOptionPane.showMessageDialog(frmSearchForm, "No se encontraron registros con ese valor");
					}
					for (int i = 0; i < lista.size(); i++) {
						SalesData objeto = lista.get(i);
						String datosList = objeto.getRegion() + ", " + objeto.getCountry() + ", "
								+ objeto.getItem_Type() + ", " + objeto.getSales_Channel() + ", "
								+ objeto.getOrder_Priority() + ", " + objeto.getOrder_Date() + ", "
								+ objeto.getOrder_ID() + ", " + objeto.getShip_Date() + ", " + objeto.getUnits_Sold()
								+ ", " + objeto.getUnit_Price() + ", " + objeto.getUnit_Cost() + ", "
								+ objeto.getTotal_Revenue() + ", " + objeto.getTotal_Cost() + ", "
								+ objeto.getTotal_Profit();
						String[] dataRow = datosList.split(",");
						model.addRow(dataRow);
					}

				} catch (NumberFormatException a) {
					JOptionPane.showMessageDialog(frmSearchForm, "Ingresa un dato numerico valido");
				}

			}
		});
		btnUnitPriceLow.setBounds(297, 255, 45, 23);
		frmSearchForm.getContentPane().add(btnUnitPriceLow);

		JButton btnUnitPriceHigh = new JButton(">");
		btnUnitPriceHigh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((DefaultTableModel) table.getModel()).setRowCount(0);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				LeerCSV datos = LeerCSV.cargarListaDatos(new File("salesReport.bin"));
				try {
					LinkedList<SalesData> lista = datos
							.findUnitPriceHigh(Double.parseDouble(unitPriceTextField.getText()));
					if (lista.size() == 0) {
						JOptionPane.showMessageDialog(frmSearchForm, "No se encontraron registros con ese valor");
					}
					for (int i = 0; i < lista.size(); i++) {
						SalesData objeto = lista.get(i);
						String datosList = objeto.getRegion() + ", " + objeto.getCountry() + ", "
								+ objeto.getItem_Type() + ", " + objeto.getSales_Channel() + ", "
								+ objeto.getOrder_Priority() + ", " + objeto.getOrder_Date() + ", "
								+ objeto.getOrder_ID() + ", " + objeto.getShip_Date() + ", " + objeto.getUnits_Sold()
								+ ", " + objeto.getUnit_Price() + ", " + objeto.getUnit_Cost() + ", "
								+ objeto.getTotal_Revenue() + ", " + objeto.getTotal_Cost() + ", "
								+ objeto.getTotal_Profit();
						String[] dataRow = datosList.split(",");
						model.addRow(dataRow);
					}

				} catch (NumberFormatException a) {
					JOptionPane.showMessageDialog(frmSearchForm, "Ingresa un dato numerico valido");
				}

			}
		});
		btnUnitPriceHigh.setBounds(405, 255, 45, 23);
		frmSearchForm.getContentPane().add(btnUnitPriceHigh);

		JButton btnUnitCostLow = new JButton("<");
		btnUnitCostLow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((DefaultTableModel) table.getModel()).setRowCount(0);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				LeerCSV datos = LeerCSV.cargarListaDatos(new File("salesReport.bin"));
				try {
					LinkedList<SalesData> lista = datos
							.findUnitCostLow(Double.parseDouble(unitCostTextField.getText()));
					if (lista.size() == 0) {
						JOptionPane.showMessageDialog(frmSearchForm, "No se encontraron registros con ese valor");
					}
					for (int i = 0; i < lista.size(); i++) {
						SalesData objeto = lista.get(i);
						String datosList = objeto.getRegion() + ", " + objeto.getCountry() + ", "
								+ objeto.getItem_Type() + ", " + objeto.getSales_Channel() + ", "
								+ objeto.getOrder_Priority() + ", " + objeto.getOrder_Date() + ", "
								+ objeto.getOrder_ID() + ", " + objeto.getShip_Date() + ", " + objeto.getUnits_Sold()
								+ ", " + objeto.getUnit_Price() + ", " + objeto.getUnit_Cost() + ", "
								+ objeto.getTotal_Revenue() + ", " + objeto.getTotal_Cost() + ", "
								+ objeto.getTotal_Profit();
						String[] dataRow = datosList.split(",");
						model.addRow(dataRow);
					}

				} catch (NumberFormatException a) {
					JOptionPane.showMessageDialog(frmSearchForm, "Ingresa un dato numerico valido");
				}

			}
		});
		btnUnitCostLow.setBounds(520, 255, 45, 23);
		frmSearchForm.getContentPane().add(btnUnitCostLow);

		JButton btnUnitCostHigh = new JButton(">");
		btnUnitCostHigh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((DefaultTableModel) table.getModel()).setRowCount(0);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				LeerCSV datos = LeerCSV.cargarListaDatos(new File("salesReport.bin"));
				try {
					LinkedList<SalesData> lista = datos
							.findUnitCostHigh(Double.parseDouble(unitCostTextField.getText()));
					if (lista.size() == 0) {
						JOptionPane.showMessageDialog(frmSearchForm, "No se encontraron registros con ese valor");
					}
					for (int i = 0; i < lista.size(); i++) {
						SalesData objeto = lista.get(i);
						String datosList = objeto.getRegion() + ", " + objeto.getCountry() + ", "
								+ objeto.getItem_Type() + ", " + objeto.getSales_Channel() + ", "
								+ objeto.getOrder_Priority() + ", " + objeto.getOrder_Date() + ", "
								+ objeto.getOrder_ID() + ", " + objeto.getShip_Date() + ", " + objeto.getUnits_Sold()
								+ ", " + objeto.getUnit_Price() + ", " + objeto.getUnit_Cost() + ", "
								+ objeto.getTotal_Revenue() + ", " + objeto.getTotal_Cost() + ", "
								+ objeto.getTotal_Profit();
						String[] dataRow = datosList.split(",");
						model.addRow(dataRow);
					}

				} catch (NumberFormatException a) {
					JOptionPane.showMessageDialog(frmSearchForm, "Ingresa un dato numerico valido");
				}

			}
		});
		btnUnitCostHigh.setBounds(634, 255, 45, 23);
		frmSearchForm.getContentPane().add(btnUnitCostHigh);

		JButton btnTotalRevenueLow = new JButton("<");
		btnTotalRevenueLow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((DefaultTableModel) table.getModel()).setRowCount(0);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				LeerCSV datos = LeerCSV.cargarListaDatos(new File("salesReport.bin"));
				try {
					LinkedList<SalesData> lista = datos
							.findTotalRevenueLow(Double.parseDouble(revenueTextField.getText()));
					if (lista.size() == 0) {
						JOptionPane.showMessageDialog(frmSearchForm, "No se encontraron registros con ese valor");
					}
					for (int i = 0; i < lista.size(); i++) {
						SalesData objeto = lista.get(i);
						String datosList = objeto.getRegion() + ", " + objeto.getCountry() + ", "
								+ objeto.getItem_Type() + ", " + objeto.getSales_Channel() + ", "
								+ objeto.getOrder_Priority() + ", " + objeto.getOrder_Date() + ", "
								+ objeto.getOrder_ID() + ", " + objeto.getShip_Date() + ", " + objeto.getUnits_Sold()
								+ ", " + objeto.getUnit_Price() + ", " + objeto.getUnit_Cost() + ", "
								+ objeto.getTotal_Revenue() + ", " + objeto.getTotal_Cost() + ", "
								+ objeto.getTotal_Profit();
						String[] dataRow = datosList.split(",");
						model.addRow(dataRow);
					}

				} catch (NumberFormatException a) {
					JOptionPane.showMessageDialog(frmSearchForm, "Ingresa un dato numerico valido");
				}

			}
		});
		btnTotalRevenueLow.setBounds(730, 255, 45, 23);
		frmSearchForm.getContentPane().add(btnTotalRevenueLow);

		JButton btnTotalRevenueHigh = new JButton(">");
		btnTotalRevenueHigh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((DefaultTableModel) table.getModel()).setRowCount(0);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				LeerCSV datos = LeerCSV.cargarListaDatos(new File("salesReport.bin"));
				try {
					LinkedList<SalesData> lista = datos
							.findTotalRevenueHigh(Double.parseDouble(revenueTextField.getText()));
					if (lista.size() == 0) {
						JOptionPane.showMessageDialog(frmSearchForm, "No se encontraron registros con ese valor");
					}
					for (int i = 0; i < lista.size(); i++) {
						SalesData objeto = lista.get(i);
						String datosList = objeto.getRegion() + ", " + objeto.getCountry() + ", "
								+ objeto.getItem_Type() + ", " + objeto.getSales_Channel() + ", "
								+ objeto.getOrder_Priority() + ", " + objeto.getOrder_Date() + ", "
								+ objeto.getOrder_ID() + ", " + objeto.getShip_Date() + ", " + objeto.getUnits_Sold()
								+ ", " + objeto.getUnit_Price() + ", " + objeto.getUnit_Cost() + ", "
								+ objeto.getTotal_Revenue() + ", " + objeto.getTotal_Cost() + ", "
								+ objeto.getTotal_Profit();
						String[] dataRow = datosList.split(",");
						model.addRow(dataRow);
					}

				} catch (NumberFormatException a) {
					JOptionPane.showMessageDialog(frmSearchForm, "Ingresa un dato numerico valido");
				}

			}
		});
		btnTotalRevenueHigh.setBounds(839, 255, 45, 23);
		frmSearchForm.getContentPane().add(btnTotalRevenueHigh);

		JButton btnTotalCostLow = new JButton("<");
		btnTotalCostLow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((DefaultTableModel) table.getModel()).setRowCount(0);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				LeerCSV datos = LeerCSV.cargarListaDatos(new File("salesReport.bin"));
				try {
					LinkedList<SalesData> lista = datos.findTotalCostLow(Double.parseDouble(costTextField.getText()));
					if (lista.size() == 0) {
						JOptionPane.showMessageDialog(frmSearchForm, "No se encontraron registros con ese valor");
					}
					for (int i = 0; i < lista.size(); i++) {
						SalesData objeto = lista.get(i);
						String datosList = objeto.getRegion() + ", " + objeto.getCountry() + ", "
								+ objeto.getItem_Type() + ", " + objeto.getSales_Channel() + ", "
								+ objeto.getOrder_Priority() + ", " + objeto.getOrder_Date() + ", "
								+ objeto.getOrder_ID() + ", " + objeto.getShip_Date() + ", " + objeto.getUnits_Sold()
								+ ", " + objeto.getUnit_Price() + ", " + objeto.getUnit_Cost() + ", "
								+ objeto.getTotal_Revenue() + ", " + objeto.getTotal_Cost() + ", "
								+ objeto.getTotal_Profit();
						String[] dataRow = datosList.split(",");
						model.addRow(dataRow);
					}

				} catch (NumberFormatException a) {
					JOptionPane.showMessageDialog(frmSearchForm, "Ingresa un dato numerico valido");
				}

			}
		});
		btnTotalCostLow.setBounds(30, 339, 45, 23);
		frmSearchForm.getContentPane().add(btnTotalCostLow);

		JButton btnTotalCostHIgh = new JButton(">");
		btnTotalCostHIgh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((DefaultTableModel) table.getModel()).setRowCount(0);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				LeerCSV datos = LeerCSV.cargarListaDatos(new File("salesReport.bin"));
				try {
					LinkedList<SalesData> lista = datos.findTotalCostHigh(Double.parseDouble(costTextField.getText()));
					if (lista.size() == 0) {
						JOptionPane.showMessageDialog(frmSearchForm, "No se encontraron registros con ese valor");
					}
					for (int i = 0; i < lista.size(); i++) {
						SalesData objeto = lista.get(i);
						String datosList = objeto.getRegion() + ", " + objeto.getCountry() + ", "
								+ objeto.getItem_Type() + ", " + objeto.getSales_Channel() + ", "
								+ objeto.getOrder_Priority() + ", " + objeto.getOrder_Date() + ", "
								+ objeto.getOrder_ID() + ", " + objeto.getShip_Date() + ", " + objeto.getUnits_Sold()
								+ ", " + objeto.getUnit_Price() + ", " + objeto.getUnit_Cost() + ", "
								+ objeto.getTotal_Revenue() + ", " + objeto.getTotal_Cost() + ", "
								+ objeto.getTotal_Profit();
						String[] dataRow = datosList.split(",");
						model.addRow(dataRow);
					}

				} catch (NumberFormatException a) {
					JOptionPane.showMessageDialog(frmSearchForm, "Ingresa un dato numerico valido");
				}

			}
		});
		btnTotalCostHIgh.setBounds(141, 339, 45, 23);
		frmSearchForm.getContentPane().add(btnTotalCostHIgh);

		JButton btnTotalProfitLow = new JButton("<");
		btnTotalProfitLow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((DefaultTableModel) table.getModel()).setRowCount(0);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				LeerCSV datos = LeerCSV.cargarListaDatos(new File("salesReport.bin"));
				try {
					LinkedList<SalesData> lista = datos
							.findTotalProfitLow(Double.parseDouble(profitTextField.getText()));
					if (lista.size() == 0) {
						JOptionPane.showMessageDialog(frmSearchForm, "No se encontraron registros con ese valor");
					}
					for (int i = 0; i < lista.size(); i++) {
						SalesData objeto = lista.get(i);
						String datosList = objeto.getRegion() + ", " + objeto.getCountry() + ", "
								+ objeto.getItem_Type() + ", " + objeto.getSales_Channel() + ", "
								+ objeto.getOrder_Priority() + ", " + objeto.getOrder_Date() + ", "
								+ objeto.getOrder_ID() + ", " + objeto.getShip_Date() + ", " + objeto.getUnits_Sold()
								+ ", " + objeto.getUnit_Price() + ", " + objeto.getUnit_Cost() + ", "
								+ objeto.getTotal_Revenue() + ", " + objeto.getTotal_Cost() + ", "
								+ objeto.getTotal_Profit();
						String[] dataRow = datosList.split(",");
						model.addRow(dataRow);
					}

				} catch (NumberFormatException a) {
					JOptionPane.showMessageDialog(frmSearchForm, "Ingresa un dato numerico valido");
				}

			}
		});
		btnTotalProfitLow.setBounds(287, 337, 45, 23);
		frmSearchForm.getContentPane().add(btnTotalProfitLow);

		JButton btnTotalProfitHigh = new JButton(">");
		btnTotalProfitHigh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((DefaultTableModel) table.getModel()).setRowCount(0);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				LeerCSV datos = LeerCSV.cargarListaDatos(new File("salesReport.bin"));
				try {
					LinkedList<SalesData> lista = datos
							.findTotalProfitHigh(Double.parseDouble(profitTextField.getText()));
					if (lista.size() == 0) {
						JOptionPane.showMessageDialog(frmSearchForm, "No se encontraron registros con ese valor");
					}
					for (int i = 0; i < lista.size(); i++) {
						SalesData objeto = lista.get(i);
						String datosList = objeto.getRegion() + ", " + objeto.getCountry() + ", "
								+ objeto.getItem_Type() + ", " + objeto.getSales_Channel() + ", "
								+ objeto.getOrder_Priority() + ", " + objeto.getOrder_Date() + ", "
								+ objeto.getOrder_ID() + ", " + objeto.getShip_Date() + ", " + objeto.getUnits_Sold()
								+ ", " + objeto.getUnit_Price() + ", " + objeto.getUnit_Cost() + ", "
								+ objeto.getTotal_Revenue() + ", " + objeto.getTotal_Cost() + ", "
								+ objeto.getTotal_Profit();
						String[] dataRow = datosList.split(",");
						model.addRow(dataRow);
					}

				} catch (NumberFormatException a) {
					JOptionPane.showMessageDialog(frmSearchForm, "Ingresa un dato numerico valido");
				}

			}
		});
		btnTotalProfitHigh.setBounds(396, 337, 45, 23);
		frmSearchForm.getContentPane().add(btnTotalProfitHigh);

		///////////////////////////// ****************************************

		JDateChooser dateChooserOrderDate = new JDateChooser();
		dateChooserOrderDate.setBounds(357, 132, 122, 28);
		frmSearchForm.getContentPane().add(dateChooserOrderDate);
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");

		JButton btnOrderDate = new JButton("Search");
		btnOrderDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((DefaultTableModel) table.getModel()).setRowCount(0);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				LeerCSV datos = LeerCSV.cargarListaDatos(new File("salesReport.bin"));
				try {
					LinkedList<SalesData> lista = datos
							.findOrderDate(dateFormat.format(dateChooserOrderDate.getDate()));
					if (lista.size() == 0) {
						JOptionPane.showMessageDialog(frmSearchForm, "No se encontraron registros con ese valor");
					}
					for (int i = 0; i < lista.size(); i++) {
						SalesData objeto = lista.get(i);
						String datosList = objeto.getRegion() + ", " + objeto.getCountry() + ", "
								+ objeto.getItem_Type() + ", " + objeto.getSales_Channel() + ", "
								+ objeto.getOrder_Priority() + ", " + objeto.getOrder_Date() + ", "
								+ objeto.getOrder_ID() + ", " + objeto.getShip_Date() + ", " + objeto.getUnits_Sold()
								+ ", " + objeto.getUnit_Price() + ", " + objeto.getUnit_Cost() + ", "
								+ objeto.getTotal_Revenue() + ", " + objeto.getTotal_Cost() + ", "
								+ objeto.getTotal_Profit();
						String[] dataRow = datosList.split(",");
						model.addRow(dataRow);
					}

					String date = dateFormat.format(dateChooserOrderDate.getDate());
					System.out.println(date);
				} catch (NullPointerException e2) {
					JOptionPane.showMessageDialog(frmSearchForm, "Ingresa una fecha valida");
				}

			}
		});
		btnOrderDate.setBounds(289, 172, 89, 23);
		frmSearchForm.getContentPane().add(btnOrderDate);

		/////////////////////////////////////// ********************************************************

		JDateChooser dateChooserShipDate = new JDateChooser();
		dateChooserShipDate.setBounds(785, 132, 116, 28);
		frmSearchForm.getContentPane().add(dateChooserShipDate);

		JButton btnShipDate = new JButton("Search");
		btnShipDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((DefaultTableModel) table.getModel()).setRowCount(0);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				LeerCSV datos = LeerCSV.cargarListaDatos(new File("salesReport.bin"));
				try {
					LinkedList<SalesData> lista = datos.findShipDate(dateFormat.format(dateChooserShipDate.getDate()));
					if (lista.size() == 0) {
						JOptionPane.showMessageDialog(frmSearchForm, "No se encontraron registros con ese valor");
					}
					for (int i = 0; i < lista.size(); i++) {
						SalesData objeto = lista.get(i);
						String datosList = objeto.getRegion() + ", " + objeto.getCountry() + ", "
								+ objeto.getItem_Type() + ", " + objeto.getSales_Channel() + ", "
								+ objeto.getOrder_Priority() + ", " + objeto.getOrder_Date() + ", "
								+ objeto.getOrder_ID() + ", " + objeto.getShip_Date() + ", " + objeto.getUnits_Sold()
								+ ", " + objeto.getUnit_Price() + ", " + objeto.getUnit_Cost() + ", "
								+ objeto.getTotal_Revenue() + ", " + objeto.getTotal_Cost() + ", "
								+ objeto.getTotal_Profit();
						String[] dataRow = datosList.split(",");
						model.addRow(dataRow);
					}

					String date = dateFormat.format(dateChooserShipDate.getDate());
					System.out.println(date);
					System.out.println("PRUEBA");
				} catch (NullPointerException e2) {
					JOptionPane.showMessageDialog(frmSearchForm, "Ingresa una fecha valida 23");
				}

			}
		});
		btnShipDate.setBounds(720, 171, 89, 23);
		frmSearchForm.getContentPane().add(btnShipDate);

	}
}
