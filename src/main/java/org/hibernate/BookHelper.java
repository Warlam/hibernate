package org.hibernate;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.entity.Author;
import org.hibernate.entity.Book;

import java.util.List;

//SELECT всех записей
public class BookHelper {
    private SessionFactory sessionFactory;
    public BookHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }
    public List<Book> getBookList() {

        // подготовка запроса
        if (sessionFactory.isOpen()){
            Session session = sessionFactory.getCurrentSession(); //или getSession() если сессия уже была открыта
        }
        Session session = sessionFactory.openSession(); //или getSession() если сессия уже была открыта

        session.get(Book.class,1L); // получение объекта (из какой таблицы,id(long))

        CriteriaBuilder cb = session.getCriteriaBuilder(); // создаем CriteriaBuilder для criteria API запросов

        CriteriaQuery cq = cb.createQuery(Book.class);

        Root<Book> root = cq.from(Book.class); // какая таблица основная (from)

        cq.select(root); // select все записи таблицы root WHERE



        // выполнение запроса
        Query query = session.createQuery(cq); //отправляем запрос

        List<Book> bookList = query.getResultList(); // принимаем объуеты типа Author

        session.close();

        return bookList;

    }
}