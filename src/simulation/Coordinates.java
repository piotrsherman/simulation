package simulation;

import simulation.entity.CoordinatesShift;

public class Coordinates {
    public final File file; // в данном контексте - вертикаль поля где происходят действия

    public final Integer rank;// горизонталь поля, где происходят действия

    public Coordinates(File file, Integer rank) {
        this.file = file;
        this.rank = rank;
    }


    public Coordinates shift(CoordinatesShift shift){
        return new Coordinates(File.values()[this.file.ordinal() + shift.fileShift], this.rank + shift.rankShift);
    }

    public boolean canShift(CoordinatesShift shift){
        int f = file.ordinal() + shift.fileShift;
        int r = rank + shift.rankShift;

        if((f < 0 ) || (f > 7)) return false;
        if((r < 1 ) || (r > 8)) return false;

        return true;
    }

    // для того, чтобы использовать собственный объект в качестве HashMap нужно реализовать методы equals и hashCocde
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinates that = (Coordinates) o;

        if (file != that.file) return false;
        return rank.equals(that.rank);
    }

    @Override
    public int hashCode() {
        int result = file.hashCode();
        result = 31 * result + rank.hashCode();
        return result;
    }
}
