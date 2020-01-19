import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdmintournamentComponent } from './admintournament.component';

describe('AdmintournamentComponent', () => {
  let component: AdmintournamentComponent;
  let fixture: ComponentFixture<AdmintournamentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdmintournamentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdmintournamentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
