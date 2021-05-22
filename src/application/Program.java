package application;

import entities.*;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter client data:");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth Date (DD/MM/YYYY): ");
        LocalDate birthDate = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println("\nEnter order data: ");
        System.out.print("Status: ");
        String orderStatus = sc.next();
        Order order = new Order(LocalDate.now(), OrderStatus.valueOf(orderStatus), new Client(name, email, birthDate));

        System.out.print("How many items to this order? ");
        int n = sc.nextInt();
        sc.nextLine();


        for (int i = 1; i<=n; i++){
            System.out.println("Enter #" + i + " item data: ");
            System.out.print("Product name: ");
            String productName = sc.nextLine();
            System.out.print("Product price: ");
            Double price = sc.nextDouble();
            sc.nextLine();
            System.out.print("Quantity: ");
            int qnt = sc.nextInt();
            sc.nextLine();

            Product product = new Product(productName, price);
            OrderItem item = new OrderItem(qnt, product);
            order.addItem(item);
        }



        System.out.println(order);

        sc.close();
    }
}
