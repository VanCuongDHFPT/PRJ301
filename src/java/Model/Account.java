/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author vovan
 */
public class Account {
    private int accountID;   // Mã tài khoản
    private String username; // Tên đăng nhập
    private String password; // Mật khẩu
    private String fullName; // Họ và tên
    private String role;     // Vai trò (Role)

    // Constructor không tham số
    public Account() {
    }

    // Constructor có tham số
    public Account(int accountID, String username, String password, String fullName, String role) {
        this.accountID = accountID;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.role = role;
    }

    // Getter và Setter cho các thuộc tính
    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // Phương thức toString để hiển thị thông tin của tài khoản
    @Override
    public String toString() {
        return "Account{" +
                "accountID=" + accountID +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
