package cc.xpbootcamp.warmup.cashier;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static cc.xpbootcamp.warmup.cashier.OrderReceipt.WEDNESDAY;

public class Order {
    public static final double TAX_RATE = 0.10;
    public static final double WEDNESDAY_DISCOUNT = 0.02;
    String customerName;
    String address;
    List<LineItem> lineItems;
    double subTotal;

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
        return getSubTotal() * TAX_RATE;
    }

    void setSubTotal() {
        for (LineItem lineItem : getLineItems()) {
            subTotal += lineItem.totalAmount();
        }
    }

    public double getSubTotal() {
        return subTotal;
    }

    double getWednesdayDiscount(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE", Locale.CHINESE);
        if (dateFormat.format(date).equals(WEDNESDAY))
            return getSubTotal() * WEDNESDAY_DISCOUNT;
        else
            return 0d;
    }

    double getTotal(Date date) {
        return getTotalSalesTax() + getSubTotal() - getWednesdayDiscount(date);
    }
}
