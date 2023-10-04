import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SalonUpdateSalonComponent } from './salon-update-salon.component';

describe('SalonUpdateSalonComponent', () => {
  let component: SalonUpdateSalonComponent;
  let fixture: ComponentFixture<SalonUpdateSalonComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SalonUpdateSalonComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SalonUpdateSalonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
