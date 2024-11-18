package model;

public interface IPermissions {

    //----getters----
    String getPermissions();

    String isEnabled();

    //----setters----
    void setPermissions(boolean[] permissions);

    void setEnabled(boolean isEnabled);
}
