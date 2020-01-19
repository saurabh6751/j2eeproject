import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditnnewsComponent } from './editnnews.component';

describe('EditnnewsComponent', () => {
  let component: EditnnewsComponent;
  let fixture: ComponentFixture<EditnnewsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditnnewsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditnnewsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
