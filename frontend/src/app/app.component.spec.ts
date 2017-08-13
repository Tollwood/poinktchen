/* tslint:disable:no-unused-variable */

import { TestBed, async } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { AppComponent } from './app.component';
import {AlertComponent} from './_directives/alert.component';
import {AlertService} from './_services/alert.service';

describe('AppComponent', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ AppComponent, AlertComponent ],
      imports: [ RouterTestingModule ],
      providers: [AlertService]
    });
    TestBed.compileComponents();
  });

  it('should create the app', async(() => {
    let fixture = TestBed.createComponent(AppComponent);
    let app = fixture.debugElement.componentInstance;
    expect(app).toBeTruthy();
  }));

  it('should render div element with class container', async(() => {
      let fixture = TestBed.createComponent(AppComponent);
      fixture.detectChanges();
      let compiled = fixture.debugElement.nativeElement;
      expect(compiled.querySelector('.container')).toBeDefined();
  }));

  it('should create router-outlet', async(() => {
      let fixture = TestBed.createComponent(AppComponent);
      fixture.detectChanges();
      let compiled = fixture.debugElement.nativeElement;
      expect(compiled.querySelector('router-outlet')).toBeDefined();
  }));

});
