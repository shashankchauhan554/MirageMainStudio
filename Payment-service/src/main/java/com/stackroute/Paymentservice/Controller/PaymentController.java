package com.stackroute.Paymentservice.Controller;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@RequestMapping("/pg")
@CrossOrigin(origins = "http://localhost:4200")
public class PaymentController {

    private RazorpayClient client;
    private static final String SECRET_ID1 = "rzp_test_MqMqGKd7l2hvDD";
    private static final String SECRET_KEY1 = "5laESZ2G7i8mkhXx359zuHDd";
    private static final String SECRET_ID2 = "rzp_test_J4fInjDpTX475d";
    private static final String SECRET_KEY2 = "r8fNXAB78RmsVfdiQbWGwyjr";

    @PostMapping("/createOrder")
    public OrderResponse createOrder(@RequestBody OrderRequest orderRequest) {
        OrderResponse response = new OrderResponse();
        try {

            if (orderRequest.getAmount().intValue() > 1000) {
                client = new RazorpayClient(SECRET_ID1, SECRET_KEY1);
            }
            else {
                client = new RazorpayClient(SECRET_ID2, SECRET_KEY2);
            }

            Order order = createRazorPayOrder(orderRequest.getAmount());
            System.out.println("---------------------------");
            String orderId = (String) order.get("id");
            System.out.println("Order ID: " + orderId);
            System.out.println("---------------------------");
            response.setRazorpayOrderId(orderId);
            response.setApplicationFee("" + orderRequest.getAmount());
            if (orderRequest.getAmount().intValue() > 1000) {
                response.setSecretKey(SECRET_KEY1);
                response.setSecretId(SECRET_ID1);
                response.setPgName("razor1");
            } else {
                response.setSecretKey(SECRET_KEY2);
                response.setSecretId(SECRET_ID2);
                response.setPgName("razor2");
            }

            return response;
        } catch (RazorpayException e) {
            System.out.println(e.getMessage());
        }

        return response;

    }

    private Order createRazorPayOrder(BigInteger amount) throws RazorpayException {

        JSONObject options = new JSONObject();
        try {
            options.put("amount", amount.multiply(new BigInteger("100")));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        try {
            options.put("currency", "INR");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        try {
            options.put("receipt", "txn_123456");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        try {
            options.put("payment_capture", 1); // Auto Capture=1.
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return client.orders.create(options);
    }
}
