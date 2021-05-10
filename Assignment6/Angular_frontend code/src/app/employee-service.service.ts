import { Injectable, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Employee } from './models/Employee';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class EmployeeServiceService{

   private baseUrl: "http://localhost:8080/api/employee/";
  
  
   constructor(private httpClient: HttpClient) { }
   
   getEmployeeById(id: number): Observable<any> {
    return this.httpClient.get(`${this.baseUrl}/${id}`);
  }

  createEmployee(employee: Object): Observable<Object> {
    return this.httpClient.post(`${this.baseUrl}`, employee);
  }

  updateEmployee(id: number, value: any): Observable<Object> {
    return this.httpClient.put(`${this.baseUrl}/${id}`, value);
  }

  deleteEmployee(id: number): Observable<any> {
    return this.httpClient.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getEmployeesList(): Observable<any> {
    return this.httpClient.get(`${this.baseUrl}`);
  }
}