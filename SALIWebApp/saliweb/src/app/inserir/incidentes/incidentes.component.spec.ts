import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IncidentesComponent } from './incidentes.component';

describe('IncidentesComponent', () => {
  let component: IncidentesComponent;
  let fixture: ComponentFixture<IncidentesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IncidentesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IncidentesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
