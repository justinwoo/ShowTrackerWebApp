package kimagure.showtracker.mappers;

import kimagure.showtracker.models.Show;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jxwoo
 * Date: 2/9/14
 * Time: 2:09 PM
 * just because i wrote this code don't mean it works
 * cross your fingers and run the tests!
 */
public interface ShowMapper {
    public void insertShow(Show show);
    public Show getShowById(Integer id);
    public List<Show> getAllShows();
    public void updateShow(Show show);
}
