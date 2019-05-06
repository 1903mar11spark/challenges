import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HoodItemComponent } from './hood-item.component';

describe('HoodItemComponent', () => {
  let component: HoodItemComponent;
  let fixture: ComponentFixture<HoodItemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HoodItemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HoodItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
