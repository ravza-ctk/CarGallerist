import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Gallerist } from './gallerist/gallerist';

describe('Gallerist', () => {
  let component: Gallerist;
  let fixture: ComponentFixture<Gallerist>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Gallerist]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Gallerist);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
