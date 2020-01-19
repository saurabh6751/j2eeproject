import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminpointstableComponent } from './adminpointstable.component';

describe('AdminpointstableComponent', () => {
  let component: AdminpointstableComponent;
  let fixture: ComponentFixture<AdminpointstableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminpointstableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminpointstableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
