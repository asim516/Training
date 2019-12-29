package training;

class Rectangle extends Shapes
{

    Rectangle(double l, double b)
    {
        this.l = l;
        this.b = b;
    }

    @Override
    double getArea()
    {
        return l * b;
    }
} 
