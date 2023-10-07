
import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'webapp';

  constructor( private router: Router,) { }

  ngOnInit(): void {
  }

  isActiveRoute(routePath: string): boolean {
    return this.router.isActive(routePath, true);
  }

}

//   constructor( private router: Router) { }

//   ngOnInit(): void {
//   }

//   isActiveRoute(routePath: string): boolean {
//     return this.router.isActive(routePath, true);
//   }
// }
