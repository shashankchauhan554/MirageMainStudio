import { Component, OnInit } from '@angular/core';
import { AppointmentService } from '../appointment.service'; // Import your service

@Component({
  selector: 'app-appointment-list',
  templateUrl: './appointment-list.component.html',
  styleUrls: ['./appointment-list.component.css']
})
export class AppointmentListComponent implements OnInit {
  appointments: any[] = [];
  displayedColumns: string[] = ['customerName', 'appointmentDate', 'startTime', 'endTime'];

  constructor(private bookingService: AppointmentService) {}

  ngOnInit() {
    this.loadAppointments();
  }

  loadAppointments() {
    this.bookingService.getAllAppointments().subscribe(
      (data: any) => {
        this.appointments = data;
      },
      (error) => {
        console.error('Error loading appointments:', error);
        // Handle error, display a message, or perform other actions.
      }
    );
  }
}
