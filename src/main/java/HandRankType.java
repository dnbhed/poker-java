public enum HandRankType {

    STRAIGHTFLUSH(1),
    FOUROFAKIND(2),
    FULLHOUSE(3),
    FLUSH(4),
    STRAIGHT(5),
    THREEOFAKIND(6),
    TWOPAIR(7),
    ONEPAIR(8),
    HIGHCARD(9);


    private final int value;

    HandRankType(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

}
