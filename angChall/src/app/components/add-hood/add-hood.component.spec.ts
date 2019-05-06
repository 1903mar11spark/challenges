import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddHoodComponent } from './add-hood.component';

describe('AddHoodComponent', () => {
  let component: AddHoodComponent;
  let fixture: ComponentFixture<AddHoodComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddHoodComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddHoodComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
