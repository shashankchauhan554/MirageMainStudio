import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class UserRegistrationServiceService {

  constructor(private http : HttpClient) { }

  public getById():Observable<any>
  {
    const url = 'http://localhost:8085/user/api/getByEmail/kumar@gmail.com'
    return this.http.get<any>(url);
  }

  public putById(userProfile:any):Observable<any>
  {
    const url = 'http://localhost:8085/user/api/update'
    return this.http.put<any>(url, userProfile);
  }
}
