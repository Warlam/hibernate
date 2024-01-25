package org.hibernate;

import org.hibernate.entity.Author;
import org.hibernate.entity.Book;

public class Start {
    public static void main(String[] args) {
        AuthorHelper authorHelper = new AuthorHelper();
        BookHelper bookHelper = new BookHelper();
        Session session = HibernateUtil.getSessionFactory().openSession();
        System.out.println("new AuthorHelper().getAuthorList() = " + new AuthorHelper().getAuthorList());
        for (Author author : authorHelper.getAuthorList()) {
            System.out.println(author.getId()+" "+author.getName());
        }
        for (Book book : bookHelper.getBookList()) {
            System.out.println(book.getId()+" "+book.getName()+" "+book.getAuthor_id());
        }
    }
}
