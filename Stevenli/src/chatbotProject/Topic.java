package chatbotProject;

public interface Topic {

	boolean IsTriggered(String response);

	void startChatting(String response);
	
}
