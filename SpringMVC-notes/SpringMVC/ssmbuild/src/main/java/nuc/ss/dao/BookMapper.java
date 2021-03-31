package nuc.ss.dao;

import nuc.ss.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    // 增加一本书
    int addBook(Books books);

    //删除一本书
    int deleteBookById(@Param("bookID") int id);

    //更改一本书
    int updateBook(Books books);

    //查询一本书
    Books queryBookById(@Param("bookID") int id);

    //查询全部的书
    List<Books> queryAllBooks();

    List<Books> queryBook(@Param("bookName")String bookName);

    Books queryBookByName(@Param("bookName")String bookName);
}
