import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AlterarPizzaComponent } from './alterar-pizza.component';

describe('AlterarPizzaComponent', () => {
  let component: AlterarPizzaComponent;
  let fixture: ComponentFixture<AlterarPizzaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AlterarPizzaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AlterarPizzaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
