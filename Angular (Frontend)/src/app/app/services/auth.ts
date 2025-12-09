import { Injectable } from '@angular/core';
import { AuthRequest, AuthResponse, RootEntity, User } from '../models/auth';
import { Observable, tap } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class Auth {
  private apiUrl = 'http://localhost:8080'; 

  constructor(private http: HttpClient) { }

  register(request: AuthRequest): Observable<RootEntity<User>> {
    return this.http.post<RootEntity<User>>(`${this.apiUrl}/register`, request);
  }

  login(request: AuthRequest): Observable<RootEntity<AuthResponse>> {
    return this.http.post<RootEntity<AuthResponse>>(`${this.apiUrl}/authenticate`, request)
      .pipe(
        tap(response => {
          if (response.status === 200 && response.payload) {
            this.saveToken(response.payload.accessToken);
          }
        })
      );
  }


  saveToken(token: string) {
    localStorage.setItem('accessToken', token);
  }

  getToken(): string | null {
    return localStorage.getItem('accessToken');
  }

  logout() {
    localStorage.removeItem('accessToken');
  }

  isLoggedIn(): boolean {
    return !!this.getToken();
  }
}
