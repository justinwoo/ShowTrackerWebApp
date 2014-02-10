package kimagure.showtracker.models;

/**
 * Created with IntelliJ IDEA.
 * User: jxwoo
 * Date: 2/9/14
 * Time: 1:19 PM
 * just because i wrote this code don't mean it works
 * cross your fingers and run the tests!
 */
public class Show {
    private int id;
    private String title;
    private int episode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getEpisode() {
        return episode;
    }

    public void setEpisode(int episode) {
        this.episode = episode;
    }

    @Override
    public String toString() {
        return "{:id " + id + " :title " + title + " :episode " + episode + " }";
    }
}
