package training;

class Square  extends Shapes
{

    Square(double s)
    {
        this.s = s;
    }

    @Override
    double getArea()
    {
        return s * s;
    }
}
