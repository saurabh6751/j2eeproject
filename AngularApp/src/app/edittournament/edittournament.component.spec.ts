import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EdittournamentComponent } from './edittournament.component';

describe('EdittournamentComponent', () => {
  let component: EdittournamentComponent;
  let fixture: ComponentFixture<EdittournamentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EdittournamentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EdittournamentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
