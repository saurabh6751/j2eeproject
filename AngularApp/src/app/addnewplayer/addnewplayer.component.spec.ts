import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddnewplayerComponent } from './addnewplayer.component';

describe('AddnewplayerComponent', () => {
  let component: AddnewplayerComponent;
  let fixture: ComponentFixture<AddnewplayerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddnewplayerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddnewplayerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
