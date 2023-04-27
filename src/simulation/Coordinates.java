package simulation;

public class Coordinates {
    public final File file; // в данном контексте - вертикаль поля где происходят действия

    public final Integer rank;// горизонталь поля, где происходят действия

    public Coordinates(File file, Integer rank) {
        this.file = file;
        this.rank = rank;
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
