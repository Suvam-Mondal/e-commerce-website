import {ComponentFixture, TestBed} from '@angular/core/testing';

import {AuthComponent} from './auth.component';
import {ReactiveFormsModule} from "@angular/forms";
import {AuthService} from "../services/auth.service";


describe('AuthComponent', () => {
  let component: AuthComponent;
  let fixture: ComponentFixture<AuthComponent>;
  let authServiceStub: Partial<AuthService>; // Stub object for AuthService

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AuthComponent],
      imports: [ReactiveFormsModule], // Import ReactiveFormsModule for formGroup
      providers: [
        { provide: AuthService, useValue: authServiceStub } // Provide the stub object
      ]
    })
      .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AuthComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create the component', () => {
    expect(component).toBeTruthy();
  });

  it('form invalid when empty', () => {
    expect(component.loginForm.valid).toBeFalsy();
  });

  it('email field validity', () => {
    let email = component.loginForm.controls['email'];
    expect(email.valid).toBeFalsy();

    email.setValue('test');
    expect(email.hasError('email')).toBeTruthy();

    email.setValue('test@example.com');
    expect(email.valid).toBeTruthy();
  });

  it('password field validity', () => {
    let pwd = component.loginForm.controls['pwd'];
    expect(pwd.valid).toBeFalsy();

    pwd.setValue('12345');
    expect(pwd.valid).toBeTruthy();
  });

  it('should call onLogin method', () => {
    spyOn(component, 'onLogin');
    let button = fixture.debugElement.nativeElement.querySelector('button');
    button.click();
    expect(component.onLogin).toHaveBeenCalled();
  });
});
