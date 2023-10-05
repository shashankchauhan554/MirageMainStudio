import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SalonAddOwnerComponent } from './salon-add-owner.component';

describe('SalonAddOwnerComponent', () => {
  let component: SalonAddOwnerComponent;
  let fixture: ComponentFixture<SalonAddOwnerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SalonAddOwnerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SalonAddOwnerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
