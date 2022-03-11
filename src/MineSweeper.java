import java.util.Scanner;

public class MineSweeper {

    public static void main(String[] args) {

        int dimX;
        int dimY;
        int bombCount;


        Scanner inpucik = new Scanner(System.in);

        System.out.printf("X: ");
        dimX = inpucik.nextInt();
        System.out.printf("Y: ");
        dimY = inpucik.nextInt();
        System.out.printf("How many bombs?: ");
        bombCount = inpucik.nextInt();
        boolean bomby[][] = new boolean[dimX][dimY];
        int rand1;
        int rand2;



        Tile[][] arr;

        arr = new Tile[dimX][dimY];

        for (int i = 0; i < dimY; i++) {
            for (int j = 0; j < dimX; j++) {
                arr[j][i] = new Tile();

            }
        }

        for (int i = 0; i <= bombCount; i++) {
            rand1 = (int)(Math.random()*dimX);
            rand2 = (int)(Math.random()*dimY);
            arr[rand1][rand2].setBombed();
        }

        for (int i = 0; i < dimY; i++) {
            for (int j = 0; j < dimX; j++) {
                System.out.printf(arr[i][j].getBoardStatus()+" ");

            }
            System.out.println();
        }






/*
            Board plansza = new Board(10,5, 8);

            plansza.createBoard();
            int randomNum = (int)(Math.random()*2);
            System.out.println(randomNum);
*/

        }

    }
