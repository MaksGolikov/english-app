import { Injectable } from '@angular/core';


const TENSE = 'Tense';

@Injectable({
  providedIn: 'root'
})

export class TenseStorageService {

  constructor() { }

  public saveTense(tense: string) {
    window.sessionStorage.setItem(TENSE, tense);
  }

  public getTense(): string {
    return sessionStorage.getItem(TENSE)!;
  }

  public removeTense() {
    window.sessionStorage.removeItem(TENSE);
  }

}
