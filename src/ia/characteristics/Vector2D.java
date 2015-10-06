package ia.characteristics;

/**
 * Default Template. Information about thus class should go here
 * Created by mauriciog on 10/1/15 for Artificial Intelligence
 */
public class Vector2D {

    public static final int CLOCKWISE = 0, ANTICLOCKWISE = 1;

    private static final double
            MIN_DOUBLE = 0,
            EPSILON = Double.longBitsToDouble(971l << 52) ;


    public double x, y;

    public Vector2D() {
        x = 0;
        y = 0;
    }
    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setZero() {
        x = 0;
        y = 0;
    }

    public boolean isZero() {
        return (x*x + y*y) < EPSILON;
    }

    public double getLength() {
        return Math.sqrt(x * x + y * y);
    }

    public double getLengthSqr() {
        return (x*x + y*y);
    }

    public double getDotProduct(Vector2D v2) {
        return (x*v2.x + y*v2.y);
    }

    public int getSign(Vector2D v2) {
        if (x*v2.x > y*v2.y) {
            return ANTICLOCKWISE;
        }
        return CLOCKWISE;
    }

    public Vector2D getPerpendicular(Vector2D v2) {
        return new Vector2D(-v2.y, v2.x);
    }

    public double getDistance(Vector2D v2) {
        return Math.sqrt( getDistanceSqr(v2) );
    }

    public double getDistanceSqr(Vector2D v2) {
        final double xSeparation = v2.x - x;
        final double ySeparation = v2.y - y;
        return (xSeparation*xSeparation + ySeparation*ySeparation);
    }

    public void add(final double constant) {
        x += constant;
        y += constant;
    }

    public void subtract(final double constant) {
        x -= constant;
        y -= constant;
    }

    public void multiply(final double scalar) {
        x *= scalar;
        y *= scalar;
    }

    public void divide(final double scalar) {
        x /= scalar;
        y /= scalar;
    }

    public void truncate(final double max) {
        if (getLength() > max) {
            normalize();
        }
    }

    public void reflect(final Vector2D v2) {
        x += 2.0 * getDotProduct(v2) * v2.getReverse().x;
        y += 2.0 * getDotProduct(v2) * v2.getReverse().y;
    }

    public Vector2D getReverse() {
        return new Vector2D(-x, -y);
    }

    private void normalize() {
        final double vectorLength = getLength();
        if (vectorLength > EPSILON) {
            x /= vectorLength;
            y /= vectorLength;
        }
    }

    public static Vector2D add(final Vector2D v2, final double constant) {
        return new Vector2D(v2.x+constant, v2.y+constant);
    }

    public static Vector2D subtract(final Vector2D v2, final double constant) {
        return new Vector2D(v2.x-constant, v2.y-constant);
    }

    public static Vector2D multiply(final Vector2D v2, final double scalar) {
        return new Vector2D(v2.x*scalar, v2.y*scalar);
    }

    public static Vector2D divide(final Vector2D v2, final double scalar) {
        return new Vector2D(v2.x/scalar, v2.y/scalar);
    }
}
