package com.webapp.CRUD_springboot.customers;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
  public Customer findByEmail(String email);
}
