package application;

public class SelectOptions {
    private int id;
    private String displayText;

    public SelectOptions(int id, String displayText) {
        this.id = id;
        this.displayText = displayText;
    }

    public int getId() {
        return id;
    }

    public String getDisplayText() {
        return displayText;
    }
}

