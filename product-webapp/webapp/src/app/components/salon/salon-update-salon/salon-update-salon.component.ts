import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { SalonownerService } from 'src/app/services/salonowner/salonowner.service';
import { FormsModule } from '@angular/forms';
import { MatDatepickerModule } from '@angular/material/datepicker';
@Component({
  selector: 'app-salon-update-salon',
  templateUrl: './salon-update-salon.component.html',
  styleUrls: ['./salon-update-salon.component.css'],
})
export class SalonUpdateSalonComponent {
  selectedSlot: any; // or use a specific type that represents a slot
  selectedService: any; // or use a specific type that represents a service
  salonId = '';
  salonName = '';
  salonOwnerName = '';
  city = '';
  contactNumber = '';
  gstNumber = '';
  email = '';
  public getJsonValue: any[] = [];
  public getServicesValue: any[] = [];
  constructor(
    private http: HttpClient,
    private getbyIdService: SalonownerService,
    private updateSalonService: SalonownerService
  ) {}
  editSlot(slot: any) {
    this.selectedSlot = { ...slot }; // Make a copy to avoid directly modifying the original data
  }

  editService(service: any) {
    this.selectedService = { ...service }; // Make a copy to avoid directly modifying the original data
  }
  updateSlot(slot: any) {
    // console.log(slot);
    const newServiceData = {
      slotId: slot.slotId,
      slotDate: slot.slotDate,
      slotTime: slot.slotTime,
      slotStatus: slot.slotStatus,
    };
    this.updateSalonService
      .updateslot(newServiceData, this.salonId, slot.slotId)
      .then(() => {
        console.log('Slot Updated successfully');
        window.location.reload();
        this.selectedSlot = null;
      })
      .catch((error) => {
        console.error('Error deleting slot:', error);
      });
  }

  updateService(service: any) {
    // console.log(service);
    const newServiceData = {
      // salonId: this.salonId,
      serviceId: service.serviceId,
      serviceName: service.serviceName,
      price: service.price,
    };
    this.updateSalonService
      .updateservice(newServiceData, this.salonId, service.serviceId)
      .then(() => {
        console.log('Service Updated successfully');
        window.location.reload();
        this.selectedService = null;
      })
      .catch((error) => {
        console.error('Error deleting slot:', error);
      });
  }

  getbyid(id: String) {
    this.getbyIdService.getbyid(id).subscribe((data: any) => {
      console.log(data);
      this.getJsonValue = data;
      this.salonId = data.salonId;
      this.salonName = data.salonName;
      this.salonOwnerName = data.salonOwnerName;
      this.contactNumber = data.contactNumber;
      this.city = data.city;
      this.gstNumber = data.gstNumber;
      this.email = data.email;
      this.getJsonValue = data.slots;
      this.getServicesValue = data.salonServices;
    });
  }
  deleteslotower(item: any) {
    this.updateSalonService
      .deleteSlot(this.salonId, item.slotId)
      .then(() => {
        console.log('Slot deleted successfully');
        window.location.reload();
      })
      .catch((error) => {
        console.error('Error deleting slot:', error);
      });
  }
  onDeleteService(item: any) {
    this.updateSalonService
      .deleteService(this.salonId, item.serviceId)
      .then(() => {
        console.log('Service deleted successfully.');
        window.location.reload();
      })
      .catch((error) => {
        console.error('Error deleting service:', error);
      });
  }
  submitForm() {
    const newServiceData = {
      salonId: this.salonId,
      salonName: this.salonName,
      salonOwnerName: this.salonOwnerName,
      contactNumber: this.contactNumber,
      gstNumber: this.gstNumber,
      city: this.city,
      email: this.email,
      slots: this.getJsonValue,
      salonServices: this.getServicesValue,
    };
    this.updateSalonService.updatesalon(newServiceData).subscribe(
      (response: any) => {
        alert('Salon Added Succesfully');
      },
      (error) => {
        console.log('error in adding Salon', error);
        alert('Enter valid details');
      }
    );
  }
}
