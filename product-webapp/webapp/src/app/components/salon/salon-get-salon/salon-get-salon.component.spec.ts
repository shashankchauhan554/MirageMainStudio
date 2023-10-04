import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SalonGetSalonComponent } from './salon-get-salon.component';

describe('SalonGetSalonComponent', () => {
  let component: SalonGetSalonComponent;
  let fixture: ComponentFixture<SalonGetSalonComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SalonGetSalonComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SalonGetSalonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
