import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SalonAddSalonownerComponent } from './salon-add-salonowner.component';

describe('SalonAddSalonownerComponent', () => {
  let component: SalonAddSalonownerComponent;
  let fixture: ComponentFixture<SalonAddSalonownerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SalonAddSalonownerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SalonAddSalonownerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
