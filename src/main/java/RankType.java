public enum RankType {

    ACE(14),
    KING(13),
    QUEEN(12),
    JACK(11),
    TEN(10),
    NINE(9),
    EIGHT(8),
    SEVEN(7),
    SIX(6),
    FIVE(5),
    FOUR(4),
    THREE(3),
    TWO(2);

    private final int value;

    RankType(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

}
