import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Car, CarRequest, RootEntity } from '../models/car';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class CarService {
   private apiUrl = 'http://localhost:8080/rest/api/car';

  constructor(private http: HttpClient) { }

  saveCar(request: CarRequest): Observable<RootEntity<Car>> {
    
    const token = localStorage.getItem('accessToken');

    
    let headers = new HttpHeaders();
    if (token) {
      headers = headers.set('Authorization', `Bearer ${token}`);
    }

    return this.http.post<RootEntity<Car>>(
      `${this.apiUrl}/save`, 
      request, 
      { headers: headers }
    );
  }
  
}
