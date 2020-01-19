import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminstartpageComponent } from './adminstartpage.component';

describe('AdminstartpageComponent', () => {
  let component: AdminstartpageComponent;
  let fixture: ComponentFixture<AdminstartpageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminstartpageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminstartpageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
