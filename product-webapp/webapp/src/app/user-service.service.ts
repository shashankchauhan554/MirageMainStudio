import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})






@Injectable({
  providedIn: 'root'
})
export class UserServiceService {
 
  
  private API_URL='http://localhost:8082/'
  constructor(private http:HttpClient) { }
loginUser(user:any):any{
    return this.http.post<any>(`${this.API_URL}api/v1/login`,user)
  }

  
}