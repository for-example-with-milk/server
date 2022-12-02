package example.milk.platform.server.packet.responsebody;

public class AddSubServiceResponseBody {
    int result;
    String message;

    public AddSubServiceResponseBody(int result, String message) {
        this.result = result;
        this.message = message;
    }
}
