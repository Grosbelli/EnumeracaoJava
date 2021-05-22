package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private LocalDate moment;
    private OrderStatus status;
    private Client client;
    private List<OrderItem> items = new ArrayList<>();

    public Order() {
    }

    public Order(LocalDate moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public LocalDate getMoment() {
        return moment;
    }

    public void setMoment(LocalDate moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void addItem(OrderItem item){
        items.add(item);
    }

    public void removeItem(OrderItem item){
        items.remove(item);
    }

    public double total(){
        double sum = 0;
        for (OrderItem i : items) {
            sum += i.subTotal();
        }

        return sum;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("ORDER SUMMARY: \n");
        sb.append("Order moment: ");
        sb.append(moment);
        sb.append("\nOrder status: ");
        sb.append(status);
        sb.append("\nClient: ");
        sb.append(client.getName() + " (" + client.getBirthDate() + ") - " + client.getEmail());
        sb.append("\nOrder items: ");
        items.forEach(item -> {
            sb.append("\n" + item.getProduct().getName() + " $" + String.format("%.2f", item.getPrice()) +
                    ", Quantity: " + item.getQuantity() + ", Subtotal: $" + String.format("%.2f", item.subTotal()));
        });
        sb.append("\nTotal price: $");
        sb.append(total());

        return sb.toString();
    }
}
