import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { SalonownerService } from 'src/app/services/salonowner/salonowner.service';

@Component({
  selector: 'app-salon-details',
  templateUrl: './salon-details.component.html',
  styleUrls: ['./salon-details.component.css'],
})
export class SalonDetailsComponent {
  salonId: any;
  salonName: any;
  salonOwnerName: any;
  city: any;
  contactNumber: any;
  gstNumber: any;
  email: any;
  image:any;
  salonServices: any;
  slots:any;
  totalPrice = 0;
  bookedslot:any;
  bookedservices:any;


  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private getAllService: SalonownerService
  ) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe((params) => {
      this.salonId = params.get('id');
      this.getAllService
        .getbyownerid(params.get('id'))
        .subscribe((data: any) => {
          this.salonName = data.salonName;
          this.salonOwnerName = data.salonOwnerName;
          this.city = data.city;
          this.contactNumber = data.contactNumber;
          this.gstNumber = data.gstNumber;
          this.email = data.email;
          this.image = data.image;
          this.salonServices = data.salonServices;
          this.slots= data.slots;
          console.log(this.slots);
          this.salonServices.map((obj: any) => {
            obj.selected = false;
          });
          this.slots.map((obj:any)=> { 
            obj.selected= false;
          })
        });
        
    });
  }
  updateTotalPrice() {
    this.totalPrice = this.salonServices
      .filter((service: any) => service.selected)
      .reduce((total: any, service: any) => total + service.price, 0);
    
    this.bookedslot = this.slots
      .filter((slot: any)=> slot.selected)

      this.bookedservices = this.salonServices
      .filter((service: any) => service.selected)
 

      
    
  }


  info(){
    console.log(this.bookedslot);
    console.log(this.bookedservices);
    console.log(this.totalPrice);
    console.log(this.salonName);
    console.log(this.email);
    console.log(this.bookedservices[0].serviceName)
    console.log(this.bookedslot[0]);
    this.getAllService.totalPrice=this.totalPrice;
    this.getAllService.salonName=this.salonName;
    this.getAllService.email=this.email;
    this.getAllService.selectedSalonServices=this.bookedservices;
    this.getAllService.selectedSlots=this.bookedslot;
    // this.getAllService.setSalonServices(this.bookedservices);
    // this.getAllService.setSlots(this.bookedslot);
    this.router.navigate(['booking-form'])
 }

}
