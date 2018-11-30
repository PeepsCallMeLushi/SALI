import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarindiComponent } from './listarindi.component';

describe('ListarindiComponent', () => {
  let component: ListarindiComponent;
  let fixture: ComponentFixture<ListarindiComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListarindiComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListarindiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
