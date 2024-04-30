package faceweb.demo2.Domain;

public class BoardItem {
    private String title;
    private String userName;
    private String timeStamp;
    private int viewCount;

    public BoardItem(String title, String userName, String timeStamp, int viewCount) {
        this.title = title;
        this.userName = userName;
        this.timeStamp = timeStamp;
        this.viewCount = viewCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }
}
