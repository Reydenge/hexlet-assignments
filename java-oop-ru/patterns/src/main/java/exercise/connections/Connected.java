package exercise.connections;

import exercise.TcpConnection;

// BEGIN
public class Connected implements Connection {
    private TcpConnection tcpConnection;
    private final String CONNECTION_STATE = "connected";
    public Connected(TcpConnection tcpConnection) {
        this.tcpConnection = tcpConnection;
    }

    @Override
    public String getConnectionState() {
        return this.CONNECTION_STATE;
    }

    @Override
    public void connect() {
        System.out.println("Error! Connection already connected.");
    }

    @Override
    public void disconnect() {
        this.tcpConnection.setCurrentState(new Disconnected(tcpConnection));
    }

    @Override
    public void write(String data) {
        System.out.println(data);
    }
}
// END
