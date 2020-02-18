package cc.xpbootcamp.warmup.cashier;

public class OrderReceipt {
    private Order order;

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
        output.append("======Printing Orders======\n");

//        output.append("Date - " + order.getDate();
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());
//        output.append(order.getCustomerLoyaltyNumber());
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
}