import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddnewmatchComponent } from './addnewmatch.component';

describe('AddnewmatchComponent', () => {
  let component: AddnewmatchComponent;
  let fixture: ComponentFixture<AddnewmatchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddnewmatchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddnewmatchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
