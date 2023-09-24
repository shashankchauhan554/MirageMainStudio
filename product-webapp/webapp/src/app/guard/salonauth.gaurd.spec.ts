import { TestBed } from '@angular/core/testing';

import { SalonauthGuard } from './salonauth.guard';

describe('SalonauthGuard', () => {
  let guard: SalonauthGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(SalonauthGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
