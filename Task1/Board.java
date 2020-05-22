package Task1;

public class Board implements Comparable <Board>{
    private Integer area;

    @Override
    public int compareTo(Board o) {
        if (area == o.area) {
            return 0;
        } else if (area > o.area) {
            return 1;
        } else {
            return -1;
        }
    }
}
