import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SalonHomepageComponent } from './salon-homepage.component';

describe('SalonHomepageComponent', () => {
  let component: SalonHomepageComponent;
  let fixture: ComponentFixture<SalonHomepageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SalonHomepageComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SalonHomepageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
