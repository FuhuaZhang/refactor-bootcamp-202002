package cc.xpbootcamp.warmup.cashier;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static cc.xpbootcamp.warmup.cashier.OrderReceipt.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

class OrderReceiptTest {
    @Test
    void should_print_header_correctly() {
        Order order = new Order(new ArrayList<LineItem>(), LocalDate.parse("2020-02-17"));
        OrderReceipt receipt = new OrderReceipt(order);

        String output = receipt.printReceipt();


        assertThat(output, containsString(RECEIPT_HEADER_MARKET_NAME + "\n"));
        assertThat(output, containsString(receipt.formatDate(order.getDate()) + "\n"));
    }

    @Test
    public void should_print_line_items_with_two_decimal_price_format() throws ParseException {
        List<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("milk", 10.0, 2));
            add(new LineItem("biscuits", 5.0, 5));
            add(new LineItem("chocolate", 20.0, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(new Order(lineItems, LocalDate.parse("2020-02-17")));

        String output = receipt.printReceipt();

        assertThat(output, containsString("milk, 10.00 x 2, 20.00\n"));
        assertThat(output, containsString("biscuits, 5.00 x 5, 25.00\n"));
        assertThat(output, containsString("chocolate, 20.00 x 1, 20.00\n"));
    }

    @Test
    public void should_print_sale_taxes_and_total_price() throws ParseException {
        List<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("milk", 10.0, 2));
            add(new LineItem("biscuits", 5.0, 5));
            add(new LineItem("chocolate", 20.0, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(new Order(lineItems, LocalDate.parse("2020-02-18")));

        String output = receipt.printReceipt();

        assertThat(output, containsString(CUTTING_LINE));
        assertThat(output, containsString(SALES_TAX+": 6.50"));
        assertThat(output, containsString(TOTAL_AMOUNT+": 71.50"));
    }

    @Test
    public void should_print_sale_taxes_and_total_price_and_discount_when_wednesday() throws ParseException {
        List<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("milk", 10.0, 2));
            add(new LineItem("biscuits", 5.0, 5));
            add(new LineItem("chocolate", 20.0, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(new Order(lineItems, LocalDate.parse("2020-02-19")));

        String output = receipt.printReceipt();

        assertThat(output, containsString(CUTTING_LINE));
        assertThat(output, containsString(SALES_TAX+": 6.50"));
        assertThat(output, containsString(DISCOUNT+": 1.30"));
        assertThat(output, containsString(TOTAL_AMOUNT+": 70.20"));
    }
}