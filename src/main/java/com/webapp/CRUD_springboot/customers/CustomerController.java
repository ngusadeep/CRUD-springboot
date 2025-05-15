package com.webapp.CRUD_springboot.customers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;  // Important import
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerService customerService, CustomerRepository customerRepository) {
        this.customerService = customerService;
        this.customerRepository = customerRepository;
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

    @PostMapping("/create")
    public String createCustomers(@Valid @ModelAttribute CustomerDto customerDto , BindingResult result){
        if(customerRepository.findByEmail(customerDto.getEmail()) != null){
            result.addError(
                    new FieldError(
                            "customerDto" , "email" , customerDto.getEmail() , false , null , null , "Email Already exist!"
                    )
            );
        }
        if(result.hasErrors()){
            return "/customers/create";
        }
        Customer customer = new Customer();
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setEmail(customerDto.getEmail());
        customer.setPhone(customerDto.getPhone());
        customer.setAddress(customerDto.getAddress());
        customer.setGender(customerDto.getGender());
        customer.setStatus(customerDto.getStatus());
        
        customerRepository.save(customer);
        return "redirect:/customers";
    }
    
    @GetMapping("/edit")
    public String editCustomer(Model model , @RequestParam int id){
        Customer customer = customerRepository.findById(id).orElse(null);
        if(customer == null){
            return "redirect:/customers";
        }
        CustomerDto customerDto = new CustomerDto();
        customerDto.setFirstName(customer.getFirstName());
        customerDto.setLastName(customer.getLastName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setPhone(customer.getPhone());
        customerDto.setAddress(customer.getAddress());
        customerDto.setGender(customer.getGender());
        customerDto.setStatus(customer.getStatus());
        model.addAttribute("customer" , customer);
        model.addAttribute("customerDto" , customerDto);
        return "customers/edit";
    }


    @PostMapping("/edit")
    public String editCustomers(Model model , @RequestParam int id , @Valid @ModelAttribute CustomerDto customerDto , BindingResult result){
        Customer customer = customerRepository.findById(id).orElse(null);
        if(customer == null){
            return "redirect:/customers";
        }
        model.addAttribute("customer" , customer);
        if(result.hasErrors()){
            return "customers/edit";
        }

        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setEmail(customerDto.getEmail());
        customer.setPhone(customerDto.getPhone());
        customer.setAddress(customerDto.getAddress());
        customer.setGender(customerDto.getGender());
        customer.setStatus(customerDto.getStatus());

        try{
            customerRepository.save(customer);
        } catch (Exception e) {
            result.addError(
                    new FieldError(
                            "customerDto" , "email" , customerDto.getEmail() , false , null , null , "Email Already exist!"
                    )
            );
            return "clients/edit";
        }

        return "redirect:/customers";
    }
    @GetMapping("/delete")
    public String deleteCustomer( @RequestParam int id){
        Customer customer = customerRepository.findById(id).orElse(null);
        if(customer != null){
            customerRepository.delete(customer);
        }

        return "redirect:/customers";
    }


}
