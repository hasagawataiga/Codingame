package MadPodRacing;

class Coordinate{
    int x;
    int y;
    Coordinate(){}
    Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){return this.x;}
    public int getY(){return this.y;}
    public void setX(int x){this.x = x;}
    public void setY(int y){this.y = y;}
    public String toString(){
        String str = x + " " + y;
        return str;
    }
    public double distanceFrom (Coordinate target){
        int targetX = target.getX();
        int targetY = target.getY();
        double distance = (double)(Math.abs((x - targetX) * (x - targetX)) + Math.abs((y - targetY) * (y - targetY)));
        return Math.sqrt(distance);
    }
}
