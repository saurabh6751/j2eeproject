import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddnewtournamentComponent } from './addnewtournament.component';

describe('AddnewtournamentComponent', () => {
  let component: AddnewtournamentComponent;
  let fixture: ComponentFixture<AddnewtournamentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddnewtournamentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddnewtournamentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
