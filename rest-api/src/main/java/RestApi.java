import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class RestApi {

    private final List<User> users;
    private final static String NOT_FOUND_ERROR = "404 Not Found";

    RestApi(User... users) {
        this.users = new ArrayList<>(Arrays.asList(users));
    }

    String get(String url) {
        if (url.equals("/users")) {
            return UserMapper.usersToJson(users).toString();
        }

        return NOT_FOUND_ERROR;
    }

    String get(String url, JSONObject payload) {
        if (url.equals("/users")) {
            JSONArray userNames = payload.getJSONArray("users");
            List<User> foundUsers = userNames.toList().stream()
                    .map(Object::toString)
                    .map(this::retrieveUserByName)
                    .toList();
            return UserMapper.usersToJson(foundUsers).toString();
        }

        return NOT_FOUND_ERROR;
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

                lenderUser.updateOwedBy(new Iou(borrower, amount));
                borrowerUser.updateOwes(new Iou(lender, amount));

                List<User> output = new ArrayList<>(List.of(lenderUser, borrowerUser));
                output.sort(Comparator.comparing(User::name));
                yield UserMapper.usersToJson(output).toString();
            }
            default -> NOT_FOUND_ERROR;
        };
    }

    private User retrieveUserByName(String userName) {
        return users.stream()
                .filter(user -> user.name().equals(userName))
                .findFirst()
                .orElse(null);
    }
}