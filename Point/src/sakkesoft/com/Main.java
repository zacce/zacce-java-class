package sakkesoft.com;

public class Main {

    public static void main(String[] args) {
        Point first = new Point(6,5);
        Point second = new Point(3,1);
        System.out.println("distance(0,0)= "+first.distance());
        System.out.println("distance (second) "+first.distance(second));
        System.out.println("distance(2,2) "+first.distance(2,2));
        Point point = new Point();
        System.out.println("distance()= "+point.distance());

    }
    public static class Point{
        private double x;
        private double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public Point() {

        }

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }
        public double distance(Point second){
            return 1;
        }

        public double distance(double x,double y){
            return 2;
        }
        public double distance(){
            
        }

    }
}