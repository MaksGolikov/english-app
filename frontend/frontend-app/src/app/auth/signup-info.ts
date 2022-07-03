export class SignUpInfo {
  login: string;
  email: string;
  role: string;
  firstName : string;
  lastName : string;
  password: string;

  constructor(login: string, email: string, password: string, firstName : string, lastName: string) {
    this.login = login;
    this.email = email;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.role = 'user';
  }
}
