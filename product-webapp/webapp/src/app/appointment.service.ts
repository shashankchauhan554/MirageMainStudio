import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AppointmentService {
  private baseUrl = 'http://localhost:8060/booking'; // Update with your backend URL

  constructor(private http: HttpClient) {}

  createAppointment(appointmentDetails: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/create`, appointmentDetails);
  }

  getAllAppointments() {
    return this.http.get(`${this.baseUrl}/details`);
  }

  getAppointmentDetailsForBarber(id: number) {
    return this.http.get(`${this.baseUrl}/details/${id}`);
  }

  checkBarberAvailability(appointmentDetails: any) {
    return this.http.post(`${this.baseUrl}/barber/availability`, appointmentDetails);
  }
}
