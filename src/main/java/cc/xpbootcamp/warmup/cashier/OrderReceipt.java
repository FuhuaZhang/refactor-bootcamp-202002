package cc.xpbootcamp.warmup.cashier;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.stream.Collectors;

public class OrderReceipt {
    public static final String RECEIPT_HEADER_MARKET_NAME = "======老王超市，值得信赖======\n";
    public static final String SALES_TAX = "税额";
    public static final String DISCOUNT = "折扣";
    public static final String TOTAL_AMOUNT = "总价";
    public static final String WEDNESDAY = "星期三";
    public static final String CUTTING_LINE = "-----------------------------------";
    public static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy年M月d日，EEEE", Locale.CHINA);

    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        return generateHeader() + generateLineItems() + generateFooter();
    }

    private String generateFooter() {
        return CUTTING_LINE + "\n"
                + SALES_TAX + ": " + formatPrice(order.getTotalSalesTax()) + "\n"
                + (DATE_FORMAT.format(order.getDate()).contains(WEDNESDAY) ? DISCOUNT + ": " + formatPrice(order.getWednesdayDiscount()) + "\n" : "")
                + TOTAL_AMOUNT + ": " + formatPrice(order.getTotal()) + "\n";
    }

    private String generateLineItems() {
        return order.getLineItems().stream().map(this::printLineItemsDetails).collect(Collectors.joining());
    }

    private String generateHeader() {
        System.out.println(order.getDate().toString());
        return RECEIPT_HEADER_MARKET_NAME + "\n" + this.formatDate(order.getDate()) + "\n";
    }

    private String printLineItemsDetails(LineItem lineItem) {
        return lineItem.getDescription() + ", "
                + formatPrice(lineItem.getPrice()) + " x " + lineItem.getQuantity() + ", "
                + formatPrice(lineItem.totalAmount()) + "\n";
    }

    public String formatDate(LocalDate date) {
        return DATE_FORMAT.format(date);
    }

    public String formatPrice(double price) {
        return new DecimalFormat(".00").format(price);
    }
}