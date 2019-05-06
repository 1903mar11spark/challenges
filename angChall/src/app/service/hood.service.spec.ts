import { TestBed } from '@angular/core/testing';

import { HoodService } from './hood.service';

describe('HoodService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: HoodService = TestBed.get(HoodService);
    expect(service).toBeTruthy();
  });
});
