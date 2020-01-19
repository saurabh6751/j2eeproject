import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddpintstableComponent } from './addpintstable.component';

describe('AddpintstableComponent', () => {
  let component: AddpintstableComponent;
  let fixture: ComponentFixture<AddpintstableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddpintstableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddpintstableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
