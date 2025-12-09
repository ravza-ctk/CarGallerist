import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Customer, CustomerRequest } from '../models/customer';
import { RootEntity } from '../models/gallerist';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class CustomerService {
  private apiUrl = 'http://localhost:8080/rest/api/customer';

  constructor(private http: HttpClient) { }

  saveCustomer(request: CustomerRequest): Observable<RootEntity<Customer>> {
    
    const token = localStorage.getItem('accessToken');

   
    let headers = new HttpHeaders();
    if (token) {
      headers = headers.set('Authorization', `Bearer ${token}`);
    }

    
    return this.http.post<RootEntity<Customer>>(
      `${this.apiUrl}/save`, 
      request, 
      { headers: headers }
    );
  }
}
