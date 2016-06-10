package helloworld.example.administrator.wwduitangdemo.domain;

/**
 * Created by Administrator on 2016/6/6.
 */
public class ItemBean {
    public int imageRes ;
    public String title;
    public String starNum;
    public String userName;
    public String description;
    public int userIcon;

    public ItemBean(int imageRes, String title, String starNum, String userName, String description, int userIcon) {
        this.imageRes = imageRes;
        this.title = title;
        this.starNum = starNum;
        this.userName = userName;
        this.description = description;
        this.userIcon = userIcon;
    }
}
