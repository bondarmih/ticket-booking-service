/**
 * Created by bondarm on 14.01.17.
 */
import {Pipe, PipeTransform} from '@angular/core';
import {Movie} from "../movie";

@Pipe({
  name: 'filterMoviesByTag'
})

export class MovieTagPipe implements PipeTransform {
  private interval = 1000*3600*24*20; //20 days

  transform(value: Movie[], tag: string): Movie[] {
    return value.filter((movie: Movie) => {
      let today = new Date().getTime();
      let movieTime = movie.starting.getTime();
      switch (tag){
        case 'new': return ((+movieTime < +today) && (+today - +movieTime < this.interval));
        case 'soon': return (movieTime > today);
        default: return true;
      }
    })
  }
}
