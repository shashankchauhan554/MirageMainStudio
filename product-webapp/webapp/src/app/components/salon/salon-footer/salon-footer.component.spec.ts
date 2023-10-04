import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SalonFooterComponent } from './salon-footer.component';

describe('HotelFooterComponent', () => {
  let component: SalonFooterComponent;
  let fixture: ComponentFixture<SalonFooterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SalonFooterComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SalonFooterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
