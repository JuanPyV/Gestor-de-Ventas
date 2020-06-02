// Abigail Guadarrama Victoria A01635153
// Juan Pablo Velazco Velasquez A00368753

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class LeerCSV {

	private MyHashTable<String, SalesData> lista;
	private int size;

	public LeerCSV() {
		this.lista = new MyHashTable<String, SalesData>();
		this.size = 0;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public MyHashTable<String, SalesData> getLista() {
		return lista;
	}

	public void lecturaDatos() {
		int j;
		FileOutputStream fs;
		ObjectOutputStream os;
		try {
			fs = new FileOutputStream("salesReport.bin");
			os = new ObjectOutputStream(fs);
			for (int i = 0; i < this.lista.getTabla().length; i++) {
				j = 0;
				if (this.lista.getTabla()[i].size() > 0) {
					for (int l = 0; l < this.lista.getTabla()[i].size(); l++) {
						SalesData datitos = this.lista.getTabla()[i].get(j).valor;
						j++;
						os.writeObject(datitos);
					}
				}
			}
			os.close();
			fs.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void insertarDatos(File datos) {
		try {
			Scanner inputStream = new Scanner(datos);
			String data = inputStream.next();
			while (inputStream.hasNext()) {
				data = inputStream.next();
				String[] values = data.split(",");
				SalesData objeto = new SalesData(values[0], values[1], values[2], values[3], values[4], values[5],
						values[6], values[7], Integer.parseInt(values[8]), Double.parseDouble(values[9]),
						Double.parseDouble(values[10]), Double.parseDouble(values[11]), Double.parseDouble(values[12]),
						Double.parseDouble(values[13]));
				this.lista.put(objeto.getOrder_ID(), objeto);
			}

			this.size = this.lista.getSize();
			inputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public SalesData encontrar(String Order_ID) {
		return this.lista.get(Order_ID);
	}
//////////////////// METODOS PARA BUSCAR //////////////////////////////////

	public LinkedList<SalesData> findRegion(String region) {
		LinkedList<SalesData> arreglo = new LinkedList<SalesData>();
		for (int i = 0; i < this.lista.getTabla().length; i++) {
			if (this.lista.getTabla()[i].size() > 0) {
				for (int j = 0; j < this.lista.getTabla()[i].size(); j++) {
					if (this.lista.getTabla()[i].get(j).valor.getRegion().equals(region)) {
						arreglo.addLast(this.lista.getTabla()[i].get(j).valor);
					}
				}
			}
		}
		return arreglo;
	}

	public LinkedList<SalesData> findCountry(String country) {
		LinkedList<SalesData> arreglo = new LinkedList<SalesData>();
		for (int i = 0; i < this.lista.getTabla().length; i++) {
			if (this.lista.getTabla()[i].size() > 0) {
				for (int j = 0; j < this.lista.getTabla()[i].size(); j++) {
					if (this.lista.getTabla()[i].get(j).valor.getCountry().equals(country)) {
						arreglo.addLast(this.lista.getTabla()[i].get(j).valor);
					}
				}
			}
		}
		return arreglo;
	}

	public LinkedList<SalesData> findItem(String item) {
		LinkedList<SalesData> arreglo = new LinkedList<SalesData>();
		for (int i = 0; i < this.lista.getTabla().length; i++) {
			if (this.lista.getTabla()[i].size() > 0) {
				for (int j = 0; j < this.lista.getTabla()[i].size(); j++) {
					if (this.lista.getTabla()[i].get(j).valor.getItem_Type().equals(item)) {
						arreglo.addLast(this.lista.getTabla()[i].get(j).valor);
					}
				}
			}
		}
		return arreglo;
	}

	public LinkedList<SalesData> findSalesCh(String salesCh) {
		LinkedList<SalesData> arreglo = new LinkedList<SalesData>();
		for (int i = 0; i < this.lista.getTabla().length; i++) {
			if (this.lista.getTabla()[i].size() > 0) {
				for (int j = 0; j < this.lista.getTabla()[i].size(); j++) {
					if (this.lista.getTabla()[i].get(j).valor.getSales_Channel().equals(salesCh)) {
						arreglo.addLast(this.lista.getTabla()[i].get(j).valor);
					}
				}
			}
		}
		return arreglo;
	}

	public LinkedList<SalesData> findOrderPrio(String orderPrio) {
		LinkedList<SalesData> arreglo = new LinkedList<SalesData>();
		for (int i = 0; i < this.lista.getTabla().length; i++) {
			if (this.lista.getTabla()[i].size() > 0) {
				for (int j = 0; j < this.lista.getTabla()[i].size(); j++) {
					if (this.lista.getTabla()[i].get(j).valor.getOrder_Priority().equals(orderPrio)) {
						arreglo.addLast(this.lista.getTabla()[i].get(j).valor);
					}
				}
			}
		}
		return arreglo;
	}

	public LinkedList<SalesData> findUnitsSoldEqual(int unitsS) {
		LinkedList<SalesData> arreglo = new LinkedList<SalesData>();
		for (int i = 0; i < this.lista.getTabla().length; i++) {
			if (this.lista.getTabla()[i].size() > 0) {
				for (int j = 0; j < this.lista.getTabla()[i].size(); j++) {
					if (unitsS == this.lista.getTabla()[i].get(j).valor.getUnits_Sold()) {
						arreglo.addLast(this.lista.getTabla()[i].get(j).valor);
					}
				}
			}
		}
		return arreglo;
	}

	public LinkedList<SalesData> findUnitsSoldLow(int unitsS) {
		LinkedList<SalesData> arreglo = new LinkedList<SalesData>();
		for (int i = 0; i < this.lista.getTabla().length; i++) {
			if (this.lista.getTabla()[i].size() > 0) {
				for (int j = 0; j < this.lista.getTabla()[i].size(); j++) {
					if (unitsS > this.lista.getTabla()[i].get(j).valor.getUnits_Sold()) {
						arreglo.addLast(this.lista.getTabla()[i].get(j).valor);
					}
				}
			}
		}
		return arreglo;
	}

	public LinkedList<SalesData> findUnitsSoldHigh(int unitsS) {
		LinkedList<SalesData> arreglo = new LinkedList<SalesData>();
		for (int i = 0; i < this.lista.getTabla().length; i++) {
			if (this.lista.getTabla()[i].size() > 0) {
				for (int j = 0; j < this.lista.getTabla()[i].size(); j++) {
					if (unitsS < this.lista.getTabla()[i].get(j).valor.getUnits_Sold()) {
						arreglo.addLast(this.lista.getTabla()[i].get(j).valor);
					}
				}
			}
		}
		return arreglo;
	}

	public LinkedList<SalesData> findUnitPriceEqual(double unitsP) {
		LinkedList<SalesData> arreglo = new LinkedList<SalesData>();
		for (int i = 0; i < this.lista.getTabla().length; i++) {
			if (this.lista.getTabla()[i].size() > 0) {
				for (int j = 0; j < this.lista.getTabla()[i].size(); j++) {
					if (unitsP == this.lista.getTabla()[i].get(j).valor.getUnit_Price()) {
						arreglo.addLast(this.lista.getTabla()[i].get(j).valor);
					}
				}
			}
		}
		return arreglo;
	}

	public LinkedList<SalesData> findUnitPriceLow(double unitsP) {
		LinkedList<SalesData> arreglo = new LinkedList<SalesData>();
		for (int i = 0; i < this.lista.getTabla().length; i++) {
			if (this.lista.getTabla()[i].size() > 0) {
				for (int j = 0; j < this.lista.getTabla()[i].size(); j++) {
					if (unitsP > this.lista.getTabla()[i].get(j).valor.getUnit_Price()) {
						arreglo.addLast(this.lista.getTabla()[i].get(j).valor);
					}
				}
			}
		}
		return arreglo;
	}

	public LinkedList<SalesData> findUnitPriceHigh(double unitsP) {
		LinkedList<SalesData> arreglo = new LinkedList<SalesData>();
		for (int i = 0; i < this.lista.getTabla().length; i++) {
			if (this.lista.getTabla()[i].size() > 0) {
				for (int j = 0; j < this.lista.getTabla()[i].size(); j++) {
					if (unitsP < this.lista.getTabla()[i].get(j).valor.getUnit_Price()) {
						arreglo.addLast(this.lista.getTabla()[i].get(j).valor);
					}
				}
			}
		}
		return arreglo;
	}

	public LinkedList<SalesData> findUnitCostEqual(double unitsC) {
		LinkedList<SalesData> arreglo = new LinkedList<SalesData>();
		for (int i = 0; i < this.lista.getTabla().length; i++) {
			if (this.lista.getTabla()[i].size() > 0) {
				for (int j = 0; j < this.lista.getTabla()[i].size(); j++) {
					if (unitsC == this.lista.getTabla()[i].get(j).valor.getUnit_Cost()) {
						arreglo.addLast(this.lista.getTabla()[i].get(j).valor);
					}
				}
			}
		}
		return arreglo;
	}

	public LinkedList<SalesData> findUnitCostLow(double unitsC) {
		LinkedList<SalesData> arreglo = new LinkedList<SalesData>();
		for (int i = 0; i < this.lista.getTabla().length; i++) {
			if (this.lista.getTabla()[i].size() > 0) {
				for (int j = 0; j < this.lista.getTabla()[i].size(); j++) {
					if (unitsC > this.lista.getTabla()[i].get(j).valor.getUnit_Cost()) {
						arreglo.addLast(this.lista.getTabla()[i].get(j).valor);
					}
				}
			}
		}
		return arreglo;
	}

	public LinkedList<SalesData> findUnitCostHigh(double unitsC) {
		LinkedList<SalesData> arreglo = new LinkedList<SalesData>();
		for (int i = 0; i < this.lista.getTabla().length; i++) {
			if (this.lista.getTabla()[i].size() > 0) {
				for (int j = 0; j < this.lista.getTabla()[i].size(); j++) {
					if (unitsC < this.lista.getTabla()[i].get(j).valor.getUnit_Cost()) {
						arreglo.addLast(this.lista.getTabla()[i].get(j).valor);
					}
				}
			}
		}
		return arreglo;
	}

	public LinkedList<SalesData> findTotalRevenueEqual(double totalR) {
		LinkedList<SalesData> arreglo = new LinkedList<SalesData>();
		for (int i = 0; i < this.lista.getTabla().length; i++) {
			if (this.lista.getTabla()[i].size() > 0) {
				for (int j = 0; j < this.lista.getTabla()[i].size(); j++) {
					if (totalR == this.lista.getTabla()[i].get(j).valor.getTotal_Revenue()) {
						arreglo.addLast(this.lista.getTabla()[i].get(j).valor);
					}
				}
			}
		}
		return arreglo;
	}

	public LinkedList<SalesData> findTotalRevenueLow(double totalR) {
		LinkedList<SalesData> arreglo = new LinkedList<SalesData>();
		for (int i = 0; i < this.lista.getTabla().length; i++) {
			if (this.lista.getTabla()[i].size() > 0) {
				for (int j = 0; j < this.lista.getTabla()[i].size(); j++) {
					if (totalR > this.lista.getTabla()[i].get(j).valor.getTotal_Revenue()) {
						arreglo.addLast(this.lista.getTabla()[i].get(j).valor);
					}
				}
			}
		}
		return arreglo;
	}

	public LinkedList<SalesData> findTotalRevenueHigh(double totalR) {
		LinkedList<SalesData> arreglo = new LinkedList<SalesData>();
		for (int i = 0; i < this.lista.getTabla().length; i++) {
			if (this.lista.getTabla()[i].size() > 0) {
				for (int j = 0; j < this.lista.getTabla()[i].size(); j++) {
					if (totalR < this.lista.getTabla()[i].get(j).valor.getTotal_Revenue()) {
						arreglo.addLast(this.lista.getTabla()[i].get(j).valor);
					}
				}
			}
		}
		return arreglo;
	}

	public LinkedList<SalesData> findTotalCostEqual(double totalC) {
		LinkedList<SalesData> arreglo = new LinkedList<SalesData>();
		for (int i = 0; i < this.lista.getTabla().length; i++) {
			if (this.lista.getTabla()[i].size() > 0) {
				for (int j = 0; j < this.lista.getTabla()[i].size(); j++) {
					if (totalC == this.lista.getTabla()[i].get(j).valor.getTotal_Cost()) {
						arreglo.addLast(this.lista.getTabla()[i].get(j).valor);
					}
				}
			}
		}
		return arreglo;
	}

	public LinkedList<SalesData> findTotalCostLow(double totalC) {
		LinkedList<SalesData> arreglo = new LinkedList<SalesData>();
		for (int i = 0; i < this.lista.getTabla().length; i++) {
			if (this.lista.getTabla()[i].size() > 0) {
				for (int j = 0; j < this.lista.getTabla()[i].size(); j++) {
					if (totalC > this.lista.getTabla()[i].get(j).valor.getTotal_Cost()) {
						arreglo.addLast(this.lista.getTabla()[i].get(j).valor);
					}
				}
			}
		}
		return arreglo;
	}

	public LinkedList<SalesData> findTotalCostHigh(double totalC) {
		LinkedList<SalesData> arreglo = new LinkedList<SalesData>();
		for (int i = 0; i < this.lista.getTabla().length; i++) {
			if (this.lista.getTabla()[i].size() > 0) {
				for (int j = 0; j < this.lista.getTabla()[i].size(); j++) {
					if (totalC < this.lista.getTabla()[i].get(j).valor.getTotal_Cost()) {
						arreglo.addLast(this.lista.getTabla()[i].get(j).valor);
					}
				}
			}
		}
		return arreglo;
	}

	public LinkedList<SalesData> findTotalProfitEqual(double totalP) {
		LinkedList<SalesData> arreglo = new LinkedList<SalesData>();
		for (int i = 0; i < this.lista.getTabla().length; i++) {
			if (this.lista.getTabla()[i].size() > 0) {
				for (int j = 0; j < this.lista.getTabla()[i].size(); j++) {
					if (totalP == this.lista.getTabla()[i].get(j).valor.getTotal_Profit()) {
						arreglo.addLast(this.lista.getTabla()[i].get(j).valor);
					}
				}
			}
		}
		return arreglo;
	}

	public LinkedList<SalesData> findTotalProfitLow(double totalP) {
		LinkedList<SalesData> arreglo = new LinkedList<SalesData>();
		for (int i = 0; i < this.lista.getTabla().length; i++) {
			if (this.lista.getTabla()[i].size() > 0) {
				for (int j = 0; j < this.lista.getTabla()[i].size(); j++) {
					if (totalP > this.lista.getTabla()[i].get(j).valor.getTotal_Profit()) {
						arreglo.addLast(this.lista.getTabla()[i].get(j).valor);
					}
				}
			}
		}
		return arreglo;
	}

	public LinkedList<SalesData> findTotalProfitHigh(double totalP) {
		LinkedList<SalesData> arreglo = new LinkedList<SalesData>();
		for (int i = 0; i < this.lista.getTabla().length; i++) {
			if (this.lista.getTabla()[i].size() > 0) {
				for (int j = 0; j < this.lista.getTabla()[i].size(); j++) {
					if (totalP < this.lista.getTabla()[i].get(j).valor.getTotal_Profit()) {
						arreglo.addLast(this.lista.getTabla()[i].get(j).valor);
					}
				}
			}
		}
		return arreglo;
	}

	public LinkedList<SalesData> findOrderDate(String dateOD) {
		LinkedList<SalesData> arreglo = new LinkedList<SalesData>();
		for (int i = 0; i < this.lista.getTabla().length; i++) {
			if (this.lista.getTabla()[i].size() > 0) {
				for (int j = 0; j < this.lista.getTabla()[i].size(); j++) {
					if (this.lista.getTabla()[i].get(j).valor.getOrder_Date().equals(dateOD)) {
						arreglo.addLast(this.lista.getTabla()[i].get(j).valor);
					}
				}
			}
		}
		return arreglo;
	}

	public LinkedList<SalesData> findShipDate(String dateSD) {
		LinkedList<SalesData> arreglo = new LinkedList<SalesData>();
		for (int i = 0; i < this.lista.getTabla().length; i++) {
			if (this.lista.getTabla()[i].size() > 0) {
				for (int j = 0; j < this.lista.getTabla()[i].size(); j++) {
					if (this.lista.getTabla()[i].get(j).valor.getShip_Date().equals(dateSD)) {
						arreglo.addLast(this.lista.getTabla()[i].get(j).valor);
					}
				}
			}
		}
		return arreglo;
	}

///////////////////////////////////////////////////////

	public LinkedList<SalesData> mostrarDatos() {
		LinkedList<SalesData> arreglo = new LinkedList<SalesData>();
		for (int i = 0; i < this.lista.getTabla().length; i++) {
			if (this.lista.getTabla()[i].size() > 0) {
				for (int j = 0; j < this.lista.getTabla()[i].size(); j++) {
					arreglo.addLast(this.lista.getTabla()[i].get(j).valor);

				}
			}
		}
		return arreglo;
	}

	//// metodo llamado por cargarListaDatos para llenar la hashtable
	//// usamos el metodo put de la hashtable para meter los datos

	public void meterATabla(SalesData dato) {
		this.size++;
		this.lista.put(dato.getOrder_ID(), dato);
	}

	/* encontrar referencia mas alta +1 */
	public String refMasAlta() {
		int numerin = 0;
		for (int i = 0; i < this.lista.getTabla().length; i++) {
			if (this.lista.getTabla()[i].size() > 0) {
				for (int j = 0; j < this.lista.getTabla()[i].size(); j++) {
					int ref = Integer.parseInt(this.lista.getTabla()[i].get(j).valor.getOrder_ID());
					if (ref > numerin) {
						numerin = ref;
					}
				}
			}
		}
		numerin++;
		return "" + numerin;
	}

	public SalesData[] datosEnArreglo() {
		SalesData[] arreglo = new SalesData[this.size];
		int pos = 0;
		for (int i = 0; i < this.lista.getTabla().length; i++) {
			if (this.lista.getTabla()[i].size() > 0) {
				for (int j = 0; j < this.lista.getTabla()[i].size(); j++) {
					arreglo[pos] = this.lista.getTabla()[i].get(j).valor;
					pos++;
				}
			}
		}
		return arreglo;
	}

	///// Es llamada por ConsultWindow para poder almacenar los datos en una
	///// hashtable

	//// Se manda a llamar el metodo de meterATabla para poder meter los objetos
	//// leidos del archivo a una hashtable

	public static LeerCSV cargarListaDatos(File datos) {
		try {
			FileInputStream fs = new FileInputStream(datos);
			ObjectInputStream os = new ObjectInputStream(fs);
			LeerCSV sales = new LeerCSV();
			while (fs.available() > 0) {
				Object objeto = os.readObject();
				SalesData salesData = (SalesData) objeto;
				sales.meterATabla(salesData);
			}
			os.close();
			return sales;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) throws IOException {

		LeerCSV lista = new LeerCSV();
		lista.insertarDatos(new File("src/Sales_Records.csv"));
		lista.lecturaDatos();

		LinkedList<SalesData> lista2 = lista.mostrarDatos();

		for (int i = 0; i < lista2.size(); i++) {
			SalesData objeto = lista2.get(i);
			String datos = objeto.getRegion() + ", " + objeto.getCountry() + ", " + objeto.getItem_Type() + ", "
					+ objeto.getSales_Channel() + ", " + objeto.getOrder_Priority() + ", " + objeto.getOrder_Date()
					+ ", " + objeto.getOrder_ID() + ", " + objeto.getShip_Date() + ", " + objeto.getUnits_Sold() + ", "
					+ objeto.getUnit_Price() + ", " + objeto.getUnit_Cost() + ", " + objeto.getTotal_Revenue() + ", "
					+ objeto.getTotal_Cost() + ", " + objeto.getTotal_Profit();
			System.out.println(i + ", " + datos);
		}

		// System.out.println(lista.refMasAlta());

	}

}
