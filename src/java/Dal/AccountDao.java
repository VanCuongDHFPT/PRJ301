
package Dal;
import Model.Account;
import Utils.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vovan
 */
public class AccountDao {
    

    
    public Account getCheckLogin(String username, String password) {
        String sql = "SELECT * FROM account WHERE Username = ? AND Password = ?";
        try (Connection con = ConnectDB.getConnection();
                PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setString(1, username);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return new Account(rs.getInt("accountID"),
                        rs.getString("Username"),
                        rs.getString("Password"),
                        rs.getString("fullName"),
                        rs.getString("Role"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<Account> listAccount;  

    public List<Account> getListAccounts() {
        return listAccount;
    }

    public void SearchFulltName(String searchValue) {
        String sql = "Select * From account Where username  Like ?";
        listAccount = new ArrayList<>();
        try (Connection con = ConnectDB.getConnection();) {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, "%" + searchValue + "%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                String accountId = rs.getString("accountID");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String fullname = rs.getString("fullname");
                String role = rs.getString("Role");

                Account ac = new Account(0, username, password, fullname, role);
                this.listAccount.add(ac);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean DeleteAccount(String usename) {
        String sql = "Delete From account where Username = ? ";
        try (Connection con = ConnectDB.getConnection();) {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, usename);
            int row = stm.executeUpdate();
            return row > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void UpdateAccount(String username, String password, String fullname, String role) {
        String sql = "UPDATE account SET  password = ?, fullname = ?, role = ? WHERE username = ?";
        try {
            Connection con = ConnectDB.getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, password);
            stm.setString(2, fullname);
            stm.setString(3, role);
            stm.setString(4, username);
            stm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void InsertAccount(Account t) {
        String sql = "Insert into account values (?, ?, ?, ?, ?)";
        try {
            Connection con = ConnectDB.getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1,t.getAccountID());
            stm.setString(2, t.getUsername());
            stm.setString(3, t.getPassword());
            stm.setString(4, t.getFullName());
            stm.setString(5, t.getRole());
            stm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }        
}
