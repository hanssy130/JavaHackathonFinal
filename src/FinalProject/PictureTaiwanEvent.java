package FinalProject;

/**
 * Picture Taiwan Event.
 *
 * @author Brian Duong
 * @author Hans Sy
 * @author Justin Majam
 * @author Jason Lui
 * @version 2020
 */
public class PictureTaiwanEvent extends TaiwanEvent {

    private String link;

    public PictureTaiwanEvent(String date, String description, String link) {
        super(date, description);
        this.link = link;
    }
}
