import {Component, Input, OnDestroy, OnInit} from '@angular/core';
import {Character} from "./character.model";
import {CharacterService} from "./character.service";
import {Subscription} from "rxjs/Subscription";

@Component({
  selector: 'app-character',
  templateUrl: './character.component.html',
  styleUrls: ['./character.component.css']
})
export class CharacterComponent implements OnInit, OnDestroy {

  @Input() characterSearch: string;
  character: Character;
  error: string;
  characterSubscription: Subscription;

  constructor(private characterService: CharacterService) { }

  ngOnInit() {
  }

  getCharacter(character: string) {
    this.characterSubscription = this.characterService.getCharacter(character).subscribe(
      (c) => this.character = c,
      () => this.error = 'An error has occurred retrieving character ' + character
    );
  }

  ngOnDestroy() {
    this.characterSubscription.unsubscribe();
  }

}
