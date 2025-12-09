import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { RootEntity, Address, AddressRequest } from '../models/address';

@Injectable({
  providedIn: 'root'
})
export class AddressService {

 private apiUrl = 'http://localhost:8080/rest/api/address';

  constructor(private http: HttpClient) { }

  saveAddress(request: AddressRequest): Observable<RootEntity<Address>> {
    const token = localStorage.getItem('accessToken');

    let headers = new HttpHeaders();
    if (token) {
      headers = headers.set('Authorization', `Bearer ${token}`);
    }

   
    return this.http.post<RootEntity<Address>>(
      `${this.apiUrl}/save`, 
      request, 
      { headers: headers }
    );
  }
}