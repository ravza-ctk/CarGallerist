import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CurrencyResponse, RootEntity } from '../models/currency';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class CurrencyService {
   private apiUrl = 'http://localhost:8080/rest/api/currency-rates';

  constructor(private http: HttpClient) { }

  getRates(startDate: string, endDate: string): Observable<RootEntity<CurrencyResponse>> {
   
    const token = localStorage.getItem('accessToken');

    
    let headers = new HttpHeaders();
    if (token) {
      headers = headers.set('Authorization', `Bearer ${token}`);
    }

    const params = new HttpParams()
      .set('startDate', startDate)
      .set('endDate', endDate);

    
    return this.http.get<RootEntity<CurrencyResponse>>(this.apiUrl, { params, headers });
  }
}
