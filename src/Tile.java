public class Tile {

    public int x, y;
    private boolean isBombed;
    private boolean isRevealed;
    private boolean isFlagged;
    public int bombCountAround;

    public Tile(int dimX, int dimY){
        this.x = dimX;
        this.y = dimY;

    }


    public String getBoardStatus() {
        if (getBomb()) {
            return "B";
        } else if (getFlag()) {
            return "F";
        } else if (getReveal()) {
            return "o";
        } else return "X";
    }

    public void updateGameBoard() {
        if (getBomb()) {
            System.out.println("KABOOM!");
        }else{

        }
    }

    public boolean getBomb() {
        return isBombed;
    }

    public boolean getReveal() {
        return isRevealed;
    }

    public boolean getFlag() {
        return isFlagged;
    }

    public void setBombed() {
        isBombed = true;
    }

    public void setRevealed() { //rozbudować o odsłanianie połaci pól
        isRevealed = true;
    }

    public void setFlagged() {
        isFlagged = true;
    }
}