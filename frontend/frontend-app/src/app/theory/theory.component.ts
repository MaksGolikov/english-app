import {Component, OnInit} from '@angular/core';
import {SentencesService} from "../services/sentences.service";
import {TenseInfo} from "../services/tense-info";
import {TenseStorageService} from "../auth/tense-storage-service";

@Component({
  selector: 'app-theory',
  templateUrl: './theory.component.html',
  styleUrls: ['./theory.component.css']
})


export class TheoryComponent implements OnInit {

  obj!: string;
  errorMessage! : string;
  html !: string;
  tenseInfo!: TenseInfo;

  isNull : boolean = true;
  isNotNull! : boolean ;

  constructor(private sentencesService: SentencesService, private tenseStorageService : TenseStorageService) {
  }

  ngOnInit(): void {
    console.log('on init');
  }


  setTense(str:string){
    this.tenseInfo = new TenseInfo(str);
    this.tenseStorageService.saveTense(str);
    console.log("******** "+ str);

    this.sentencesService.getTheory(this.tenseInfo).subscribe(
      data => {
        this.obj = data;
        let arrayOfStrings = this.obj.split('\n');
        this.html="<p>"+arrayOfStrings.join("</p><p>")+"</p>";

        this.isNull = false;
        this.isNotNull = true;
        },
      error => {
        console.log(this.errorMessage);
        this.errorMessage = `${error.status}: ${JSON.parse(error.error).message}`;
      }
    );
  }

  toTest(){

  }

}


