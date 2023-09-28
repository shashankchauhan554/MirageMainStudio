
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { SalonOwner } from 'src/app/model/SalonOwner';
import { Admin } from 'src/app/model/admin';

@Injectable({
  providedIn: 'root'
})
export class SalonownerService {
  constructor(private http: HttpClient) { }

  addSalonOwner(salonOwner: SalonOwner) {
    return this.http.post('http://localhost:8082/api/v1/addsalonowner', salonOwner);
  }

  viewAllSalonOwners(): Observable<any> {
    return this.http.get('http://localhost:8082/api/v1/viewallsalonowner');
  }

  updateSalonOwner(salonOwner: SalonOwner): Observable<any> {
    return this.http.put('http://localhost:8082/api/v1/updatesalonowner', salonOwner);
  }

  private urlO = "http://localhost:8082/api/v1/viewallsalonowner";
  getAllOwner(): Observable<any> {
    return this.http.get(this.urlO)
  }
  private urlv = "http://localhost:8082/salon/viewall";
  getAllSalons(): Observable<any> {
    return this.http.get(this.urlv)
  }
  getbyownerid(id: String): Observable<any> {
    const ur1o = `http://localhost:8082/ap1/v1/viewbyownerId/${1}`;
    return this.http.get<void>(ur1o);
  }
  private urlo1 = "http://localhost:8082/api/v1/updatesalonowner";
  updateOwner(owner: FormData): Observable<any> {
    return this.http.put<FormData>(this.urlo1, owner);
  }
  deletebysalonid(salonId: String): Observable<any> {
    const ur = `http://localhost:8082/salon/delete/${salonId}`;
    return this.http.delete<void>(ur);
  }
  deletebycategoryid(categoryId: String): Observable<any> {
    const ur = `http://localhost:8082/category/deletecategory/${categoryId}`;
    return this.http.delete<void>(ur);
  }
  private urlR = "http://localhost:8082/category/viewallcategory";
  getAllCategory(): Observable<any> {
    return this.http.get(this.urlR)
  }
  getbyid(id: String): Observable<any> {
    const ur1 = `http://localhost:8082/salon/viewbyId/${id}`;
    return this.http.get<void>(ur1);
  }
  private urlu1 = "http://localhost:8082/salon/update";
  updatesalon(salon: FormData): Observable<any> {
    return this.http.put<FormData>(this.urlu1, salon);
  }
  private urlO1 = "http://localhost:8082/api/v1/addalonowner";
  addOwner(newOwner: FormData): Observable<any> {
    return this.http.post<FormData>(this.urlO1, newOwner);
  }
  addSalon(newSalon: FormData, id: String): Observable<any> {
    const url1 = `http://localhost:8082/api/v1/addsalon/${id}`;
    return this.http.post<FormData>(url1, newSalon);
  }
  addCategory(newCategory: FormData, id: String): Observable<any> {
    const urlr = `http://localhost:8082/salon/addcategory/${id}`;
    return this.http.post<FormData>(urlr, newCategory);
  }

}
