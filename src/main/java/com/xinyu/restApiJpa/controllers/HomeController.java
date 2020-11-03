package com.xinyu.restApiJpa.controllers;

import com.xinyu.restApiJpa.models.Account;
import com.xinyu.restApiJpa.models.Client;
import com.xinyu.restApiJpa.models.Employee;
import com.xinyu.restApiJpa.repositorys.AccountRepository;
import com.xinyu.restApiJpa.repositorys.ClientRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class HomeController {

    //private final EmployeeRepository employeeRepository;
    private final ClientRepository clientRepository;
    private final AccountRepository accountRepository;


    HomeController(ClientRepository clientRepository, AccountRepository accountRepository){

        //this.employeeRepository = employeeRepository;
        this.clientRepository = clientRepository;
        this.accountRepository = accountRepository;


    }

    @GetMapping("/employees")
    String all(){
        System.out.println("called");
        return ("heyyyyyyyyyy twice");
    }

    @GetMapping("/clients")
    public List<Client> getAllClient(){
        return this.clientRepository.findAll();
    }

    @GetMapping("/clients/{id}")
    public Optional<Client> getClientById(@PathVariable Long id){
        return clientRepository.findById(id);
    }
    @GetMapping("/accounts")
    public List<Account> getAllAccount(){
        return this.accountRepository.findAll();
    }

    @GetMapping("/accounts/{id}")
    public Optional<Account> getAccountById(@PathVariable Long id){
        return accountRepository.findById(id);
    }

    @PostMapping("/clients")
    public Client client(@RequestBody Client client){
        return clientRepository.save(client);
    }

    @PostMapping("/accounts")
    public Account account(@RequestBody Account account){
       return accountRepository.save(account);
    }


}
