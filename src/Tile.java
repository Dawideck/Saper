public class Tile {

    private boolean isBombed;
    private boolean isRevealed;
    private boolean isFlagged;
    private int bombCountAround;



    public String getBoardStatus(){
        if(getBomb())
            {return "B";}
        else
            if(getFlag())
                {return "F";}
            else
                if(getReveal())
                {return "o";}
                else return "X";
    }

    public int getBombCountAround(){
        return bombCountAround;
    }

    public boolean getBomb(){
        return isBombed;
    }

    public boolean getReveal(){
        return isRevealed;
    }

    public boolean getFlag(){
        return isFlagged;
    }

    public void setBombed(){
        isBombed = true;
    }

    public void setRevealed(){
        isRevealed = true;
    }

    public void setFlagged(){
        isFlagged = true;
    }

}
