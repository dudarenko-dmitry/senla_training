package pl.senla.hotel.dao;

import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.lang.reflect.*;
import java.util.List;

import static pl.senla.hotel.constant.DBConstant.*;
import static pl.senla.hotel.constant.DaoConstant.*;

@Slf4j
public abstract class GenericDaoHibernate<T> implements GenericDao<T> {

    private final Class<T> type;
    private final SessionFactory sessionFactory;

    public GenericDaoHibernate() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
        log.info("Class T: {}", type);
        sessionFactory = new Configuration()
                .addPackage("pl.senla.hotel.entity")
                .buildSessionFactory();
        log.debug(CREATE_GENERIC_DAO, type.getTypeName());
    }

    @Override
    public List<T> readAll() {
        try (Session session = sessionFactory.openSession()) {
            List<T> data = loadAllData(session);
            log.info(READ_ALL_SUCCEED);
            return data;
        } catch (HibernateException e) {
            log.error(READ_ALL_FAILED);
            return null;
        }
    }

    @Override
    public boolean create(T t) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(t);
            transaction.commit();
            log.info(CREATE_SUCCEED);
            return true;
        } catch (HibernateException e) {
            log.error(CREATE_FAILED, e);
            return false;
        }
    }

    @Override
    public T read(int id) {
        try (Session session = sessionFactory.openSession()) {
            T t = session.get(type, id);
            log.info(READ_SUCCEED);
            return t;
        } catch (HibernateException e) {
            log.error(READ_FAILED, e);
            return null;
        }
    }

    @Override
    public boolean update(int id, T t) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            T tOld = session.get(type, id);
            session.evict(tOld);
            tOld = t;
            session.update(tOld);
            transaction.commit();
            log.info(UPDATE_SUCCEED);
            return true;
        } catch (HibernateException e) {
            log.error(UPDATE_FAILED, e);
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            T t = session.get(type, id);
            session.delete(t);
            transaction.commit();
            log.info(DELETE_SUCCEED);
            return true;
        } catch (HibernateException e) {
            log.error(DELETE_FAILED, e);
            return false;
        }
    }

    private List<T> loadAllData(Session session) {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(type);
        Root<T> rootEntry = criteriaQuery.from(type);
        CriteriaQuery<T> allT = criteriaQuery.select(rootEntry);
        TypedQuery<T> allQuery = session.createQuery(allT);
        List<T> resultList = allQuery.getResultList();
        log.info(READ_ALL_SUCCEED);
        return resultList;
    }

}
