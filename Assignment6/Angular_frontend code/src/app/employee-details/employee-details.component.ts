import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { EmployeeServiceService } from '../employee-service.service';
import { Employee } from '../models/Employee';

@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.css']
})
export class EmployeeDetailsComponent implements OnInit {

  id:number;
  employee:Employee; 
  constructor(private route: ActivatedRoute, private employeService: EmployeeServiceService) { 
    
  }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.employee = new Employee();
    this.employeService.getEmployeeById(this.id).subscribe( data => {
      this.employee = data;
    });
  }

}
