package util.pjic.com.utilidadespjic.models;

public class Nota {

    float note;
    float percentage;

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
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
