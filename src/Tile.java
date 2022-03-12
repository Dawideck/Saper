public class Tile {

    //public int x, y;
    private boolean isBombed;
    private boolean isRevealed;
    private boolean isFlagged;
    public int bombCountAround;
    private boolean isChecked;


    public String getBoardStatus() {
        if (getBomb()) {
            return "*";
        } else if (getFlag()) {
            return "F";
        } else if (getReveal()) {
            return "o";
        } else return "X";
    }
/*
    public void updateGameBoard() {
        if (getBomb()) {
            System.out.println("KABOOM!");
        } else {
            //go go go!
        }
    }
*/

    //getters
    public boolean getBomb() {
        return isBombed;
    }

    public boolean getReveal() {
        return isRevealed;
    }

    public boolean getFlag() {
        return isFlagged;
    }

    public boolean getChecked(){
        return isChecked;
    }


    //setters
    public void setBombed() {
        isBombed = true;
    }

    public void setRevealed() {
        isRevealed = true;
    }

    public void setFlagged() {

        isFlagged = true;
    }

    public void setUnFlagged(){
        isFlagged = false;
    }

    public void setChecked(){
        isChecked = true;
    }
}