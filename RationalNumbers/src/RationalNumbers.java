public class RationalNumbers {
	public double numeratorValue;
	public double denominatorValue;
	public double rationalValue = numeratorValue / denominatorValue;
	public double numeratorValueGCD;
	public double denominatorValueGCD;
	
	public RationalNumbers(double numeratorValuePut, double demoninatorValuePut){
		numeratorValue = numeratorValuePut;
		denominatorValue = demoninatorValuePut;
		if (denominatorValue <= 0){
			throw new IllegalArgumentException("The demoninator can't be zero. Input your values again.");
		}	
		return;
	}
	
	public RationalNumbers(double numeratorValuePut){
		numeratorValue = numeratorValuePut;
		denominatorValue = 1;
	}
	
	public boolean check(double numeratorValue){
		if (denominatorValue <= 0){
			return false;
		}
		else return true;
	}
	
	public RationalNumbers add(RationalNumbers rationalTwo) {
		double numerOne = numeratorValue * rationalTwo.denominatorValue;
		double demonOne = denominatorValue * rationalTwo.denominatorValue;
		double numerTwo = rationalTwo.numeratorValue * denominatorValue;
		double numerTotal = numerOne + numerTwo;
		RationalNumbers RationalAdd = new RationalNumbers (numerTotal, demonOne);
		return RationalAdd;
	}
	
	public RationalNumbers sub(RationalNumbers rationalTwo) {
		double numerTotal;
		double numerOne = numeratorValue * rationalTwo.denominatorValue;
		double demonOne = denominatorValue * rationalTwo.denominatorValue;
		double numerTwo = rationalTwo.numeratorValue * denominatorValue;
		numerTotal = numerOne - numerTwo;
		RationalNumbers RationalSub = new RationalNumbers (numerTotal, demonOne);
		return RationalSub;
	}
	
	public RationalNumbers multiply(RationalNumbers rationalTwo) {
		double numer = numeratorValue * rationalTwo.numeratorValue;
		double demon = denominatorValue * rationalTwo.denominatorValue;
		RationalNumbers RationalMul = new RationalNumbers (numer, demon);
		return RationalMul;
	}
	
	public RationalNumbers divide(RationalNumbers rationalTwo) {
		double numer = numeratorValue * rationalTwo.denominatorValue;
		double demon = denominatorValue * rationalTwo.numeratorValue;
		RationalNumbers RationalDiv = new RationalNumbers (numer, demon);
		return RationalDiv;
	}
	
	public boolean equal(RationalNumbers rationalTwo) {
		double numerOne = numeratorValue * rationalTwo.denominatorValue;
		double numerTwo = rationalTwo.numeratorValue * denominatorValue;
		if (numerOne == numerTwo)
		{
			return true;
		}
		return false;
	}
	
	public boolean isLessThan(RationalNumbers rationalTwo) {
		double numerOne = numeratorValue * rationalTwo.denominatorValue;
		double numerTwo = rationalTwo.numeratorValue * denominatorValue;
		if (numerOne <= numerTwo)
		{
			return true;
		}
		return false;
	}
	
	public RationalNumbers simplify(RationalNumbers rationalTwo) {
		double a = numeratorValue;
		double b = denominatorValue;
		double greatestCommonDivisor = GCD(a, b);
		double simpNumerator = numeratorValue / greatestCommonDivisor;
		double simpDenominator = denominatorValue / greatestCommonDivisor;
		RationalNumbers simplifiedValue = new RationalNumbers (simpNumerator, simpDenominator);
		return simplifiedValue;

	}
	public double GCD(double a, double b) {
		if (a == 0)
		{
	        return b;
		}
	    while (b != 0) {
	        if (a > b)
	            a = a - b;
	        else
	            b = b - a;
	    }
	    return a;
	}
	
	public String toString() {
		return numeratorValue + "/" + denominatorValue;
	}
}
