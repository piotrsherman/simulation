package simulation.entity;

public class CoordinatesShift {// класс, который описывает сдвиг по горизонтали и вертикали
    public final int fileShift;
    public final int rankShift;

    public CoordinatesShift(int fileShift, int rankShift) {
        this.fileShift = fileShift;
        this.rankShift = rankShift;
    }
}
