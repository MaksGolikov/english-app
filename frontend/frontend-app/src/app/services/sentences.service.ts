import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {TenseInfo} from "./tense-info";
import {IdAndSentence} from "../testing/IdAndSentence";
import {RequestInfo} from "../testing/RequestInfo";

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class SentencesService {

  private theoryUrl = 'http://localhost:8080/api/theory';
  private getSentencesUrl = 'http://localhost:8080/api/testing';
  private checkUrl = 'http://localhost:8080/api/check';

  constructor(private http: HttpClient) { }

  getTheory(str:TenseInfo): Observable<any> {
    console.log("))))))))))))) "+str.tense)
    return this.http.post(this.theoryUrl, str, {responseType:"text"});
  }

  getSentences(str:TenseInfo): Observable<IdAndSentence[]> {
    console.log("))))))))))))) "+str)
    return this.http.post<IdAndSentence[]>(this.getSentencesUrl, str, httpOptions);
  }

  check(requestInfo:RequestInfo): Observable<any> {
    console.log(4);
    console.log(requestInfo.map);
    return this.http.post(this.checkUrl,  requestInfo, {responseType: "json"});
  }

}
