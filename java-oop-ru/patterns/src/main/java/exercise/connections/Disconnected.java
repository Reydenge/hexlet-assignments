package exercise.connections;

import exercise.TcpConnection;

// BEGIN
public class Disconnected implements Connection {
    private TcpConnection tcpConnection;
    private final String CONNECTION_STATE = "disconnected";
    public Disconnected(TcpConnection tcpConnection) {
        this.tcpConnection = tcpConnection;
    }
    @Override
    public String getConnectionState() {
        return this.CONNECTION_STATE;
    }
    @Override
    public void connect() {
        this.tcpConnection.setCurrentState(new Connected(tcpConnection));
    }

    @Override
    public void disconnect() {
        System.out.println("Error! Connection already disconnected.");
    }

    @Override
    public void write(String data) {
        System.out.println("Error!" + data);
    }
}
// END
