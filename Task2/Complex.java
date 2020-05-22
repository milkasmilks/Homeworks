package Task2;

import java.util.Objects;

public class Complex implements Number {
    private double re;
    private double im;

    public Complex() {
        this.re = 0;
        this.im = 0;
    }

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public void setRe(double re) {
        this.re = re;
    }

    public double getIm() {
        return im;
    }

    public void setIm(double im) {
        this.im = im;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Complex complex = (Complex) o;
        return Double.compare(complex.re, re) == 0 &&
                Double.compare(complex.im, im) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(re, im);
    }

    @Override
    public String toString() {
        return "(" + re + " + " + im + "i)";
    }

    public Complex sum(Complex z) {
        Complex sum = new Complex(this.re + z.re, this.im + z.im);
        return sum;
    }

    public Complex multiply(Complex z) {
        Complex mult = new Complex();
        mult.re = this.re * z.re - this.im * z.im;
        mult.im = this.im * z.re + this.re * z.im;
        return mult;
    }

    public Complex diff(Complex z) {
        Complex diff = new Complex(this.re - z.re, this.im - z.im);
        return diff;
    }

    public Complex divide(Complex z) {
        Complex partic = new Complex();
        double denom = z.re * z.re + z.im * z.im;
        if (denom != 0) {
            partic.re = (this.re * z.re + this.im * z.im) / denom;
            partic.im = (this.im * z.re - this.re * z.im) / denom;
            //this.mult(mult.re, mult.im);
            //partic.re = (mult.re) / denom;
            //System.out.println(partic.re);
            //partic.im = (this.im * z.re - this.re * z.im) / denom;
            return partic;
        }
        else {
            throw new ArithmeticException("There was a division by zero!");
        }
    }

    @Override
    public Object sum(Object o) {
        return null;
    }

    @Override
    public Object multiply(Object o) {
        return null;
    }

    @Override
    public Object divide(Object o) {
        return null;
    }

    @Override
    public Object diff(Object o) {
        return null;
    }
}
