package AuthenticationAPI.model;

import java.util.Objects;

public class User {

    private String username;
    private String password;
 
    public String getUsername() {
        return username;
    }
 
    public void setName(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
	public int hashCode() {
		return Objects.hash(username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof User))
			return false;
		
		User other = (User) obj;

		if (username.equals(other.username)) {
			return password.equals(other.password);
		} 
		return false;
	}

	@Override
	public String toString() {
		return "User {username='" + username + "', password='" + password + "'}";
	}	
 }