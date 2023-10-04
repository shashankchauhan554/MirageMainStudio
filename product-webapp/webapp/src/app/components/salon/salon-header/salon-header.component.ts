import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-salon-header',
  templateUrl: './salon-header.component.html',
  styleUrls: ['./salon-header.component.css']
})
export class SalonHeaderComponent {

  constructor( private router: Router) { }

  ngOnInit(): void {
  }

  isActiveRoute(routePath: string): boolean {
    return this.router.isActive(routePath, true);
  }


  navigateToAdmin(): any {


    sessionStorage.removeItem('bearerToken');
    this.router.navigate(['/admin-content']) ;

  }
  navigateToCustomer(): any {

    sessionStorage.removeItem('bearerToken');
    this.router.navigate(['/customer-content']) ;

  }

  onlogout() {

    sessionStorage.removeItem('bearerToken');
    this.router.navigate(['/salon-content']);
  }
}

