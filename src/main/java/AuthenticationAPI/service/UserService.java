package AuthenticationAPI.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import AuthenticationAPI.model.User;

@Service
public class UserService {

   private static final Map<User, String> USER_REPOSITORY = new HashMap<>();

   public void create(User user) {
       USER_REPOSITORY.put(user, null);
   }

   public boolean contains(User user) {
       return USER_REPOSITORY.containsKey(user);
   }

   public boolean login(User user) {
        if (USER_REPOSITORY.containsKey(user)) {
            Set<User> users = USER_REPOSITORY.keySet();
            for (User u : users) {
                if (u.getPassword().equals(user.getPassword())) {
                    return true;
                }
            }
        }
        return false;
    }
}