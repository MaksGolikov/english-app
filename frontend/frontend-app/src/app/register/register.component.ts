import {Component, OnInit} from '@angular/core';

import {AuthService} from '../auth/auth.service';
import {SignUpInfo} from '../auth/signup-info';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  form: any = {};
  signupInfo!: SignUpInfo;
  isSignedUp = false;
  isSignUpFailed = false;
  errorMessage = '';

  constructor(private authService: AuthService) {
  }

  ngOnInit() {
  }

  onSubmit() {
    console.log(this.form);

    this.signupInfo = new SignUpInfo(
      this.form.login,
      this.form.email,
      this.form.password,
      this.form.firstName,
      this.form.lastName);

    this.authService.signUp(this.signupInfo).subscribe(
      data => {
        console.log(this.signupInfo.role);
        console.log(data);
        this.isSignedUp = true;
        this.isSignUpFailed = false;
      },
      error => {
        console.log(error);
        console.log(this.signupInfo.role);

        this.errorMessage = error.error.message;
        this.isSignUpFailed = true;
      }
    );
  }
}
