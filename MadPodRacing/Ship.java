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
    public Coordinate newTarget (int x, int y){
        int targetX = x - (coordinate.getX() - x);
        int targetY = y - (coordinate.getY() - y);
        return new Coordinate(targetX, targetY);
    }
}
