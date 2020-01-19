import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditpointtableComponent } from './editpointtable.component';

describe('EditpointtableComponent', () => {
  let component: EditpointtableComponent;
  let fixture: ComponentFixture<EditpointtableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditpointtableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditpointtableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
