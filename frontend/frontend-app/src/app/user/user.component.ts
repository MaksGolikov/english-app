import { Component, OnInit } from '@angular/core';

import { UserService } from '../services/user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  board!: string;
  errorMessage!: string;

  constructor(private userService: UserService) { }

  ngOnInit() {
    console.log('on init');
    console.log(this.board);
    this.userService.getUserStatistic().subscribe(
      data => {
        this.board = data;
        console.log(this.board);
      },
      error => {
        console.log(this.errorMessage);
        console.log(this.board);
        this.errorMessage = `${error.status}: ${JSON.parse(error.error).message}`;
      }
    );
  }

}
