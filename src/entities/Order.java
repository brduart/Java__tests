package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import enums.OrderStatus;

public class Order {
	
	private Date moment;
	private OrderStatus status;
	
	private Client client;
	private List<OrderItem> orderItem = new ArrayList<>();
	
	private static SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yyyy");

	
	public Order() {
		
	}


	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}


	public Date getMoment() {
		return moment;
	}


	public void setMoment(Date moment) {
		this.moment = moment;
	}


	public OrderStatus getStatus() {
		return status;
	}


	public void setStatus(OrderStatus status) {
		this.status = status;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public List<OrderItem> getOrderItem() {
		return orderItem;
	}
	
	public void addItem(OrderItem item) {
		orderItem.add(item);
	}
	
	public void removeItem(OrderItem item) {
		orderItem.remove(item);
	}
	
	public Double total() {
		
		double totalValue = 0.0;
		for(OrderItem c: orderItem) {
			
			totalValue += c.subTotal();
		}
		return totalValue;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order Moment");
		sb.append(sdt.format(moment) + "\n");
		sb.append("Order Status");
		sb.append(status + "\n");
		sb.append("Client: ");
		sb.append(client + "\n");
		sb.append("Order Items: ");
		
		for(OrderItem c: orderItem) {
			sb.append(c + "\n");
		}
		
		sb.append("Total price: " + total());
		
		return sb.toString();
	
	}
	
	
	
}
