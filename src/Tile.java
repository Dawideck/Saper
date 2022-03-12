public class Tile {

    private boolean isBombed;
    private boolean isRevealed;
    private boolean isFlagged;
    public int bombCountAround;
    private boolean isChecked;



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