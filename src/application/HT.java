package application;

public class HT {
    private String receiver_ID;
    private String receiver_Name;
    private String amount;
    private String sender_ID;
    private String sender_Name;
    private String date_Time;

    public HT(String receiver_ID, String receiver_Name, String amount, String sender_ID, String sender_Name, String date_Time) {
        this.receiver_ID = receiver_ID;
        this.receiver_Name = receiver_Name;
        this.amount = amount;
        this.sender_ID = sender_ID;
        this.sender_Name = sender_Name;
        this.date_Time = date_Time;
    }

    public String getReceiver_ID() {
        return receiver_ID;
    }

    public String getReceiver_Name() {
        return receiver_Name;
    }

    public String getAmount() {
        return amount;
    }

    public String getSender_ID() {
        return sender_ID;
    }

    public String getSender_Name() {
        return sender_Name;
    }

    public String getDate_Time() {
        return date_Time;
    }
}
