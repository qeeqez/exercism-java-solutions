import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public class UserMapper {
    public static JSONObject usersToJson(List<User> users) {
        var output = new JSONArray();
        users.stream().map(UserMapper::userToJson).forEach(output::put);
        return new JSONObject()
                .put("users", output);
    }

    public static JSONObject userToJson(User user) {
        return new JSONObject()
                .put("name", user.name())
                .put("owes", iousToJson(user.owes()))
                .put("owedBy", iousToJson(user.owedBy()))
                .put("balance", user.getBalance());
    }

    private static JSONObject iousToJson(List<Iou> ious) {
        if(ious.isEmpty()) return new JSONObject();

        var output = new JSONObject();
        ious.forEach(iou -> output.put(iou.name, iou.amount));
        return output;
    }
}
