package guestbook.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class GuestBook {
    private Integer id;
    private String userName;
    private String content;
    private Date createDate;
    private Date updateDate;

    public GuestBook(String userName, String content) {
        this.userName = userName;
        this.content = content;
    }
}
