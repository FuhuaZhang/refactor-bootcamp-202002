package cc.xpbootcamp.warmup.cashier;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class OrderReceipt {
    public static final String RECEIPT_HEADER_MARKET_NAME = "======老王超市，值得信赖======\n";
    private Order order;
    private Date date = new Date();

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        generateHeader(output);

        generateLineItems(output);

        generateFooter(output);

        return output.toString();
    }

    private void generateFooter(StringBuilder output) {
        double totalAmount = order.getTotalAmount();
        double totalSalesTax = order.getTotalSalesTax();
        output.append("Sales Tax").append('\t').append(totalSalesTax);
        output.append("Total Amount").append('\t').append(totalAmount);
    }

    private void generateLineItems(StringBuilder output) {
        for (LineItem lineItem : order.getLineItems()) {
            printLineItemsDetails(output, lineItem);
        }
    }

    private void generateHeader(StringBuilder output) {
        output.append(RECEIPT_HEADER_MARKET_NAME);
        output.append(this.getDate());
        output.append('\n');
    }

    private void printLineItemsDetails(StringBuilder output, LineItem lineItem) {
        output.append(lineItem.getDescription());
        output.append('\t');
        output.append(lineItem.getPrice());
        output.append('\t');
        output.append(lineItem.getQuantity());
        output.append('\t');
        output.append(lineItem.totalAmount());
        output.append('\n');
    }

    public String getDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年mm月dd日, EEEE", Locale.CHINESE);
        return dateFormat.format(date);
    }
}