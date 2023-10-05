import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-success',
  templateUrl: './success.component.html',
  styleUrls: ['./success.component.css']
})
export class SuccessComponent {
@Input() data:any

constructor(private route:Router){}

redirect_to_payment(){
this.route.navigate(['payment'])
}

}
