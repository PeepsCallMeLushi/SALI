import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListargeralComponent } from './listargeral.component';

describe('ListargeralComponent', () => {
  let component: ListargeralComponent;
  let fixture: ComponentFixture<ListargeralComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListargeralComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListargeralComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
