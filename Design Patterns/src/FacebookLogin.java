// Handler Interface
interface LoginHandler {
    LoginHandler setNext(LoginHandler handler);
    boolean handle(LoginRequest request);
}

// Abstract Handler
abstract class AbstractLoginHandler implements LoginHandler {
    protected LoginHandler nextHandler;

    public LoginHandler setNext(LoginHandler handler) {
        this.nextHandler = handler;
        return handler;
    }

    public abstract boolean handle(LoginRequest request);
}

// Concrete Handlers
class UsernameHandler extends AbstractLoginHandler {
    public boolean handle(LoginRequest request) {
        if (request.getUsername() != null && !request.getUsername().isEmpty()) {
            System.out.println("Username is valid");
            if (nextHandler != null) {
                return nextHandler.handle(request);
            }
            return true;
        } else {
            System.out.println("Invalid username");
            return false;
        }
    }
}

class PasswordHandler extends AbstractLoginHandler {
    public boolean handle(LoginRequest request) {
        if (request.getPassword() != null && !request.getPassword().isEmpty()) {
            System.out.println("Password is valid");
            if (nextHandler != null) {
                return nextHandler.handle(request);
            }
            return true;
        } else {
            System.out.println("Invalid password");
            return false;
        }
    }
}

class FacebookTokenHandler extends AbstractLoginHandler {
    public boolean handle(LoginRequest request) {
        if (request.getFacebookToken() != null && !request.getFacebookToken().isEmpty()) {
            System.out.println("Facebook token is valid");
            if (nextHandler != null) {
                return nextHandler.handle(request);
            }
            return true;
        } else {
            System.out.println("Invalid Facebook token");
            return false;
        }
    }
}

// Login Request
class LoginRequest {
    private String username;
    private String password;
    private String facebookToken;

    public LoginRequest(String username, String password, String facebookToken) {
        this.username = username;
        this.password = password;
        this.facebookToken = facebookToken;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFacebookToken() {
        return facebookToken;
    }
}

// Client Code
public class FacebookLogin {
    public static void main(String[] args) {
        LoginHandler usernameHandler = new UsernameHandler();
        LoginHandler passwordHandler = new PasswordHandler();
        LoginHandler facebookTokenHandler = new FacebookTokenHandler();

        usernameHandler.setNext(passwordHandler).setNext(facebookTokenHandler);

        // Simulating different login attempts
        LoginRequest[] loginRequests = {
                new LoginRequest("user123", "pass123", ""),
                new LoginRequest("", "pass123", ""),
                new LoginRequest("user123", "", ""),
                new LoginRequest("", "", "fbToken123"),
                new LoginRequest("user123", "pass123", "fbToken123")
        };

        for (LoginRequest request : loginRequests) {
            if (usernameHandler.handle(request)) {
                System.out.println("Login successful");
            } else {
                System.out.println("Login failed");
            }
            System.out.println();
        }
    }
}
