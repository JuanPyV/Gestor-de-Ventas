// Abigail Guadarrama Victoria A01635153
// Juan Pablo Velazco Velasquez A00368753

import java.io.Serializable;

public class SalesData implements Serializable {

	private static final long serialVersionUID = -155210258862180868L;
	private String Region, Country, Item_Type, Sales_Channel, Order_Priority, Order_Date, Order_ID, Ship_Date;
	private int Units_Sold;
	private Double Unit_Price, Unit_Cost, Total_Revenue, Total_Cost, Total_Profit;

	public SalesData(String Region, String Country, String Item_Type, String Sales_Channel, String Order_Priority,
			String Order_Date, String Order_ID, String Ship_Date, int Units_Sold, Double Unit_Price, Double Unit_Cost,
			Double Total_Revenue, Double Total_Cost, Double Total_Profit) {
		super();
		this.Region = Region;
		this.Country = Country;
		this.Item_Type = Item_Type;
		this.Sales_Channel = Sales_Channel;
		this.Order_Priority = Order_Priority;
		this.Order_Date = Order_Date;
		this.Order_ID = Order_ID;
		this.Ship_Date = Ship_Date;
		this.Units_Sold = Units_Sold;
		this.Unit_Price = Unit_Price;
		this.Unit_Cost = Unit_Cost;
		this.Total_Revenue = Total_Revenue;
		this.Total_Cost = Total_Cost;
		this.Total_Profit = Total_Profit;
	}

	public String getRegion() {
		return Region;
	}

	public String getCountry() {
		return Country;
	}

	public String getItem_Type() {
		return Item_Type;
	}

	public String getSales_Channel() {
		return Sales_Channel;
	}

	public String getOrder_Priority() {
		return Order_Priority;
	}

	public String getOrder_Date() {
		return Order_Date;
	}

	public String getOrder_ID() {
		return Order_ID;
	}

	public String getShip_Date() {
		return Ship_Date;
	}

	public int getUnits_Sold() {
		return Units_Sold;
	}

	public Double getUnit_Price() {
		return Unit_Price;
	}

	public Double getUnit_Cost() {
		return Unit_Cost;
	}

	public Double getTotal_Revenue() {
		return Total_Revenue;
	}

	public Double getTotal_Cost() {
		return Total_Cost;
	}

	public Double getTotal_Profit() {
		return Total_Profit;
	}

}
