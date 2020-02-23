package cc.xpbootcamp.warmup.cashier;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static cc.xpbootcamp.warmup.cashier.OrderReceipt.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

class OrderReceiptTest {
    @Test
    void should_print_header_correctly() {
        Order order = new Order(new ArrayList<LineItem>());
        OrderReceipt receipt = new OrderReceipt(order);

        String output = receipt.printReceipt();


        assertThat(output, containsString(RECEIPT_HEADER_MARKET_NAME + "\n"));
        assertThat(output, containsString(receipt.getDate() + "\n"));
    }

    @Test
    public void should_print_line_items_with_two_decimal_price_format() throws ParseException {
        List<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("milk", 10.0, 2));
            add(new LineItem("biscuits", 5.0, 5));
            add(new LineItem("chocolate", 20.0, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(new Order(lineItems), new SimpleDateFormat("EEEE", Locale.CHINESE).parse("星期四"));

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
        OrderReceipt receipt = new OrderReceipt(new Order(lineItems), new SimpleDateFormat("EEEE", Locale.CHINESE).parse("星期四"));

        String output = receipt.printReceipt();

        assertThat(output, containsString(CUTTING_LINE));
        assertThat(output, containsString(SALES_TAX+": 6.50"));
        assertThat(output, containsString(TOTAL_AMOUNT+": 71.50"));
    }

    @Test
    public void shouldPrintLineItemAndSalesTaxInformationAndDiscountWhenWednesday() throws ParseException {
        List<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("milk", 10.0, 2));
            add(new LineItem("biscuits", 5.0, 5));
            add(new LineItem("chocolate", 20.0, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(new Order(lineItems), new SimpleDateFormat("EEEE", Locale.CHINESE).parse(WEDNESDAY));

        String output = receipt.printReceipt();

        assertThat(output, containsString(CUTTING_LINE));
        assertThat(output, containsString(SALES_TAX+": 6.50"));
        assertThat(output, containsString(DISCOUNT+": 1.30"));
        assertThat(output, containsString(TOTAL_AMOUNT+": 70.20"));
    }
}