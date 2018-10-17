/**
 * The usr object
 * @author Fanchao
 */
public class Usr {

    private int usrId;      //User id
    private int usrType;    //Administrator or custom
    private int usrPhone;   //The user phone
    private String usrName; //User Name
    private String email;   //The user's email
    private String password;//The password of User

    /**
     * Constructor
     * @param usrId
     * @param usrType
     * @param usrPhone
     * @param usrName
     * @param email
     * @param password
     */
    public Usr(int usrId, int usrType, int usrPhone, String usrName, String email, String password) {
        this.usrId = usrId;
        this.usrType = usrType;
        this.usrPhone = usrPhone;
        this.usrName = usrName;
        this.email = email;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUsrId() {
        return usrId;
    }

    public void setUsrId(int usrId) {
        this.usrId = usrId;
    }

    public int getUsrType() {
        return usrType;
    }

    public void setUsrType(int usrType) {
        this.usrType = usrType;
    }

    public String getUsrName() {
        return usrName;
    }

    public void setUsrName(String usrName) {
        this.usrName = usrName;
    }

    public int getUsrPhone() {
        return usrPhone;
    }

    public void setUsrPhone(int usrPhone) {
        this.usrPhone = usrPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Show user details
     */
    public void showUsr() {
        System.out.println(" ID:" + getUsrId() + " Type: " + getUsrType() + " Name: " + getUsrName() + " Phone: " + getUsrPhone() + " Email: " + getEmail());
    }

}