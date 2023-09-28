import { TestBed } from '@angular/core/testing';

import { SalonownerService } from './salonowner.service';

describe('SalonownerService', () => {
  let service: SalonownerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SalonownerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
