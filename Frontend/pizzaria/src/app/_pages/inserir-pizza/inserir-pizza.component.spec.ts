import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InserirPizzaComponent } from './inserir-pizza.component';

describe('InserirPizzaComponent', () => {
  let component: InserirPizzaComponent;
  let fixture: ComponentFixture<InserirPizzaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InserirPizzaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InserirPizzaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
