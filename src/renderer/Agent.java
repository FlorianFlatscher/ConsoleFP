package renderer;

import javafx.scene.input.KeyEvent;
import map.Map;



public class Agent {
    public static double accuracy = 0.1; //The lower the mor accurate

    private double x, y;
    private double direction;

    boolean w,a,s,d = false;

    private char[][] map;

    public Agent(double x, double y, double direction, char[][] map) {
        this.x = x;
        this.y = y;
        this.direction = direction;

        this.map = map;
    }

    public String getRender(double viewingAngle, int asciiViewHeight, int asciiViewWidth) {
        if (a) {
            direction += 0.01;
        }
        if (d) {
            direction += 0.01;
        }
        char[][] stripes = new char[asciiViewWidth][asciiViewHeight];
        for (int i = 0; i < stripes.length; i++) {
            double currentAngle = direction - viewingAngle*(i/(double)asciiViewWidth) + viewingAngle/2;

            double currentX = this.x;
            double currentY = this.y;

            while (map[(int) Math.round(currentX)][(int) Math.round(currentY)] != '#') {
                currentX += Math.cos(currentAngle) * accuracy;
                currentY += Math.sin(currentAngle) * accuracy;

            }

            double distance = Math.sqrt(currentX * currentX + currentY * currentY);
            double maxDistance = Math.sqrt(map.length * map.length + map[0].length * map[0].length);

            int roofStart = (int) (asciiViewHeight*0.35 * (distance/maxDistance) + asciiViewHeight*0.05);
            int floorStart = asciiViewHeight - roofStart;

            for (int y = 0; y <= roofStart; y++) {
                stripes[i][y] = (' ');
            }
            for (int y = roofStart+1; y < floorStart; y++) {
                stripes[i][y] = (Map.mapBlock(distance, maxDistance));
            }
            for (int y = floorStart; y < asciiViewHeight; y++) {
                stripes[i][y] = (Map.mapFloor(y - floorStart, asciiViewHeight / 2.));
            }
        }
        StringBuilder asciiImage = new StringBuilder(asciiViewHeight * asciiViewWidth + asciiViewHeight);

        for (int y = 0; y < stripes[0].length; y++) {
            for (int x = 0; x < stripes.length; x++) {
                asciiImage.append(stripes[x][y]);
            }
            asciiImage.append('\n');
        }
        return asciiImage.toString();
    }

    public void keyPressed (KeyEvent e) {
        switch (e.getCode()) {
            case W: w = true; break;
            case A: a = true; break;
            case S: s = true; break;
            case D: d = true; break;
        }
    }

    public void keyReleased (KeyEvent e) {
        switch (e.getCode()) {
            case W: w = false; break;
            case A: a = false; break;
            case S: s = false; break;
            case D: d = false; break;
        }
    }
}