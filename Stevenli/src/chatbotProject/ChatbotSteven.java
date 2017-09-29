package chatbotProject;

public class ChatbotSteven implements Topic {
	private String[] keywords;
	private String goodbyeWord;
	private String secret;
	private boolean chatting;
	public ChatbotSteven() {
		String[] temp= {"games","mario"};
		keywords=temp;
		goodbyeWord="bye";
		secret="cat";
	}

	public boolean IsTriggered(String response) {
		for(int i=0;i<keywords.length;i++) {
			if(ChatbotMain.findKeyword(response, keywords[i], 0)>=0) {
				return true;
			}
		}
		return false;
	}

	public void startChatting(String response) {
		ChatbotMain.print("Lets talk!");
		chatting=true;
		while(chatting) {
			response = ChatbotMain.getInput();
			if(ChatbotMain.findKeyword(response, goodbyeWord, 0)>=0) {
				chatting=false;
				ChatbotMain.chatbot.startTalking();
			}
			else {
				if(ChatbotMain.findKeyword(response, secret, 0)>=0) {
				ChatbotMain.print("Congrats");
				}
				else {
					ChatbotMain.print("Nice try");
				}
			}
		}
		
	}
}
