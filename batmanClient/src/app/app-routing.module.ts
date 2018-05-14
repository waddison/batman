import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from "@angular/router";
import { CharacterComponent } from "./character/character.component";

const routes: Routes = [
  { path: '', redirectTo: 'character', pathMatch: 'full' },
  { path: 'character', component: CharacterComponent }
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  declarations: [],
  exports: [RouterModule]
})
export class AppRoutingModule { }
