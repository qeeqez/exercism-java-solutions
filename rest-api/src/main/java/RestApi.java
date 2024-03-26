import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class RestApi {

    private final List<User> users;

    RestApi(User... users) {
        this.users = new ArrayList<>(Arrays.asList(users));
    }

    String get(String url) {
        return UserMapper.usersToJson(users).toString();
    }

    String get(String url, JSONObject payload) {
        JSONArray userNames = payload.getJSONArray("users");
        List<User> foundUsers = userNames.toList().stream()
                .map(Object::toString)
                .map(this::retrieveUserByName)
                .toList();
        return UserMapper.usersToJson(foundUsers).toString();
    }

    String post(String url, JSONObject payload) {
        return switch (url) {
            case "/add" -> {
                String name = payload.getString("user");

                User newUser = User.builder().setName(name).build();
                users.add(newUser);

                yield UserMapper.userToJson(newUser).toString();
            }
            case "/iou" -> {
                String lender = payload.getString("lender");
                String borrower = payload.getString("borrower");
                double amount = payload.getDouble("amount");

                User lenderUser = retrieveUserByName(lender);
                User borrowerUser = retrieveUserByName(borrower);

                lenderUser.addOwedBy(new Iou(borrower, amount));
                borrowerUser.addOwes(new Iou(lender, amount));

                List<User> output = List.of(lenderUser, borrowerUser);
                yield UserMapper.usersToJson(output).toString();
            }
            default -> throw new IllegalStateException("Unexpected url: " + url);
        };
    }

    private User retrieveUserByName(String userName) {
        return users.stream()
                .filter(user -> user.name().equals(userName))
                .findFirst()
                .orElse(null);
    }
}