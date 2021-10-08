package clase15;

public class Wildcards<T extends Number> {
	T num;
	
	Wildcards(T t){
		this.num = t;
	}
	
	boolean absoluteEqual(Wildcards<?> t) {
		if(Math.abs(num.doubleValue()) == Math.abs(t.num.doubleValue()))
			return true;
		return false;
	}
}
