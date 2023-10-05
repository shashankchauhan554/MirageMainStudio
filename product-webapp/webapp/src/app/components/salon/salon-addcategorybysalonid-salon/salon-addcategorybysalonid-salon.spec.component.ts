import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SalonAddcategorybysalonidSalonComponent } from './salon-addcategorybysalonid-salon.component';

describe('SalonAddcategorybysalonidSalonComponent', () => {
  let component: SalonAddcategorybysalonidSalonComponent;
  let fixture: ComponentFixture<SalonAddcategorybysalonidSalonComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SalonAddcategorybysalonidSalonComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SalonAddcategorybysalonidSalonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
