package cc.xpbootcamp.warmup.cashier;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.stream.Collectors;

public class OrderReceipt {
    public static final String RECEIPT_HEADER_MARKET_NAME = "======老王超市，值得信赖======\n";
    public static final String SALES_TAX = "税额";
    public static final String DISCOUNT = "折扣";
    public static final String TOTAL_AMOUNT = "总价";
    public static final String WEDNESDAY = "星期三";
    public static final String CUTTING_LINE = "-----------------------------------";

    private Order order;
    private Date date = new Date();

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public OrderReceipt(Order order, Date date) {
        this.order = order;
        this.order.setSubTotal();
        this.date = date;
    }

    public String printReceipt() {
        return generateHeader() + generateLineItems() + generateFooter();
    }

    private String generateFooter() {
        return CUTTING_LINE + "\n"
                + SALES_TAX + ": " + formatPrice(order.getTotalSalesTax())
                + (new SimpleDateFormat("EEEE", Locale.CHINESE).format(date).equals(WEDNESDAY) ? DISCOUNT + ": " + formatPrice(order.getWednesdayDiscount(date)) + "\n" : "")
                + TOTAL_AMOUNT + ": " + formatPrice(order.getTotal(date));
    }

    private String generateLineItems() {
        return order.getLineItems().stream().map(this::printLineItemsDetails).collect(Collectors.joining());
    }

    private String generateHeader() {
        return RECEIPT_HEADER_MARKET_NAME + "\n" + this.getDate() + "\n";
    }

    private String printLineItemsDetails(LineItem lineItem) {
        return lineItem.getDescription() + ", "
                + formatPrice(lineItem.getPrice()) + " x " + lineItem.getQuantity() + ", "
                + formatPrice(lineItem.totalAmount()) + "\n";
    }

    public String getDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年mm月dd日, EEEE", Locale.CHINESE);
        return dateFormat.format(date);
    }

    public String formatPrice(double price) {
        return new DecimalFormat(".00").format(price);
    }
}