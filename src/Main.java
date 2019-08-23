public class Main {

    public static void main(String[] args) {
        Robot robot = new Robot(0,0, Direction.DOWN);
        moveRobot(robot, -10, 20);

        System.out.println(robot.getX() + " " + robot.getY());
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public static class Robot {
        int x;
        int y;
        Direction dir;

        public Robot (int x, int y, Direction dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        public Direction getDirection() {return dir;}

        public int getX() {return x;}

        public int getY() {return y;}

        public void turnLeft() {
            if      (dir == Direction.UP)    {dir = Direction.LEFT;}
            else if (dir == Direction.DOWN)  {dir = Direction.RIGHT;}
            else if (dir == Direction.LEFT)  {dir = Direction.DOWN;}
            else if (dir == Direction.RIGHT) {dir = Direction.UP;}
        }

        public void turnRight() {
            if      (dir == Direction.UP)    {dir = Direction.RIGHT;}
            else if (dir == Direction.DOWN)  {dir = Direction.LEFT;}
            else if (dir == Direction.LEFT)  {dir = Direction.UP;}
            else if (dir == Direction.RIGHT) {dir = Direction.DOWN;}
        }

        public void stepForward() {
            if (dir == Direction.UP)    {y++;}
            if (dir == Direction.DOWN)  {y--;}
            if (dir == Direction.LEFT)  {x--;}
            if (dir == Direction.RIGHT) {x++;}
        }
    }

    public static void moveRobot(Robot robot, int toX, int toY) {
        if (robot.getX() == toX && robot.getY() == toY){
            return;
        }

        if (robot.getX() == toX){
            moveY(robot, toY);
            return;
        }

        if (robot.getY() == toY){
            moveX(robot, toX);
            return;
        }

        while (robot.getX() != toX || robot.getY() != toY){
            if (robot.getY() < toY){
                turnUP(robot);
                robot.stepForward();
            }

            else {
                turnDOWN(robot);
                robot.stepForward();
            }

            if (robot.getX() < toX){
                turnRIGHT(robot);
                robot.stepForward();
            }

            else {
                turnLEFT(robot);
                robot.stepForward();
            }
        }

        moveRobot(robot, toX, toY);
    }

    public static void moveY(Robot robot, int toY){
        if (robot.getY() < toY){
            turnUP(robot);

            while (robot.getY() != toY){
                robot.stepForward();
            }
        }
        else {
            turnDOWN(robot);

            while (robot.getY() != toY){
                robot.stepForward();
            }
        }
    }

    public static void moveX(Robot robot, int toX){
        if (robot.getX() < toX){
            turnRIGHT(robot);

            while (robot.getX() != toX){
                robot.stepForward();
            }
        }

        else {
            turnLEFT(robot);

            while (robot.getX() != toX){
                robot.stepForward();
            }
        }
    }

    public static void turnUP(Robot robot){
        if (robot.getDirection() == Direction.DOWN){
            robot.turnLeft();
        }

        if (robot.getDirection() == Direction.RIGHT){
            robot.turnLeft();
        }

        if (robot.getDirection() == Direction.LEFT){
            robot.turnRight();
        }
    }

    public static void turnDOWN(Robot robot){
        if (robot.getDirection() == Direction.UP){
            robot.turnRight();
        }

        if (robot.getDirection() == Direction.RIGHT){
            robot.turnRight();
        }

        if (robot.getDirection() == Direction.LEFT){
            robot.turnLeft();
        }
    }

    public static void turnLEFT(Robot robot){
        if (robot.getDirection() == Direction.RIGHT){
            robot.turnRight();
        }

        if (robot.getDirection() == Direction.DOWN){
            robot.turnRight();
        }

        if (robot.getDirection() == Direction.UP){
            robot.turnLeft();
        }
    }

    public static void turnRIGHT(Robot robot){
        if (robot.getDirection() == Direction.LEFT){
            robot.turnLeft();
        }

        if (robot.getDirection() == Direction.DOWN){
            robot.turnLeft();
        }

        if (robot.getDirection() == Direction.UP){
            robot.turnRight();
        }
    }
}
