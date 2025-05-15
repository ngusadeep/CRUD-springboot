package com.webapp.CRUD_springboot.customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;  // Important import
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public String getCustomers(Model model) {
        List<Customer> customers = customerService.getCustomers();  // call service method here
        model.addAttribute("customers", customers);                 // add data to the model
        return "customers/index";                                    // return view name
    }
    @GetMapping("/create")
    public String createCustomers(Model model) {
        CustomerDto customerDto = new CustomerDto();
        model.addAttribute("customerDto" , customerDto);
        return "customers/create";                                    // return view name
    }

}
