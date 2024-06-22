package exercicio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import enums.OrderStatus;

public class main {

	public static void main(String[] args) throws ParseException {
	 Locale.setDefault(Locale.US);
	 Scanner sc = new Scanner(System.in);
	 
	 SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yyyy");
	 
	 System.out.println("Enter cliente data: ");
	 
	 System.out.print("Name: ");
	 String name = sc.next();
	 sc.next();
	 System.out.print("Email: ");
	 String email = sc.next();
	 System.out.print("Birth Date: ");
	 Date birthDate = sdt.parse(sc.next());
	 
	 Client client = new Client(name, email, birthDate);
	 
	 System.out.print("Enter order data:");
	 
	 System.out.print("Status: ");
	 OrderStatus status = OrderStatus.valueOf(sc.next());
	 System.out.print("How many items to this order?: ");
	 Integer orderNumbers = sc.nextInt();
	 
	 Order order = new Order(new Date(), status, client);
	 
	 for(int i = 1; i <= orderNumbers; i++) {
		 System.out.print("Enter #"+i+"item data: ");
		 
		 System.out.print("Product name: ");
		 String productName = sc.next();
		 System.out.print("Product price: ");
		 Double productPrice = sc.nextDouble();
		 
		 Product product = new Product(productName, productPrice);
		 
		 System.out.print("Quantity: ");
		 Integer quantity = sc.nextInt();
		 
		 OrderItem orderItem = new OrderItem(quantity, productPrice, product);
		 
		 order.addItem(orderItem);
	 }
	 
	 System.out.println(order);
	 
	 sc.close();

	}

}
