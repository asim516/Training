package training;

class Circle extends Shapes
{


    Circle(double r)
    {
        this.r = r;
    }

    @Override
    double getArea()
    {
        return (a) * r * r;
    }
}
