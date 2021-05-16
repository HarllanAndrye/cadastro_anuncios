import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'curso-angular-ts';

  constructor (private route: Router) {}

  pesquisar = () => {
    this.route.navigate(['notfound']);
  }
}
