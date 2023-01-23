package exercise.connections;

public interface Connection {
    // BEGIN
    String getConnectionState();
    void connect();
    void disconnect();
    void write(String data);
    // END
}
