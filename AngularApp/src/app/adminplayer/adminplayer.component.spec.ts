import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminplayerComponent } from './adminplayer.component';

describe('AdminplayerComponent', () => {
  let component: AdminplayerComponent;
  let fixture: ComponentFixture<AdminplayerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminplayerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminplayerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
