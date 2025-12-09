import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { RootEntity, Gallerist, GalleristSaveRequest } from '../models/gallerist';

@Injectable({
  providedIn: 'root'
})
export class GalleristService {

  private apiUrl = 'http://localhost:8080/rest/api/gallerist';

  constructor(private http: HttpClient) { }

  save(request: GalleristSaveRequest): Observable<RootEntity<Gallerist>> {
    const token = localStorage.getItem('accessToken');

    
    let headers = new HttpHeaders();
    if (token) {
      headers = headers.set('Authorization', `Bearer ${token}`);
    }

    
    return this.http.post<RootEntity<Gallerist>>(
      `${this.apiUrl}/save`, 
      request, 
      { headers: headers }
    );
  }
}