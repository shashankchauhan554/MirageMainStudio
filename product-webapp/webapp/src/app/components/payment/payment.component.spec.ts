import { TestBed, async } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { PaymentComponent } from './payment.component';

describe('PaymentComponent', () => {
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        RouterTestingModule
      ],
      declarations: [
        PaymentComponent
      ],
    }).compileComponents();
  }));

  it('should create the app', () => {
    const fixture = TestBed.createComponent(PaymentComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app).toBeTruthy();
  });

  it(`should have as title 'demo'`, () => {
    const fixture = TestBed.createComponent(PaymentComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.title).toEqual('demo');
  });

  it('should render title in a h1 tag', () => {
    const fixture = TestBed.createComponent(PaymentComponent);
    fixture.detectChanges();
    const compiled = fixture.debugElement.nativeElement;
    expect(compiled.querySelector('h1').textContent).toContain('Welcome to demo!');
  });
});
