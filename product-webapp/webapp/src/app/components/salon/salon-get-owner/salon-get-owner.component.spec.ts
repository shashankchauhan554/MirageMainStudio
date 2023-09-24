import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SalonGetOwnerComponent } from './salon-get-owner.component';

describe('HotelGetOwnerComponent', () => {
  let component: SalonGetOwnerComponent;
  let fixture: ComponentFixture<SalonGetOwnerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SalonGetOwnerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SalonGetOwnerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
