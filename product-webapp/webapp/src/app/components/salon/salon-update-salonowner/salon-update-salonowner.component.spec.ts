import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SalonUpdateSalonownerComponent } from './salon-update-salonowner.component';

describe('SalonUpdateSalonownerComponent', () => {
  let component: SalonUpdateSalonownerComponent;
  let fixture: ComponentFixture<SalonUpdateSalonownerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SalonUpdateSalonownerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SalonUpdateSalonownerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
