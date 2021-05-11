import { Injectable, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Employee } from './models/Employee';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class EmployeeServiceService{

   private baseUrl: string;
  
   constructor(private httpClient: HttpClient) {
     this.baseUrl = "http://localhost:8080/api/employee/";
    }

   private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
      Authorization: 'my-auth-token'
    })
  };
   
   getEmployeeById(id: number): Observable<any> {
    return this.httpClient.get(`${this.baseUrl}/${id}`,this.httpOptions);
  }

    createEmployee(employee: Employee): Observable<Object> {
    return this.httpClient.post(`${this.baseUrl}`, employee, this.httpOptions);
  }

  updateEmployee(id: number, value: any): Observable<Object> {
    return this.httpClient.put(`${this.baseUrl}/${id}`, value, this.httpOptions);
  }

  deleteEmployee(id: number): Observable<any> {
    return this.httpClient.delete(`${this.baseUrl}/${id}`, this.httpOptions);
  }

  getEmployeesList(): Observable<Employee[]> {
    return this.httpClient.get<Employee[]>(`${this.baseUrl}`,this.httpOptions);
  }
}