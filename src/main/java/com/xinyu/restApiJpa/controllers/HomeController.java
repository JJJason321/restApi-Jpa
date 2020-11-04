package com.xinyu.restApiJpa.controllers;

import com.xinyu.restApiJpa.models.*;
import com.xinyu.restApiJpa.repositorys.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class HomeController {


    private AccountRepository accountRepository;
    private AccountAppointmentRepository accountAppointmentRepository;
    private AppointmentRepository appointmentRepository;
    private ClientRepository clientRepository;
    private EmployeeRepository employeeRepository;
    private EmployeeServiceRepository employeeServiceRepository;
    private ScheduleRepository scheduleRepository;
    private ServiceRepository serviceRepository;

    public HomeController(AccountRepository accountRepository, AccountAppointmentRepository accountAppointmentRepository, AppointmentRepository appointmentRepository, ClientRepository clientRepository, EmployeeRepository employeeRepository, EmployeeServiceRepository employeeServiceRepository, ScheduleRepository scheduleRepository, ServiceRepository serviceRepository) {
        this.accountRepository = accountRepository;
        this.accountAppointmentRepository = accountAppointmentRepository;
        this.appointmentRepository = appointmentRepository;
        this.clientRepository = clientRepository;
        this.employeeRepository = employeeRepository;
        this.employeeServiceRepository = employeeServiceRepository;
        this.scheduleRepository = scheduleRepository;
        this.serviceRepository = serviceRepository;
    }


    //Account API
    @GetMapping("/accounts")
    public List<Account> getAllAccount(){
        return this.accountRepository.findAll();
    }

    @GetMapping("/accounts/{id}")
    public Optional<Account> getAccountById(@PathVariable Long id){
        return accountRepository.findById(id);
    }

    @PostMapping("/accounts")
    public Account account(@RequestBody Account account){
        return accountRepository.save(account);
    }

    //AccountAppointment API
    @GetMapping("/accountAppointments")
    public List<AccountAppointment> getAllAccountAppointment(){ return this.accountAppointmentRepository.findAll();}

    @GetMapping("/accountAppointments/{id}")
    public Optional<AccountAppointment> getAccountAppointment(@PathVariable Long id){
        doSth();
        return accountAppointmentRepository.findById(id);
    }

    private void doSth(){
        System.out.println("doSth called");
    }

    //Appointment API
    @GetMapping("/appointments")
    public List<Appointment> getAllAppointment(){return this.appointmentRepository.findAll();}

    @GetMapping("/appointment/{id}")
    public Optional<Appointment> getAppointmentById(@PathVariable Long id){ return this.appointmentRepository.findById(id);}

    @GetMapping("/appointment/account/1234")
    public List<Appointment> getAppointmentByAccountId(){
        return this.appointmentRepository.getAppointmentByAccountId();
    }

    //Client API
    @GetMapping("/clients")
    public List<Client> getAllClient(){
        return this.clientRepository.findAll();
    }

    @GetMapping("/clients/{id}")
    public Optional<Client> getClientById(@PathVariable Long id){
        return clientRepository.findById(id);
    }

    @PostMapping("/clients")
    public Client client(@RequestBody Client client){
        return clientRepository.save(client);
    }


    //Employee API
    @GetMapping("/employees")
    public List<Employee> getAllEmployee(){ return this.employeeRepository.findAll(); }

    @GetMapping("/employee/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id){ return employeeRepository.findById(id);}

    @PostMapping("/employees")
    public Employee employee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }




}
