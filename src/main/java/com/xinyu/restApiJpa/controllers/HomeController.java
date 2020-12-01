package com.xinyu.restApiJpa.controllers;


import com.xinyu.restApiJpa.models.*;
import com.xinyu.restApiJpa.repositorys.*;
import net.minidev.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
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


        return accountRepository.save(account);
    }

    @PostMapping("/signIn")
    public ResponseEntity<?> SignIn(@RequestBody Account account){
        Long inputId = account.getId();

        String inputEmail = account.getUsername();
        String inputPassword = account.getPassword();
        Account acc = accountRepository.findByEmail(inputEmail);
        String realPassword = acc.getPassword();
        if(realPassword.equals(inputPassword)){

            return new ResponseEntity<>(acc, HttpStatus.OK);
        }else{

            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    //CreateAccount Api
    @PostMapping("/createaccount")
    public ResponseEntity<?> checkUsername(@RequestBody Account account){
        String inputUsername = account.getUsername();

        int result = accountRepository.countByEmail(inputUsername);
        if(result==0){

            accountRepository.save(account);
            return new ResponseEntity<>(account, HttpStatus.OK);
        }else{

            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PostMapping("/appointmentlist")
    public void appointmentList(@RequestBody Account account){
        Long inputId = account.getId();

    }

    @GetMapping("/appointmentlist/{id}")
    public ResponseEntity<?> appointmentList(@PathVariable Long id){
        Long inputId = id;

        List<Long> appointmentIdList = accountAppointmentRepository.findAppointmentIdByAccountId(inputId);


        if(appointmentIdList.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        List<Appointment> appointmentList = appointmentRepository.getAppointmentByOneId(appointmentIdList);

        return new ResponseEntity<>(appointmentList, HttpStatus.OK);
    }


    @GetMapping("/clientInfo/{id}")
    public ResponseEntity<?> clientInfo(@PathVariable Long id){
        Long inputId = id;
        Client client = clientRepository.getClientByAccountId(inputId);

        if(client==null){

            return new ResponseEntity<>(null,HttpStatus.NOT_ACCEPTABLE);

        }
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @GetMapping("/employeeInfo/{id}")
    public ResponseEntity<?> employeeInfo(@PathVariable Long id){

        Long inputId = id;
        Employee employee = employeeRepository.getEmployeeByAccountId(inputId);

        if(employee==null){

            return new ResponseEntity<>(null,HttpStatus.NOT_ACCEPTABLE);

        }
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PutMapping("/updateclientinfo")
    public ResponseEntity<?> updateclientInfo(@RequestBody Client client){

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


    @PostMapping("/addschedule")
    public Schedule addSchedule(@RequestBody Schedule schedule){
        //System.out.println(schedule);
        return scheduleRepository.save(schedule);
    }

    @PostMapping("/findopenschedule")
    public ResponseEntity<?> findopenschedule(@RequestBody Object1 input){

        Long empId= input.getEmployee_id();
        Long accId = input.getAccount_id();
        LocalDate ld = input.getDate();

        List<Schedule> scheduleList = scheduleRepository.findScheduleByIdDate(empId,ld);

        if(scheduleList.size()==0){
            return new ResponseEntity<>("This Employee does not work today", HttpStatus.NOT_FOUND);
        }

        Schedule schedule = scheduleList.get(0);
        List<Long> appId = accountAppointmentRepository.findAppointmentIdByAccountId(accId);
        List<Appointment> appointmentList = appointmentRepository.getAppointmentByOneId(appId);
        List<Appointment> appointmentList2 = appointmentRepository.getAppointmentByOneIdAndDate(appId,ld);

        if(appointmentList2.size()==0){

            JSONObject body = new JSONObject();
            body.put("schedule", schedule);
            body.put("takenTime", null);
            body.put("isAllDay", true);

            return new ResponseEntity<>(body,HttpStatus.OK);

        }

        JSONObject body = new JSONObject();
        body.put("schedule",schedule);
        body.put("takenTime",appointmentList2);
        body.put("isAllDay", false);

        return  new ResponseEntity<>(body, HttpStatus.OK);

    }

    @PostMapping("/createappointment")
    public ResponseEntity<?> createappointment(@RequestBody Object2 input){

        Date date = Date.valueOf(input.getDate());
        Time startTime = input.getStartTime();
        Time endTime = input.getEndTime();

        Appointment appointment = new Appointment();
        appointment.setDate(date);
        appointment.setStartTime(startTime);
        appointment.setEndTime(endTime);

        appointmentRepository.save(appointment);
        Long app_id = appointment.getId();

        AccountAppointment accountAppointment = new AccountAppointment();
        accountAppointment.setAppointmentId(app_id);
        accountAppointment.setAccountId(input.getAccountProvider());

        AccountAppointment accountAppointment2 = new AccountAppointment();
        accountAppointment2.setAppointmentId(app_id);
        accountAppointment2.setAccountId(input.getAccountReceiver());

        accountAppointmentRepository.save(accountAppointment);
        accountAppointmentRepository.save(accountAppointment2);

        return new ResponseEntity<>(appointmentRepository.save(appointment),HttpStatus.ACCEPTED);


    }


}
