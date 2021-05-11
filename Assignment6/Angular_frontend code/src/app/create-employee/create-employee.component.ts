import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EmployeeServiceService } from '../employee-service.service';
import { Employee } from '../models/Employee';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit{

   employee:Employee=new Employee;
  

  constructor(private employeeService: EmployeeServiceService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    
  }


  saveEmployee(){
    this.employeeService.createEmployee(this.employee).subscribe( data =>{
      console.log(data);
      this.goToEmployeesList();
    },
    error => console.log(error));
  }

  goToEmployeesList(){
    this.router.navigate(['/employee']);
  }
  
  onSubmit(){
    console.log(this.employee);
    this.saveEmployee();
  }
  // onSubmit(){
  //   this.employeeService.createEmployee(this.employee).subscribe( result =>
  //     this.goToEmployeesList());
  // }
}

