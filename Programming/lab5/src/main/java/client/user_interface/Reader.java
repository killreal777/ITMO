package client.user_interface;

interface Reader {
    String[] readLine(ReadingMode mode);
    String[] readLine(ReadingMode mode, String invitationMessage);
}
