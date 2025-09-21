public class Polynomial {
    private double[] coefficients;

    public Polynomial() {
        this.coefficients = new double[]{0};
    }

    public Polynomial(double[] coefficients) {
        this.coefficients = coefficients.clone();
    }

    public Polynomial add(Polynomial other) {
        int maxLen = Math.max(this.coefficients.length, other.coefficients.length);
        double[] sum = new double[maxLen];
        for (int i = 0; i < maxLen; i += 1) {
            double a;
            if (i < this.coefficients.length) {
                a = this.coefficients[i];
            } else {
                a = 0.0;
            }
            double b;
            if (i < other.coefficients.length) {
                b = other.coefficients[i];
            } else {
                b = 0.0;
            }

            sum[i] = a + b;
        }
        return new Polynomial(sum);
    }

    public double evaluate(double x) {
        double result = 0.0;
        for (int i = 0; i < coefficients.length; i += 1) {
            result += coefficients[i] * Math.pow(x, i);
        }
        return result;
    }

    public boolean hasRoot(double x) {
        return evaluate(x) == 0.0;
    }
}
