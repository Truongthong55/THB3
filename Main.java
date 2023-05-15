package THT3;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Ma HD: ");
        int orderID = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Ngay Lap Hoa Don (dd-mm-yyyy): ");
        String orderDateString = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate orderDate = LocalDate.parse(orderDateString, formatter);

        Order order = new Order(orderID, orderDate);

       
        System.out.print("So Luong San Pham Muon Xuat HD: ");
        int numOfProducts = scanner.nextInt();
        scanner.nextLine(); 

        
        for (int i = 0; i < numOfProducts; i++) {
            System.out.println("San Pham " + (i + 1));
            System.out.print("Ma San Pham: ");
            String productID = scanner.nextLine();

            System.out.print("Mo Ta: ");
            String description = scanner.nextLine();

            System.out.print("Đon Gia: ");
            double price = scanner.nextDouble();

            System.out.print("So Luong: ");
            int quantity = scanner.nextInt();
            scanner.nextLine(); 
          
            Product product = new Product(productID, description, price);
            order.addLineItem(product, quantity);
        }

       
        double totalCharge = order.calcTotalCharge();

      
        System.out.println("HOA ĐON");
        System.out.println("Ma HD: " + order.getOrderID());
        System.out.println("Ngay lap hoa đon: " + order.getOrderDate());        
        System.out.println("STT  |  Ma San Pham  |  Mo ta  | Đon gia  |  So luong  | Thanh tien ");

        ArrayList<OrderDetail> lineItems = order.getLineItems();
        for (int i = 0; i < lineItems.size(); i++) {
            OrderDetail lineItem = lineItems.get(i);
            Product product = lineItem.getProduct();
            int quantity = lineItem.getQuantity();
            double totalPrice = lineItem.calcTotalPrice();
        System.out.printf("%-4s |%-4s           | %-6s  | %-7s  | %-8s   | %-10s\n ",
                    (i + 1), product.getProductID(), product.getDescription(),
                    product.getPrice(), quantity, totalPrice);
        }
        System.out.println("Tong tien: " + totalCharge + " VND");
       
        scanner.close();
    }
}
