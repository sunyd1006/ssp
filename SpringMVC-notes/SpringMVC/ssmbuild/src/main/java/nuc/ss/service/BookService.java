package nuc.ss.service;

import nuc.ss.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService {
    // 增加一本书
    int addBook(Books books);

    //删除一本书
    int deleteBookById(int id);

    //更改一本书
    int updateBook(Books books);

    //查询一本书
    Books queryBookById(int id);

    //查询全部的书
    List<Books> queryAllBooks();

    List<Books> queryBook(String bookName);

    Books queryBookByName(String bookName);

}
