import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Character} from "./character.model";
import {Observable} from "rxjs/Observable";

@Injectable()
export class CharacterService {
  private baseUrl: string = "http://localhost:8081/batman/api/v1";

  constructor(private http: HttpClient) { }

  getCharacter(characterName: string): Observable<Character> {
    return this.http.get<Character>(this.baseUrl + "/character/" + characterName);
  }

}
