import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})






@Injectable({
  providedIn: 'root'
})
export class PaymentServiceService {
 
  constructor(private http:HttpClient) { }
  
SavePayment(paymentData: any):any{
    return this.http.post<any>(`http://localhost:8088/payment/savePayment`,paymentData);
  }

  
}