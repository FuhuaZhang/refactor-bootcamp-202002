package cc.xpbootcamp.warmup.cashier;

import java.util.List;

public class Order {
    String customerName;
    String address;
    List<LineItem> lineItems;

    public Order(String customerName, String address, List<LineItem> lineItems) {
        this.customerName = customerName;
        this.address = address;
        this.lineItems = lineItems;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return address;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    double getTotalSalesTax() {
        double totalSalesTax = 0d;
        for (LineItem lineItem : getLineItems()) {
            double salesTax = lineItem.totalAmount() * .10;
            totalSalesTax += salesTax;
        }
        return totalSalesTax;
    }

    double getTotalAmount() {
        double totalAmount = 0d;
        for (LineItem lineItem : getLineItems()) {
            double salesTax = lineItem.totalAmount() * .10;
            totalAmount += lineItem.totalAmount() + salesTax;
        }
        return totalAmount;
    }
}
