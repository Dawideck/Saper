import java.util.Scanner;

public class MineSweeper {

    public static void main(String[] args) {

        int dimX;
        int dimY;
        int bombCount = 0;

        Scanner inpucik = new Scanner(System.in);


        System.out.printf("X: ");
        dimY = inpucik.nextInt();
        System.out.printf("Y: ");
        dimX = inpucik.nextInt();

        bombCount = (dimX * dimY) / 3;


        Tile[][] tile = new Tile[dimX][dimY];


        //create a specified size of an array of Tile objects, each containing class properties
        for (int i = 0; i < dimX; i++) {
            for (int j = 0; j < dimY; j++) {
                tile[i][j] = new Tile(dimX, dimY);

            }
        }

        //plant bombs *shush!*
        int rand1;
        int rand2;
        for (int i = 1; i <= bombCount; i++) {
            rand1 = (int) (Math.random() * dimX);
            rand2 = (int) (Math.random() * dimY);

            //Check whether the tile hasn't been already bombed.
            if (tile[rand1][rand2].getBomb()) {
                i--;
            } else {
                tile[rand1][rand2].setBombed();
            }
        }

        //count the bombs around a tile
        for (int i = 0; i < dimX; i++) {
            for (int j = 0; j < dimY; j++) {
                try {

                    if (tile[i - 1][j - 1].getBomb()) {
                        tile[i][j].bombCountAround++;
                    }
                    if (tile[i - 1][j + 1].getBomb()) {
                        tile[i][j].bombCountAround++;
                    }
                    if (tile[i - 1][j].getBomb()) {
                        tile[i][j].bombCountAround++;
                    }
                    if (tile[i][j - 1].getBomb()) {
                        tile[i][j].bombCountAround++;
                    }
                    if (tile[i + 1][j - 1].getBomb()) {
                        tile[i][j].bombCountAround++;
                    }
                    if (tile[i][j + 1].getBomb()) {
                        tile[i][j].bombCountAround++;
                    }
                    if (tile[i + 1][j].getBomb()) {
                        tile[i][j].bombCountAround++;
                    }
                    if (tile[i + 1][j + 1].getBomb()) {
                        tile[i][j].bombCountAround++;
                    }
                } catch (Exception e) {
                    continue;
                }


            }
        }

        //print out the board - for dev purposes :)
        for (int i = 0; i < dimX; i++) {
            for (int j = 0; j < dimY; j++) {
                System.out.printf(tile[i][j].bombCountAround + "  ");

            }
            System.out.println();
        }

        //Let the game begin
        boolean brejker = true;
        int choiceX;
        int choiceY;
        int choiceFlag;

        while (brejker) {
            System.out.printf("Input coordinant x: ");
            choiceX = inpucik.nextInt();
            System.out.printf("Input coordinant y: ");
            choiceY = inpucik.nextInt();
            System.out.printf("1: Reveal or 2: Flag?");
            choiceFlag = inpucik.nextInt();

            if (choiceFlag == 2) {
                tile[choiceX][choiceY].setFlagged();
            } else {

            }

        }

    }

}
