package util.pjic.com.utilidadespjic.models;

public class Nota {

    Float note;
    Float percentage;

    public Float getNote() {
        return note;
    }

    public void setNote(Float note) {
        this.note = note;
    }

    public Float getPercentage() {
        return percentage;
    }

    public void setPercentage(Float percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "Nota{" +
                "note=" + note +
                ", percentage=" + percentage +
                '}';
    }
}
