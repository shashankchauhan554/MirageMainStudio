import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SalonAddsalonbyowneridSalonComponent } from './salon-addsalonbyownerid-salon.component';

describe('SalonAddsalonbyowneridSalonComponent', () => {
  let component: SalonAddsalonbyowneridSalonComponent;
  let fixture: ComponentFixture<SalonAddsalonbyowneridSalonComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SalonAddsalonbyowneridSalonComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SalonAddsalonbyowneridSalonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
