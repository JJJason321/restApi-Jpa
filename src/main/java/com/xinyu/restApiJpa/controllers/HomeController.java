package com.xinyu.restApiJpa.controllers;

import com.xinyu.restApiJpa.models.*;
import com.xinyu.restApiJpa.repositorys.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.awt.desktop.SystemEventListener;
import java.util.List;
import java.util.Optional;


@CrossOrigin
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

    public HomeController(AccountRepository accountRepository,
                          AccountAppointmentRepository accountAppointmentRepository,
                          AppointmentRepository appointmentRepository,
                          ClientRepository clientRepository,
                          EmployeeRepository employeeRepository,
                          EmployeeServiceRepository employeeServiceRepository,
                          ScheduleRepository scheduleRepository,
                          ServiceRepository serviceRepository
    ) {
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

        System.out.println(account);
        System.out.println(account.getUsername());
        return accountRepository.save(account);
    }

    @PostMapping("/signIn")
    public ResponseEntity<?> SignIn(@RequestBody Account account){
        Long inputId = account.getId();
        System.out.println(inputId);
        String inputEmail = account.getUsername();
        String inputPassword = account.getPassword();
        Account acc = accountRepository.findByEmail(inputEmail);
        String realPassword = acc.getPassword();
        if(realPassword.equals(inputPassword)){
            System.out.println("password matches");
            return new ResponseEntity<>(acc, HttpStatus.OK);
        }else{
            System.out.println("passworkd dont matches");
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    //CreateAccount Api
    @PostMapping("/createaccount")
    public ResponseEntity<?> checkUsername(@RequestBody Account account){
        String inputUsername = account.getUsername();
        System.out.println(inputUsername);
        //Account acc = accountRepository.findByEmail(inputUsername);
        int result = accountRepository.countByEmail(inputUsername);
        if(result==0){
            System.out.println("everything is ok");
            accountRepository.save(account);
            return new ResponseEntity<>(account, HttpStatus.OK);
        }else{
            System.out.println("email existes");
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PostMapping("/appointmentlist")
    public void appointmentList(@RequestBody Account account){
        Long inputId = account.getId();
        System.out.println(inputId);
    }

    @GetMapping("/appointmentlist/{id}")
    public ResponseEntity<?> appointmentList(@PathVariable Long id){
        Long inputId = id;
        //System.out.println(inputId);
        List<Long> appointmentIdList = accountAppointmentRepository.findAppointmentIdByAccountId(inputId);
        System.out.println(appointmentIdList);

        if(appointmentIdList.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        List<Appointment> appointmentList = appointmentRepository.getAppointmentByOneId(appointmentIdList);
        //System.out.println(appointmentList);
        return new ResponseEntity<>(appointmentList, HttpStatus.OK);
    }


    @GetMapping("/clientInfo/{id}")
    public ResponseEntity<?> clientInfo(@PathVariable Long id){
        Long inputId = id;
        Client client = clientRepository.getClientByAccountId(inputId);
        System.out.println(client);
        if(client==null){
            System.out.println("no matcing client for given account id");
            return new ResponseEntity<>(null,HttpStatus.NOT_ACCEPTABLE);

        }
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @GetMapping("/employeeInfo/{id}")
    public ResponseEntity<?> employeeInfo(@PathVariable Long id){
        Long inputId = id;
        Employee employee = employeeRepository.getEmployeeByAccountId(inputId);
        System.out.println(employee);
        if(employee==null){
            System.out.println("no matching employee for given account id");
            return new ResponseEntity<>(null,HttpStatus.NOT_ACCEPTABLE);

        }
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PutMapping("/updateclientinfo")
    public ResponseEntity<?> updateclientInfo(@RequestBody Client client){
        /*
        System.out.println("here called");
        System.out.println(client.getFirstName());
        System.out.println(client.getLastName());
        System.out.println(client.getAccount_id());
        System.out.println(client.getAddress());
        System.out.println(client.getPhoneNumber());
    */
        String firstName = client.getFirstName();
        String lastName = client.getLastName();
        String phoneNumber = client.getPhoneNumber();
        String address = client.getAddress();
        Long account_id = client.getAccount_id();

        clientRepository.updateClientInfo(firstName,lastName,phoneNumber,address,account_id);

        Client new_client = clientRepository.getClientByAccountId(account_id);

        return new ResponseEntity<>(new_client, HttpStatus.OK);
    }

    @PutMapping("/updateemployeeinfo")
    public ResponseEntity<?> updatemployeeInfo(@RequestBody Employee employee){

        /*
        System.out.println("here called");
        System.out.println(employee.getFirstName());
        System.out.println(employee.getLastName());
        System.out.println(employee.getAccount_id());
        System.out.println(employee.getAddress());
        System.out.println(employee.getPhoneNumber());
        */
        String firstName = employee.getFirstName();
        String lastName = employee.getFirstName();
        String phoneNumber = employee.getPhoneNumber();
        String address = employee.getAddress();
        Long account_id = employee.getAccount_id();

        employeeRepository.updateEmployeeInfo(firstName,lastName,phoneNumber,address,account_id);

        Employee new_employee = employeeRepository.getEmployeeByAccountId(account_id);

        return new ResponseEntity<>(new_employee, HttpStatus.OK);
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
        System.out.println(client.getAccount_id());
        System.out.println(client.getFirstName());
        System.out.println(client.getLastName());
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
