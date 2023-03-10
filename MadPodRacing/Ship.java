package MadPodRacing;

class Ship{
    Coordinate coordinate;
    boolean canBoosted = true;
    Ship(){}
    Ship(Coordinate coordinate){
        this.coordinate = coordinate;
    }
    Ship(int x, int y){
        this.coordinate = new Coordinate(x, y);
    }
    public void setCoordinate(int x, int y){
        this.coordinate = new Coordinate(x, y);
    }
    public Coordinate getCoordinate(){
        return this.coordinate;
    }
    public boolean canBoosted(){
        return this.canBoosted;
    }
    public void switchBoostedValue (){
        this.canBoosted = false;
    }
    public Coordinate newTarget (int angle, int x, int y){
        int targetX = 0;
        int targetY = 0;
        // convert degrees to radians
        double radians = Math.toRadians(angle);
        // sin() method to get the sine value
        double sinValue = Math.sin(radians);
        double cosValue = Math.cos(radians);
        if (coordinate.getX() > x){
            targetX = (int)(x + (cosValue * 500));
        } else {
            targetX = (int)(x - (cosValue * 500));
        }
        if (coordinate.getY() > y){
            targetY = (int)(y + (sinValue * 500));
        } else {
            targetY = (int)(y - (sinValue * 500));
        }
        return new Coordinate(targetX, targetY);
    }
}
