package guestbook.service;

import guestbook.model.GuestBook;

import java.util.List;

// Controller  -> Service -> Dao
public interface GuestBookService {

    boolean add(String userName, String content);  // 新增
    GuestBook getById(Integer id);  // 單筆查詢
    List<GuestBook> queryAll();  // 多筆查詢
    boolean updateUsername(Integer id, String username);  // 修改使用者名稱
    boolean updateContent(Integer id, String content);  // 修改留言內容
    boolean removeById(Integer id);  // 刪除

}
