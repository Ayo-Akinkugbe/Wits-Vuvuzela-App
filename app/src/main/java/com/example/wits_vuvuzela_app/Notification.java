package com.example.wits_vuvuzela_app;

public class Notification {

    private String NotificationTitle = "";
    private String NotificationTo = "";
    private String NotificationBody = "";
    private String NotificationToken = "";
    private String NotificationUser = "";

    public String getNotificationBody() {
        return NotificationBody;
    }

    public void setNotificationBody(String notificationBody) {
        NotificationBody = notificationBody;
    }

    public String getNotificationTitle() {
        return NotificationTitle;
    }

    public void setNotificationTitle(String notificationTitle) {
        NotificationTitle = notificationTitle;
    }

    public String getNotificationTo() {
        return NotificationTo;
    }

    public void setNotificationTo(String notificationTo) {
        NotificationTo = notificationTo;
    }

    public String getNotificationToken() {
        return NotificationToken;
    }

    public void setNotificationToken(String notificationToken) {
        NotificationToken = notificationToken;
    }

    public String getNotificationUser() {
        return NotificationUser;
    }

    public void setNotificationUser(String notificationUser) {
        NotificationUser = notificationUser;
    }
}
