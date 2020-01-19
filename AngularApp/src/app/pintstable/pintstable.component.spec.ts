import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PintstableComponent } from './pintstable.component';

describe('PintstableComponent', () => {
  let component: PintstableComponent;
  let fixture: ComponentFixture<PintstableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PintstableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PintstableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
