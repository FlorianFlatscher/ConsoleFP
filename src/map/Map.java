package map;

import java.io.*;

public class Map {


    private final static String charRange = "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. ";


    public static char[][] parse(String fileName) throws IOException {
        char[][] map;
        try(BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)))){
            int rows = Integer.parseInt(reader.readLine());
            int cols = Integer.parseInt(reader.readLine());
            map = new char[rows][cols];
            String line = reader.readLine();
            for(int i=0;line!=null;i++){
                map[i] = line.toCharArray();
                line = reader.readLine();
            }
        }
        return map;
    }
    public static char map(int n){
        if(n >= 70 )
            n =69;
        else if(n < 0)
            n = 0;
        return charRange.charAt(n);
    }
    public static char mapBlock(double n, double max){
        int charChoice = (int) ((n /  max) * 4);
        switch(charChoice){
            case 0: return (char) '█';
            case 1: return (char) '▓';
            case 2: return (char) '▒';
            case 3: return (char) '░';
            default: return ' ';
        }
    }

    public static char mapFloor(double n, double max){
        int charChoice = (int) ((n /  max) * 4);
        switch(charChoice){
            case 0: return  '_';
            case 1: return  '.';
            case 2: return  'x';
            case 3: return  '#';
            default: return ' ';
        }
    }

}
