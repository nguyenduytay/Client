package Model;
public class SecurityManager {
    public boolean checkAccessRights(UserAccount account) {
        // Kiểm tra quyền truy cập của người dùng
        System.out.println("Access rights checked for user: " + account.getUsername());
        return true;
    }

    public void blockMaliciousActivity(String activity) {
        // Chặn các hoạt động độc hại
        System.out.println("Blocked malicious activity: " + activity);
    }
}
