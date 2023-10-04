import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SalonGetSaloncategoryComponent } from './salon-get-saloncategory.component';

describe('SalonGetSaloncategoryComponent', () => {
  let component: SalonGetSaloncategoryComponent;
  let fixture: ComponentFixture<SalonGetSaloncategoryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SalonGetSaloncategoryComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SalonGetSaloncategoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
