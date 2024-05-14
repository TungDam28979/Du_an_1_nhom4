package du_an_1_ql_ban_giay.model;

import javax.swing.Icon;

public class modelCart {

    Icon Icon;
    String title;
    int values;
    
    public modelCart() {
    }
    
    public modelCart(Icon Icon, String title, int values) {
        this.Icon = Icon;
        this.title = title;
        this.values = values;
    }

    public Icon getIcon() {
        return Icon;
    }

    public void setIcon(Icon Icon) {
        this.Icon = Icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getValues() {
        return values;
    }

    public void setValues(int values) {
        this.values = values;
    }

}
