package ir.technopedia.english.model;

/**
 * Created by TheLoneWolf on 9/3/2016.
 */
public class NavMenuModel {

    public String title;
    public int img;

    public NavMenuModel(String title, int img) {
        this.title = title;
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
