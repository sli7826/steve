package chatbotProject;

public class Chatbot implements Topic {
	private String userName;
	private Topic steven;
	private boolean chatting;

	public Chatbot() {
		steven = new ChatbotSteven();
		userName="unknown";
		chatting=true;
		
	}
	public void startTalking() {
		ChatbotMain.print("welcome to our chatbot! What is your name?");
		userName=ChatbotMain.getInput();
		while(chatting) {
			ChatbotMain.print("What do you want to talk aabout?");
			String response = ChatbotMain.getInput();
			if(steven.IsTriggered(response)) {
				chatting = false;
				steven.startChatting(response);
			}
			else {
				ChatbotMain.print("I don't understand.");
			}
		}
	}

}
