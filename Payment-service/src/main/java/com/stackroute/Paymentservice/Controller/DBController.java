package com.stackroute.Paymentservice.Controller;

import com.stackroute.Paymentservice.Model.Payment;
import com.stackroute.Paymentservice.Service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
@CrossOrigin(origins = "http://localhost:4200")
public class DBController {
    @Autowired
    private DBService dbService;

    @PostMapping("/savePayment")
    public Payment savePayment(@RequestBody Payment payment) {
        return dbService.savePayment(payment);
    }

    @GetMapping("/getPayment/{email}")
    public Payment getPayment(@PathVariable String email)
    {
        return dbService.getPayment(email);
    }

    @PutMapping("/updatePayment/{email}")
    public Payment updatePayment(@RequestBody Payment payment, @PathVariable String email)
    {
        return dbService.updatePayment(payment,email);
    }

    @DeleteMapping("/deletePayment/{email}")
    public String deletePayment(@PathVariable String email)
    {
        dbService.deletePayment(email);
        return "Deleted Successfully";
    }


    @GetMapping("/getAllPayment")
    public List<Payment> getAllPayment()
    {
        return dbService.getAllPayment();
    }
}

