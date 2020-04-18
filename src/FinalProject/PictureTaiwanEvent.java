package FinalProject;

public class PictureTaiwanEvent extends TaiwanEvent {

    private String link;

    public PictureTaiwanEvent(String date, String description, String link) {
        super(date, description);
        this.link = link;
    }
}
