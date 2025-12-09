import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Attribute, AttributeRequest, AttributeValue, AttributeValueRequest, RootEntity } from '../models/attribute';

@Injectable({
  providedIn: 'root',
})
export class AttributeService {
  private baseUrlAttribute = 'http://localhost:8080/rest/api/attribute';
  private baseUrlAttributeValue = 'http://localhost:8080/rest/api/attribute-value';

  constructor(private http: HttpClient) { }

  
  createAttribute(request: AttributeRequest): Observable<RootEntity<Attribute>> {
    return this.http.post<RootEntity<Attribute>>(`${this.baseUrlAttribute}/save-attr`, request);
  }

 
  createAttributeValue(attrCode: string, request: AttributeValueRequest): Observable<RootEntity<AttributeValue>> {
    return this.http.post<RootEntity<AttributeValue>>(`${this.baseUrlAttribute}/${attrCode}/save-value`, request);
  }

  
  getValuesByCode(attrCode: string): Observable<RootEntity<AttributeValue[]>> {
    return this.http.get<RootEntity<AttributeValue[]>>(`${this.baseUrlAttribute}/${attrCode}/values`);
  }
  
 
  getAllAttributes(): Observable<RootEntity<Attribute[]>> {
    return this.http.get<RootEntity<Attribute[]>>(this.baseUrlAttribute);
  }

 
  
  getValueById(id: number): Observable<RootEntity<AttributeValue>> {
    return this.http.get<RootEntity<AttributeValue>>(`${this.baseUrlAttributeValue}/${id}`);
  }

  
  updateValue(id: number, request: AttributeValueRequest): Observable<RootEntity<AttributeValue>> {
    return this.http.put<RootEntity<AttributeValue>>(`${this.baseUrlAttributeValue}/update/${id}`, request);
  }

  
  deleteValue(id: number): Observable<RootEntity<string>> {
    return this.http.delete<RootEntity<string>>(`${this.baseUrlAttributeValue}/delete/${id}`);
  }
}
