package nocode.programming.pattren.behaviors;

import java.util.ArrayList;
import java.util.List;

// 23.Iterator 패턴 (Behaviors)
// ==반복자 패턴

// hasNext, nextVal

public class Iterator {
	
	static class Iterators {
		boolean hasNext() {
			return false;
		}
		int nextVal() {
			return 0;
		}
		
	}
	static class ArrayIterator extends Iterators{
		List<Integer> container;
		int pos;
		public ArrayIterator(ArrayContainer arrayContainer) {
			this.container = arrayContainer.container;
			this.pos = -1;
		}
		boolean hasNext() {
			return pos < this.container.size()-1 ? true : false;
		}
		int nextVal() {
			if(this.hasNext()) {
				this.pos +=1;
				return this.container.get(this.pos);
			}
			return -1;
		}
		
	}
	static class ArrayRevIterator extends Iterators{
		List<Integer> container;
		int pos;
		public ArrayRevIterator(ArrayContainer arrayContainer) {
			this.container = arrayContainer.container;
			this.pos = this.container.size();
		}
		boolean hasNext() {
			return -1 < this.pos-1 ? true : false;
		}
		int nextVal() {
			if(this.hasNext()) {
				this.pos -=1;
				return this.container.get(this.pos);
			}
			return -1;
		}
		
	}
	static class ArrayContainer {
		List<Integer> container;
		public ArrayContainer() {
			this.container = new ArrayList<>();
		}
		void add(int num){
			container.add(num);
		}
		Iterators getIterator(){
			return new ArrayIterator(this);
		}
		Iterators getRevIterator(){
			return new ArrayRevIterator(this);
		}
	}
	
	
	static void printByIter(Iterators it){
		while(it.hasNext()) {
			System.out.print(it.nextVal() +" ");
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		
		ArrayContainer arrayContainer = new ArrayContainer();
		arrayContainer.add(1);
		arrayContainer.add(3);
		arrayContainer.add(5);
		
		Iterators iter = arrayContainer.getIterator();
		printByIter(iter);
		
		
		printByIter(arrayContainer.getRevIterator());
		
	}
}
