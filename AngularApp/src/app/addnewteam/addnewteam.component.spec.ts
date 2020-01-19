import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddnewteamComponent } from './addnewteam.component';

describe('AddnewteamComponent', () => {
  let component: AddnewteamComponent;
  let fixture: ComponentFixture<AddnewteamComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddnewteamComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddnewteamComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
