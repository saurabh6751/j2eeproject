import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminmatchComponent } from './adminmatch.component';

describe('AdminmatchComponent', () => {
  let component: AdminmatchComponent;
  let fixture: ComponentFixture<AdminmatchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminmatchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminmatchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
