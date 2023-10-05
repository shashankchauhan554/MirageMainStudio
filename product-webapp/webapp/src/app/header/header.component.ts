import { Component } from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map, shareReplay } from 'rxjs/operators';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );

  constructor(private breakpointObserver: BreakpointObserver, private router:Router) {}

  

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
