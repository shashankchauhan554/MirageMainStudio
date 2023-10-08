import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import  axios  from 'axios';
// import { SalonOwner } from './src/app/model/SalonOwner';
// import {SalonOwner}
// import { Admin } from 'src/app/model/admin';

@Injectable({
  providedIn: 'root',
})
export class SalonownerService {
  private baseUrl = 'http://localhost:8082/salon';
  constructor(private http: HttpClient) {}

  addSalonOwner(salonOwner: any) {
    return this.http.post(
      'http://localhost:8082/api/v1/addsalonowner',
      salonOwner
    );
  }

  viewAllSalonOwners(): Observable<any> {
    return this.http.get('http://localhost:8082/api/v1/viewallsalonowner');
  }

  updateSalonOwner(salonOwner: any): Observable<any> {
    return this.http.put(
      'http://localhost:8082/api/v1/updatesalonowner',
      salonOwner
    );
  }

  private urlO = 'http://localhost:8082/api/v1/viewallsalonowner';
  getAllOwner(): Observable<any> {
    return this.http.get(this.urlO);
  }
  private urlv = 'http://localhost:8082/salon/viewall';
  getAllSalons(): Observable<any> {
    return this.http.get(this.urlv);
  }
  getbyownerid(id: String): Observable<any> {
    const ur1o = `http://localhost:8082/ap1/v1/viewbyownerId/${1}`;
    return this.http.get<void>(ur1o);
  }
  private urlo1 = 'http://localhost:8082/api/v1/updatesalonowner';
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
  // private urlR = `http://localhost:8082/salon/viewall/${id}`;
  getAlldetailsById(id: String): Observable<any> {
    const urlR = `http://localhost:8082/salon/viewall/${id}`;
    return this.http.get(urlR);
  }
  getbyid(id: String): Observable<any> {
    const ur1 = `http://localhost:8082/salon/viewbyId/${id}`;
    return this.http.get<void>(ur1);
  }
  private urlu1 = 'http://localhost:8082/salon/update';
  updatesalon(salon: any): Observable<any> {
    return this.http.put(this.urlu1, salon);
  }
  private urlO1 = 'http://localhost:8082/salon/addsalon';
  addOwner(newOwner: any): Observable<any> {
    return this.http.post(this.urlO1, newOwner);
  }
  addSalon(newServiceData: any, id: String): Observable<any> {
    const url1 = `http://localhost:8082/salon/addservice/${id}`;
    return this.http.post(url1, newServiceData);
  }
  addslot(newServiceData: any, id: String): Observable<any> {
    const urlr = `http://localhost:8082/salon/addslot/${id}`;
    return this.http.post<FormData>(urlr, newServiceData);
  }
  deleteSlot(ownerId: string, slotId: string) {
    const url = `${this.baseUrl}/delete/${ownerId}/${slotId}`;
    return axios
      .delete(url)
      .then((response: { data: any; }) => {
        return response.data;
      })
      .catch((error: any) => {
        throw error;
      });
  }
  updateslot(salon: any, ownerId: string, slotId: string) {
    const url = `${this.baseUrl}/editslot/${ownerId}/${slotId}`;
    // return this.http.post(url, salon);
    return axios
      .post(url, salon)
      .then((response: { data: any; }) => {
        console.log('Service deleted:', response.data);
        return response.data;
      })
      .catch((error: any) => {
        console.error('Error deleting service:', error);
        throw error;
      });
  }
  updateservice(salon: any, ownerId: string, serviceId: string) {
    const url = `${this.baseUrl}/editservice/${ownerId}/${serviceId}`;
    return axios
      .post(url, salon)
      .then((response: { data: any; }) => {
        console.log('Service deleted:', response.data);
        return response.data;
      })
      .catch((error: any) => {
        console.error('Error deleting service:', error);
        throw error;
      });
  }
  deleteService(ownerId: string, serviceId: string) {
    const apiUrl = `${this.baseUrl}/deleteservice/${ownerId}/${serviceId}`;
    return axios
      .delete(apiUrl)
      .then((response: { data: any; }) => {
        console.log('Service deleted:', response.data);
        return response.data;
      })
      .catch((error: any) => {
        console.error('Error deleting service:', error);
        throw error;
      });
  }
}
