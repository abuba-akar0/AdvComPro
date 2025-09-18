
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class ChatBotGUI extends JFrame {
    private JTextPane chatArea;
    private JTextField inputField;
    private JButton sendButton;
    private StyledDocument doc;
    private SimpleAttributeSet userStyle, botStyle, timeStyle;

    public ChatBotGUI() {
        setTitle("Advanced ChatBot");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 600);
        setLocationRelativeTo(null);

        chatArea = new JTextPane();
        chatArea.setEditable(false);
        doc = chatArea.getStyledDocument();

        userStyle = new SimpleAttributeSet();
        StyleConstants.setForeground(userStyle, Color.BLUE);
        StyleConstants.setBold(userStyle, true);

        botStyle = new SimpleAttributeSet();
        StyleConstants.setForeground(botStyle, new Color(0, 128, 0));
        StyleConstants.setBold(botStyle, false);

        timeStyle = new SimpleAttributeSet();
        StyleConstants.setForeground(timeStyle, Color.GRAY);
        StyleConstants.setFontSize(timeStyle, 10);

        JScrollPane scrollPane = new JScrollPane(chatArea);

        inputField = new JTextField();
        sendButton = new JButton("Send");

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        add(scrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        sendButton.addActionListener(e -> sendMessage());
        inputField.addActionListener(e -> sendMessage());

        setVisible(true);
        inputField.requestFocus();
    }

    private void sendMessage() {
        String userText = inputField.getText().trim();
        if (userText.isEmpty()) return;
        appendMessage("You", userText, userStyle);
        inputField.setText("");
        String botResponse = ChatBotLogic.getResponse(userText);
        appendMessage("Bot", botResponse, botStyle);
    }

    private void appendMessage(String sender, String message, AttributeSet style) {
        try {
            String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
            doc.insertString(doc.getLength(), "[" + time + "] ", timeStyle);
            doc.insertString(doc.getLength(), sender + ": ", style);
            doc.insertString(doc.getLength(), message + "\n", null);
            chatArea.setCaretPosition(doc.getLength());
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }
    }
}

public class ChatBotLogic {
    public static String getResponse(String input) {
        input = input.toLowerCase();
        if (input.contains("hello") || input.contains("hi")) {
            return "Hello! How can I assist you today?";
        } else if (input.contains("time")) {
            return "Current time: " + java.time.LocalTime.now().toString();
        } else if (input.contains("name")) {
            return "I'm your advanced Java chatbot!";
        } else if (input.contains("help")) {
            return "You can ask me about the time, my name, or just say hello!";
        } else if (input.contains("bye")) {
            return "Goodbye! Have a great day!";
        } else {
            return "Sorry, I didn't understand that. Try asking something else!";
        }
    }
}
