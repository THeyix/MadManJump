package Main.entities;

public class Vector
{
    private double x;
    private double y;

    public Vector(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public void normalize()
    {
        double len = getLength();

        this.x /= len;
        this.y /= len;
    }

    public double getLength()
    {
        return Math.sqrt(x * x + y * y);
    }

    public double dot(Vector v)
    {
        return x * v.x + y * v.y;
    }

    public double cross(Vector v)
    {
        return y * v.x - x * v.y;
    }

    public Vector add(Vector v)
    {
        return new Vector(x + v.x, y + v.y);
    }

    public Vector sub(Vector v)
    {
        return new Vector(x - v.x, y - v.y);
    }

    public Vector div(Vector v)
    {
        return new Vector(x / v.x, y / v.y);
    }

    public Vector mul(Vector v)
    {
        return new Vector(x * v.x, y * v.y);
    }

    public boolean equals(Vector v)
    {
        return x == v.x && y == v.y;
    }
}
