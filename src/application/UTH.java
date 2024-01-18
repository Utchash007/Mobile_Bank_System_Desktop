package application;

public class UTH {
	 private String amount;
	    private String sender_ID;
	    private String sender_Name;
	    private String date_Time;
	    
	    public UTH( String amount, String sender_ID, String sender_Name, String date_Time) {
	        
	        this.amount = amount;
	        this.sender_ID = sender_ID;
	        this.sender_Name = sender_Name;
	        this.date_Time = date_Time;
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
