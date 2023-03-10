package MadPodRacing;

import java.util.Scanner;
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Ship myPod = new Ship();
        Ship enemyPod = new Ship();
        int previousDist = 0;
        // game loop
        while (true) {
            int x = in.nextInt();
            int y = in.nextInt();
            int nextCheckpointX = in.nextInt(); // x position of the next check point
            int nextCheckpointY = in.nextInt(); // y position of the next check point
            int nextCheckpointDist = in.nextInt(); // distance to the next checkpoint
            int nextCheckpointAngle = in.nextInt(); // angle between your pod orientation and the direction of the next checkpoint
            int opponentX = in.nextInt();
            int opponentY = in.nextInt();

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            System.err.println(nextCheckpointAngle + "@ " + nextCheckpointDist + "m");
            System.err.println(nextCheckpointX + " " + nextCheckpointY);

            String command;
            int thrust = 0;
            myPod.setCoordinate(x, y);
            enemyPod.setCoordinate(opponentX, opponentY);
            if (nextCheckpointAngle > 90 || nextCheckpointAngle < -90){
                thrust = 0;
            } else {
                // thrust = (int)Math.ceil(100.0 * (90 - Math.abs(nextCheckpointAngle)) / 90);
                thrust = 100;
            }
            Coordinate newTarget = new Coordinate(nextCheckpointX, nextCheckpointY);
            if (nextCheckpointDist < 500){
                int newTargetX = nextCheckpointX - (myPod.getCoordinate().getX() - nextCheckpointX);
                int newTargetY = nextCheckpointY - (myPod.getCoordinate().getY() - nextCheckpointY);
            } else {
                newTarget = myPod.newTarget(nextCheckpointAngle, nextCheckpointX, nextCheckpointY);
            }
            if (myPod.canBoosted() && nextCheckpointAngle < 5 && nextCheckpointDist > 5000){
                myPod.switchBoostedValue();
                command = newTarget.toString() + " " + "BOOST";
            } else {
                command =  newTarget.toString() + " " + thrust;
            }
            // You have to output the target position
            // followed by the power (0 <= thrust <= 100)
            // i.e.: "x y thrust"
            System.out.println(command);
        }
    }
}