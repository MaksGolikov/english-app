import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private statisticUrl = 'http://localhost:8080/api/statistic';

  constructor(private http: HttpClient) { }

  getUserStatistic(): Observable<any> {
    return this.http.get(this.statisticUrl, { responseType: 'json' });
  }
}
