package kimagure.showtracker.embermodels;

import kimagure.showtracker.models.Show;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jxwoo
 * Date: 2/9/14
 * Time: 1:18 PM
 * just because i wrote this code don't mean it works
 * cross your fingers and run the tests!
 */
public class EmberShows {
    List<Show> shows;

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }
}
