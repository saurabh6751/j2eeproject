import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TornamentmatchesComponent } from './tornamentmatches.component';

describe('TornamentmatchesComponent', () => {
  let component: TornamentmatchesComponent;
  let fixture: ComponentFixture<TornamentmatchesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TornamentmatchesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TornamentmatchesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
