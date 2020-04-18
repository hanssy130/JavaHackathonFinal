package FinalProject;

public class PictureEvent extends TaiwanEvents {

    private String link;

    public PictureEvent(String date, String description, String link) {
        super(date, description);
        this.link = link;
    }
}
