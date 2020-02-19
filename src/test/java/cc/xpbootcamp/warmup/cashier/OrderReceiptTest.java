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
        Order order = new Order("Mr X", "Chicago, 60601", new ArrayList<LineItem>());
        OrderReceipt receipt = new OrderReceipt(order);

        String output = receipt.printReceipt();


        assertThat(output, containsString(RECEIPT_HEADER_MARKET_NAME));
        assertThat(output, containsString(receipt.getDate()));
    }

    @Test
    public void shouldPrintLineItemAndSalesTaxInformation() throws ParseException {
        List<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("milk", 10.0, 2));
            add(new LineItem("biscuits", 5.0, 5));
            add(new LineItem("chocolate", 20.0, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(new Order(null, null, lineItems), new SimpleDateFormat("EEEE", Locale.CHINESE).parse("星期四"));

        String output = receipt.printReceipt();

        assertThat(output, containsString("milk\t10.0\t2\t20.0\n"));
        assertThat(output, containsString("biscuits\t5.0\t5\t25.0\n"));
        assertThat(output, containsString("chocolate\t20.0\t1\t20.0\n"));
        assertThat(output, containsString(SALES_TAX+"\t6.5"));
        assertThat(output, containsString(TOTAL_AMOUNT+"\t71.5"));
    }

    @Test
    public void shouldPrintLineItemAndSalesTaxInformationAndDiscountWhenWednesday() throws ParseException {
        List<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("milk", 10.0, 2));
            add(new LineItem("biscuits", 5.0, 5));
            add(new LineItem("chocolate", 20.0, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(new Order(null, null, lineItems), new SimpleDateFormat("EEEE", Locale.CHINESE).parse(WEDNESDAY));

        String output = receipt.printReceipt();

        assertThat(output, containsString("milk\t10.0\t2\t20.0\n"));
        assertThat(output, containsString("biscuits\t5.0\t5\t25.0\n"));
        assertThat(output, containsString("chocolate\t20.0\t1\t20.0\n"));
        assertThat(output, containsString(SALES_TAX+"\t6.5"));
        assertThat(output, containsString(DISCOUNT+"\t1.3"));
        assertThat(output, containsString(TOTAL_AMOUNT+"\t70.2"));
    }
}