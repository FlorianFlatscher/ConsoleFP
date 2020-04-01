package renderer;

public class Agent {
    private double x, y;
    private double direction;

    private char[][] map;

    public Agent(double x, double y, double direction, char[][] map) {
        this.x = x;
        this.y = y;
        this.direction = direction;

        this.map = map;
    }

    public String getRender(int viewHeight, int viewWidth) {
        String[] stripes = new String[viewWidth];
        for (int i = 0; i < stripes.length; i++) {

        }
    }
}
