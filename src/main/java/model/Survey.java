package model;

import java.io.Serializable;


public class Survey implements Serializable {
    private String hear;
    private String yes1;
    private String yes2;
    private String contactMethod;

    public Survey() {
        hear = "";
        yes1 = "";
        yes2 = "";
        contactMethod = "";
    }

    public Survey(String hear, String yes1, String yes2, String contactMethod) {
        this.hear = hear;
        this.yes1 = yes1;
        this.yes2 = yes2;
        this.contactMethod = contactMethod;
    }

    public String getHear() {
        return hear;
    }

    public void setHear(String hear) {
        this.hear = hear;
    }

    public String getYes1() {
        return yes1;
    }

    public void setYes1(String yes1) {
        this.yes1 = yes1;
    }

    public String getYes2() {
        return yes2;
    }

    public void setYes2(String yes2) {
        this.yes2 = yes2;
    }

    public String getContactMethod() {
        return contactMethod;
    }

    public void setContactMethod(String contactMethod) {
        this.contactMethod = contactMethod;
    }
}
