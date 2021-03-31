package nuc.ss.dao;

import nuc.ss.pojo.Blog;

import java.util.List;
import java.util.Map;
@SuppressWarnings("all")
public interface BlogMapper {
    //插入数据
    int addBlog(Blog blog);

    //查询博客
    List<Blog> queryBlogIF(Map map);

    List<Blog> queryBlogChoose(Map map);

    //更新博客
    int updateBlog(Map map);
    //查询第1-2-3号记录的博客
    List<Blog> queryBlogForeach(Map map);
}
