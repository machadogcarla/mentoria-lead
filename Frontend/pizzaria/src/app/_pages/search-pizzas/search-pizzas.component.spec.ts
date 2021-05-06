import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchPizzasComponent } from './search-pizzas.component';

describe('SearchPizzasComponent', () => {
  let component: SearchPizzasComponent;
  let fixture: ComponentFixture<SearchPizzasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchPizzasComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchPizzasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
