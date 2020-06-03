import java.lang.*;
import java.lang.reflect.Method;

public class Rational implements Comparable<Rational>{
    
  private int numerator;
  private int denominator;

  public Rational(int numerator) {
    this.numerator = numerator;
    this.denominator = 1;
  }

  public Rational(int numerator, int denominator) {
    this.numerator = numerator;
    this.denominator = denominator;
    
  }
  public int getNumerator() {
    return numerator;
  }
  public int getDenominator() {
    return denominator;
  }
  
  public Rational plus(Rational other) {
    int num = other.numerator + this.numerator;
    int denom = other.denominator + this.denominator;
    Rational instanceSum = new Rational(num,denom);
    return instanceSum;
  }

  public static Rational plus(Rational a, Rational b) {  
    int newNum = (a.numerator*b.denominator)+(a.denominator*b.numerator);
    int newDenom = a.denominator*b.denominator;
    Rational totalSum = new Rational(newNum,newDenom);
    return totalSum;

  }

  private void reduce() {
    int newSum;
    int newGcd = gcd(this.numerator,this.denominator);
    if(this.numerator%this.denominator!=1){
        this.numerator = this.numerator/newGcd;
        this.denominator = this.denominator/newGcd;
    }
    newSum = this.numerator/this.denominator;
  }

    private static int gcd(int a, int b) {
        if(a>0){
            a = -a;
        }
        if(b>0){
            b = -b;
        }
        while(a!=b){
            if(a>b){
                a = a - b;
            }
            else{
                b = b - a;
            }
        }
        return a;
    }

  public int compareTo(Rational other){
    int a = this.numerator*other.denominator;
    int b = this.denominator*other.numerator;
    if(a<b){
        return -1;
    }
    if(a>b){
        return 1;
    }
    return 0;
  }

  public boolean equals(Rational other) {
    if(other==null){
        return false;
    }
    if(getClass()!=other.getClass()){
        return false;
    }
    Rational o = (Rational) other;
    return compareTo(o)==0;
  }

  public String toString() {
    String result;
    if (denominator == 1) {
        result = Integer.toString(numerator);
    } else {
        result = Integer.toString(numerator)+"/"+Integer.toString(denominator);
    }
    return result;
  }
}
