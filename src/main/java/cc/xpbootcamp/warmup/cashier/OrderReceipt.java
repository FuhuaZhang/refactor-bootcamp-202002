package cc.xpbootcamp.warmup.cashier;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class OrderReceipt {
    public static final String RECEIPT_HEADER_MARKET_NAME = "======老王超市，值得信赖======\n";
    public static final String SALES_TAX = "税额";
    public static final String DISCOUNT = "折扣";
    public static final String TOTAL_AMOUNT = "总价";
    public static final String WEDNESDAY = "星期三";

    private Order order;
    private Date date = new Date();

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public OrderReceipt(Order order, Date date) {
        this.order = order;
        this.date = date;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        generateHeader(output);

        generateLineItems(output);

        generateFooter(output);

        return output.toString();
    }

    private void generateFooter(StringBuilder output) {
        order.setSubTotal();
        double totalSalesTax = order.getTotalSalesTax();
        double wednesdayDiscount = order.getWednesdayDiscount(date);
        double total = order.getTotal(date);

        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE", Locale.CHINESE);
        output.append(SALES_TAX).append('\t').append(totalSalesTax).append("\n");
        if (dateFormat.format(date).equals(WEDNESDAY)) {
            output.append(DISCOUNT).append('\t').append(wednesdayDiscount).append("\n");
        }
        output.append(TOTAL_AMOUNT).append("\t").append(total).append("\n");
    }

    private void generateLineItems(StringBuilder output) {
        for (LineItem lineItem : order.getLineItems()) {
            printLineItemsDetails(output, lineItem);
        }
    }

    private void generateHeader(StringBuilder output) {
        output.append(RECEIPT_HEADER_MARKET_NAME);
        output.append(this.getDate());
        output.append("\n");
    }

    private void printLineItemsDetails(StringBuilder output, LineItem lineItem) {
        output.append(lineItem.getDescription());
        output.append("\t");
        output.append(lineItem.getPrice());
        output.append("\t");
        output.append(lineItem.getQuantity());
        output.append("\t");
        output.append(lineItem.totalAmount());
        output.append("\n");
    }

    public String getDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年mm月dd日, EEEE", Locale.CHINESE);
        return dateFormat.format(date);
    }
}