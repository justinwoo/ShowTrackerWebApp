package kimagure.showtracker.service;

import kimagure.showtracker.mappers.ShowMapper;
import kimagure.showtracker.models.Show;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jxwoo
 * Date: 2/9/14
 * Time: 2:27 PM
 * just because i wrote this code don't mean it works
 * cross your fingers and run the tests!
 */
public class ShowService {
    public void insertShow(Show show) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            ShowMapper showMapper = sqlSession.getMapper(ShowMapper.class);
            showMapper.insertShow(show);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public Show getShowById(Integer id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            ShowMapper showMapper = sqlSession.getMapper(ShowMapper.class);
            return showMapper.getShowById(id);
        } finally {
            sqlSession.close();
        }
    }

    public List<Show> getAllShows() {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            ShowMapper showMapper = sqlSession.getMapper(ShowMapper.class);
            return showMapper.getAllShows();
        } finally {
            sqlSession.close();
        }
    }

    public void updateShow(Show show) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            ShowMapper showMapper = sqlSession.getMapper(ShowMapper.class);
            showMapper.updateShow(show);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public void deleteShow(Integer id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            ShowMapper showMapper = sqlSession.getMapper(ShowMapper.class);
            showMapper.deleteShow(id);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }
}
