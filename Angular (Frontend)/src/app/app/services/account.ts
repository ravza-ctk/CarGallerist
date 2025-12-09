import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Account, AccountRequest } from '../models/account';
import { RootEntity } from '../models/gallerist';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AccountService {
    private apiUrl = 'http://localhost:8080/rest/api/account';

  constructor(private http: HttpClient) { }

  saveAccount(request: AccountRequest): Observable<RootEntity<Account>> {
  
    const token = localStorage.getItem('accessToken');

    
    let headers = new HttpHeaders();
    if (token) {
      headers = headers.set('Authorization', `Bearer ${token}`);
    }

    
    return this.http.post<RootEntity<Account>>(
      `${this.apiUrl}/save`, 
      request, 
      { headers: headers } 
    );
  }
}

