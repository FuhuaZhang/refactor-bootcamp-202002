package cc.xpbootcamp.warmup.cashier;

import java.time.LocalDate;
import java.util.List;

import static cc.xpbootcamp.warmup.cashier.OrderReceipt.DATE_FORMAT;
import static cc.xpbootcamp.warmup.cashier.OrderReceipt.WEDNESDAY;

public class Order {
    public static final double TAX_RATE = 0.10;
    public static final double WEDNESDAY_DISCOUNT = 0.02;
    private List<LineItem> lineItems;
    private double subTotal;
    private LocalDate date;

    public Order(List<LineItem> lineItems, LocalDate date) {
        this.lineItems = lineItems;
        this.date = date;
        this.subTotal = setSubTotal();
    }

    public LocalDate getDate() {
        return date;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    double getTotalSalesTax() {
        return getSubTotal() * TAX_RATE;
    }

    double setSubTotal() {
        return lineItems.stream().mapToDouble(LineItem::totalAmount).sum();
    }

    public double getSubTotal() {
        return subTotal;
    }

    double getWednesdayDiscount() {
        if (DATE_FORMAT.format(this.getDate()).contains(WEDNESDAY))
            return getSubTotal() * WEDNESDAY_DISCOUNT;
        else
            return 0d;
    }

    double getTotal() {
        return getTotalSalesTax() + getSubTotal() - getWednesdayDiscount();
    }
}
