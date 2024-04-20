import {Pipe, PipeTransform} from '@angular/core';

@Pipe({
  name: 'categoryFilter'
})
export class CategoryFilterPipe implements PipeTransform {

  transform(value: any, category: string): any {
    return value.filter(i => i.category === category);
  }

}
