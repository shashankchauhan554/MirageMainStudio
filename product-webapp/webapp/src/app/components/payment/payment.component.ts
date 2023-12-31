import { Component, HostListener, inject } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { OrderServiceService } from './order-service.service';
import { Observable } from 'rxjs';
import { PaymentServiceService } from 'src/app/services/Payment/payment.service.service';
import { SalonownerService } from 'src/app/services/salonowner/salonowner.service';
import { AppointmentService } from 'src/app/appointment.service';


declare var Razorpay: any;

@Component({
  selector: 'app-root',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent {
  title = 'demo';
  totalPrice: number = 0;
  selectedService: any;
  selectedSlot: any;
  salonName: string = '';
  email: string = '';
  city = ''
  customerName = ''


  form: any = {
  
  };

  private scall = inject(PaymentServiceService);
  responseData: any;
  constructor(private http: HttpClient,
    private orderService: OrderServiceService,
    private sos: SalonownerService,
    private bookingService: AppointmentService,
    private route: ActivatedRoute,
    private router: Router,
  ) {

  }

  paymentData: any;

  ngOnInit() {
    this.totalPrice = this.sos.totalPrice;
    this.selectedService = this.sos.selectedSalonServices;
    this.selectedSlot = this.sos.selectedSlots;
    this.salonName = this.sos.salonName;
    this.email = this.sos.email;
    this.totalPrice = this.sos.totalPrice;
    this.city = this.sos.city;
    this.customerName = this.sos.customerName

    
    console.log(this.selectedService)
    console.log(this.selectedSlot)
    console.log(this.salonName)
    console.log(this.email)
    console.log(this.totalPrice)
    console.log(this.selectedService)
    console.log(this.city)
    console.log(this.customerName)
  }

  sayHello() {
    alert("Hello DK");
  }

  paymentId: string | undefined;
  error: string | undefined;

  options = {
    "key": "",
    "amount": "",
    "name": "MirageManeStudio",
    "description": "Web Development",
    "image": "webapp/src/assets/imge.jpg/",
    "order_id": "",
    "handler": function (response: any) {
      var event = new CustomEvent("payment.success",
        {
          detail: response,
          bubbles: true,
          cancelable: true
        }
      );
      window.dispatchEvent(event);
    }
    ,
    "prefill": {
      "name": "",
      "email": "",
      "contact": ""
    },
    "notes": {
      "address": ""
    },
    "theme": {
      "color": "#3399cc"
    }
  };

  onSubmit(): void {
    this.paymentId = '';
    this.error = '';
    this.form.amount= this.totalPrice;
    console.log(this.form.email);
    console.log(this.form.amount)
    this.orderService.createOrder(this.form).subscribe(
      data => {
        this.options.key = data.secretId;
        this.options.order_id = data.razorpayOrderId;
        this.options.amount = data.applicationFee; //paise
        this.options.prefill.name = "Mirage Mane Studios";
        this.options.prefill.email = "miragemanestudios@gmail.com";
        this.options.prefill.contact = "9090909090";

        if (data.pgName === 'razor2') {
          this.options.image = "";
          var rzp1 = new Razorpay(this.options);
          rzp1.open();
        } else {
          var rzp2 = new Razorpay(this.options);
          rzp2.open();
        }


        rzp1.on('payment.failed', (response: { error: { code: any; description: any; source: any; step: any; reason: any; metadata: { order_id: any; payment_id: any; }; }; }) => {
          // Todo - store this information in the server
          console.log(response);
          console.log(response.error.code);
          console.log(response.error.description);
          console.log(response.error.source);
          console.log(response.error.step);
          console.log(response.error.reason);
          console.log(response.error.metadata.order_id);
          console.log(response.error.metadata.payment_id);
          this.error = response.error.reason;
        }
        );
      }
      ,
      err => {
        this.error = err.error.message;
      }
    );
  }

  @HostListener('window:payment.success', ['$event'])
  onPaymentSuccess(event: { detail: any; }): void {
    console.log(event.detail);
    console.log(this.form.name);
    console.log(this.form.email);
    console.log(event.detail.razorpay_order_id);
    const { razorpayPayemntID, razorpayOrderId, signature } = event.detail;

    this.paymentData = {
      // salonId: this.salonId,
      razorpayOrderId: event.detail.razorpay_order_id,
      razorpayPaymentId: event.detail.razorpay_payment_id,
      signature: event.detail.razorpay_signature,
      customerName: this.form.name,
      customerEmail: this.form.email,
      phoneNumber: this.form.phone,
      amount: this.form.amount
    };

    this.scall.SavePayment(this.paymentData).subscribe(
      () => {
        console.log("Payment data has been saved successfully.");
        this.router.navigate(['userdashboard'])

      },
      (error: any) => {
        console.error("Error saving payment data:", error);
      }
    )

    // Create a POST call to the service

  }
}
// function savePayment(this: any, paymentDetail: any) {
//   return this.http.post('http://localhost:27017/savePayment', paymentDetail);
// }

