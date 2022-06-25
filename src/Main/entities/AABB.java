package Main.entities;

public class AABB {
    public float x;
    public float y;
    public float X;
    public float Y;
    public float width;
    public float height;

    public AABB(float x, float y, float w, float h)
    {
        this.x = x;
        this.y = y;
        this.X = x + w;
        this.Y = y + h;
        this.width = w;
        this.height = h;
    }

    public boolean checkCollidePoint(float px, float py)
    {
        if (px > this.x && px < this.X && py > this.y && py < this.Y)
            return true;
        else
            return false;
    }

    public boolean[] checkCollideBox(AABB aabb)
    {
        boolean rlb = this.checkCollidePoint(aabb.x, aabb.y);
        boolean rrb = this.checkCollidePoint(aabb.X, aabb.y);
        boolean rlt = this.checkCollidePoint(aabb.x, aabb.Y);
        boolean rrt = this.checkCollidePoint(aabb.X, aabb.Y);

        boolean[] res = new boolean[]{
                rlb || rrb || rlt || rrt,
                rlb,
                rrb,
                rlt,
                rrt,
        };

        return res;
    }

    public void move(float dx, float dy)
    {
        this.x += dx;
        this.y += dy;
        this.X += dx;
        this.Y += dy;
    }
}