import { SortProductsPipe } from './sort-products.pipe';

describe('SortPipe', () => {
  it('create an instance', () => {
    const pipe = new SortProductsPipe();
    expect(pipe).toBeTruthy();
  });
});
