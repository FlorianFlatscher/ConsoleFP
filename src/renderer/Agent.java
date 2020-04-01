package renderer;

import Map.Map;

public class Agent {
    public static double accuracy = 0.1; //The lower the mor accurate

    private double x, y;
    private double direction;

    private char[][] map;

    public Agent(double x, double y, double direction, char[][] map) {
        this.x = x;
        this.y = y;
        this.direction = direction;

        this.map = map;
    }

    public String getRender(double viewingAngle, int asciiViewHeight, int asciiViewWidth) {
        String[] stripes = new String[asciiViewWidth];
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

            StringBuilder stringBuilder = new StringBuilder(asciiViewHeight);
            for (int y = 0; y <= roofStart; y++) {
                stringBuilder.append(Map.map(100));
            }
            for (int y = roofStart+1; y < floorStart; y++) {
                stringBuilder.append(Map.map(1));
            }
            for (int y = floorStart; y < asciiViewHeight; y++) {
                stringBuilder.append(Map.map(1));
            }
        }
    }
}