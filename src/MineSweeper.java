import java.util.Scanner;

public class MineSweeper {

    //for now this method prints the amount of bombs around given tile --> will print an updated board
    public static void printUpdatedBoard(Tile[][] tile, int dimX, int dimY) {
        for (int i = 0; i < dimX; i++) {
            for (int j = 0; j < dimY; j++) {
                if (tile[i][j].getReveal()) {
                    System.out.print(tile[i][j].bombCountAround + "  ");
                } else if (tile[i][j].getFlag()) {
                    System.out.print("F  ");
                } else {
                    System.out.print("X  ");
                }
            }
            System.out.println();
        }
    }

    //reveal a field and adjacent empty tiles
    public static void revealTile(Tile[][] tile, int choiceX, int choiceY, int dimX, int dimY) {

        int tempY = choiceX;
        int tempX = choiceY;

        //not doing the "first move reveals more" deal...
        //first and foremost check for outOfBounds and if the field hasn't been checked already
        if (!(tempX < 0 || tempX >= dimY || tempY < 0 || tempY >= dimX) && !tile[tempX][tempY].getChecked()) {
            tile[tempX][tempY].setChecked();

            //if the field IS surrounded by even 1 bomb (value>0) - reveal only this field.
            if (!tile[tempX][tempY].getBomb()) {
                if (tile[tempX][tempY].bombCountAround != 0) {
                    tile[tempX][tempY].setRevealed();

                    //if the field is NOT surrounded - recursively check adjacent fields
                    //but only the ones that don't go out of bounds, nor are already checked
                } else if (tile[tempX][tempY].bombCountAround == 0) {
                    tile[tempX][tempY].setRevealed();
                    revealTile(tile, tempX, tempY - 1, dimX, dimY);
                    revealTile(tile, tempX, tempY + 1, dimX, dimY);
                    revealTile(tile, tempX - 1, tempY, dimX, dimY);
                    revealTile(tile, tempX - 1, tempY - 1, dimX, dimY);
                    revealTile(tile, tempX - 1, tempY + 1, dimX, dimY);
                    revealTile(tile, tempX + 1, tempY, dimX, dimY);
                    revealTile(tile, tempX + 1, tempY - 1, dimX, dimY);
                    revealTile(tile, tempX + 1, tempY + 1, dimX, dimY);
                }
            }
        }
    }

    public static void main(String[] args) {


        int dimX;
        int dimY;
        int bombCount;

        Scanner inpucik = new Scanner(System.in);


        System.out.print("X: ");
        dimY = inpucik.nextInt();
        System.out.print("Y: ");
        dimX = inpucik.nextInt();

        bombCount = (dimX * dimY) / 3;


        Tile[][] tile = new Tile[dimX][dimY];


        //create a specified size of an array of Tile objects, each containing class properties
        for (int i = 0; i < dimX; i++) {
            for (int j = 0; j < dimY; j++) {
                tile[i][j] = new Tile();

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
                //decrement to redo this rando pick
                i--;
            } else {
                //if not, set the bomb
                tile[rand1][rand2].setBombed();
            }
        }

        //count the bombs around a tile
        for (int i = 0; i < dimX; i++) {
            for (int j = 0; j < dimY; j++) {
                //check for out of bounds
                if (!(i - 1 < 0 || j - 1 < 0 || i + 1 >= dimX || j + 1 >= dimY)) {
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


                }
            }
        }

        //Let the game begin
        int choiceX;
        int choiceY;
        int choiceFlag;

        //create object that will control the flow of the game
        Game game = new Game();

        while (game.isOn) {

            System.out.println();
            printUpdatedBoard(tile, dimX, dimY);
            System.out.println();

            System.out.print("Input coordinant x: ");
            choiceX = inpucik.nextInt() - 1; // must be decreased to correspond with correct element in array
            System.out.print("Input coordinant y: ");
            choiceY = inpucik.nextInt() - 1; // must be decreased to correspond with correct element in array
            System.out.print("1: Reveal or 2: Flag?: ");
            choiceFlag = inpucik.nextInt();

            if (choiceFlag == 2) {
                tile[choiceX][choiceY].setFlagged();
            } else {
                //firstly check if the user choose poorly
                if (tile[choiceX][choiceY].getBomb()) {
                    System.out.println("KABOOM! Game Over!");
                    game.isOn = false;

                    //if he choose wisely (bomb false), check if the field hasn't been already revealed
                } else if (tile[choiceX][choiceY].getReveal()) {
                    System.out.println("The field has already been revealed!");

                    //if the field is not revealed - check for a flag
                } else if (tile[choiceX][choiceY].getFlag()) {

                    //if there is one ask to unflag
                    System.out.println("Field flagged! Do you wish to unflag? 1: Yes. 2: No.");
                    choiceFlag = inpucik.nextInt();
                    if (choiceFlag == 1) {
                        tile[choiceX][choiceY].setUnFlagged();
                    }
                    //if there is no flag - reveal recursively
                } else revealTile(tile, choiceX, choiceY, dimX, dimY);

            }

        }

    }

}

