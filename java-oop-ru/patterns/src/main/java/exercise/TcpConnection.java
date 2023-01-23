package exercise;
import exercise.connections.Connection;
import exercise.connections.Disconnected;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

// BEGIN
public class TcpConnection {
    private String ipAddress;
    private int port;
    private Connection state;
    private List<String> buffer = new ArrayList<>();

    public TcpConnection(String ipAddress, int port) {
        this.ipAddress = ipAddress;
        this.port = port;
        this.state = new Disconnected(this);
    }
    public String getCurrentState() {
        return this.state.getConnectionState();
    }
    public void setCurrentState(Connection state) {
        this.state = state;
    }
    public void connect() {
        this.state.connect();
    }
    public void disconnect() {
        this.state.disconnect();
    }
    public void write(String data) {
        this.state.write(data);
    }
}
// END
