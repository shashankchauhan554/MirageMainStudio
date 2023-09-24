import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SalonGetbysalonidSalonComponent } from './salon-getbysalonid-salon.component';

describe('SalonGetbysalonidSalonComponent', () => {
  let component: SalonGetbysalonidSalonComponent;
  let fixture: ComponentFixture<SalonGetbysalonidSalonComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SalonGetbysalonidSalonComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SalonGetbysalonidSalonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
