import java.util.ArrayList;
import java.util.regex.Pattern;

public class UsrController {
    UsrRoll usrRoll = new UsrRoll();
    private int currentUsrId = 0;
    private ArrayList<Usr> usrs = usrRoll.getUsrRoll();

    public void logout() {
        setCurrentUsrId(0);
    }

    // inputInfo is the email + password
    public int login(String[] inputInfo) {
        for (Usr u : usrs) {
            if (inputInfo[0].equals(u.getEmail()) && inputInfo[1].equals(u.getPassword())) {
                setCurrentUsrId(u.getUsrId());
                return u.getUsrType();
            }

        }
        return -1;
    }

    // change current usr info
    // 只能更改 电话 邮箱 和 姓名
    public boolean editInfo(String[] info) {
        if (checkEmail(info[0]) && checkPhone(info[1]) && checkName(info[2])) {
            // Usr(int usrId, int usrType, int usrPhone, String usrName, String email, String password)
            Usr usr = new Usr(getCurrentUsrId(), 1, Integer.parseInt(info[1]), info[0], info[2], usrs.get(getUsrById(getCurrentUsrId())).getPassword());
            usrs.set(getUsrById(getCurrentUsrId()), usr);
            usrRoll.setUsrRoll(usrs);
            return true;
        } else
            return false;
    }

    public boolean registerUsr(String[] regInfo) {
        if (checkEmail(regInfo[0]) && checkPhone(regInfo[1]) && checkName(regInfo[2]) && checkPass(regInfo[3], regInfo[4])) {
            //          Usr(int usrId, int usrType, int usrPhone, String usrName, String email, String password)

            Usr u = new Usr(genId(), 1, Integer.parseInt(regInfo[1]), regInfo[2], regInfo[0], regInfo[3]);
            u.showUsr();
            usrs.add(u);
            usrRoll.setUsrRoll(usrs);
            setCurrentUsrId(genId());
            return true;
        } else
            return false;
    }

    public void showAll() {
        for (Usr u : usrs) {
            u.showUsr();
        }
    }


    public boolean unRegisterUsr(int unregisterUsrID, String checkPassword) {
        // get current user id
        int currentUsrId = getCurrentUsrId();
        // If user == 0, then he or he is a visitor
        if (currentUsrId == 0) {
            System.out.println("Visitor cannot unregister");
            return false;
        }
        // 通过用户的ID获取用户在list中的index
        int unregisterUsrIndex = getUsrById(unregisterUsrID);

        if ((usrs.get(getUsrById(currentUsrId)).getPassword()) == checkPassword) {
            if (whetherAdm(currentUsrId) && (!whetherAdm(unregisterUsrID))) {
                usrs.remove(unregisterUsrIndex);
                System.out.println("Success remove user" + unregisterUsrID + "\n whose index is" + unregisterUsrIndex);
                usrRoll.setUsrRoll(usrs);
                return true;

            }
            // for users to delete themselves
            else if (currentUsrId == unregisterUsrID && unregisterUsrIndex != -1) {
                System.out.println("Success remove yourself");
                usrs.remove(unregisterUsrIndex);
                setCurrentUsrId(0);
                return true;
            }
            System.out.println("Unsuccessful");
            return false;
        } else {
            System.out.println("wrong password!");
            return false;
        }

    }

    public ArrayList<Usr> getUsrs() {
        return usrs;
    }

    // 第一个是邮箱 [0] 是否符合
    public boolean checkEmail(String email) {
        // 从 https://blog.csdn.net/qq1332479771/article/details/49272591 参考的正则
        if (Pattern.matches("^(\\w + ((-\\w +)|(\\.\\w +))*)\\+\\w + ((-\\w +)|(\\.\\w +))*\\@[A - Za - z0 - 9]+((\\.|-)[A - Za - z0 - 9]+)*\\.[A - Za - z0 - 9]+$", email.trim())) {
            for (Usr u : usrs) {
                if (email.equalsIgnoreCase(u.getEmail())) {
                    System.out.println("Duplicate Email");
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    // 电话 [1] 十位纯数字//
    public boolean checkPhone(String phone) {

        if (Pattern.matches("[0-9]{10}$", phone.trim())) {
            for (Usr u : usrs) {
                if (Integer.parseInt(phone) == u.getUsrPhone())
                    System.out.println("Duplicate Phone");
                return false;
            }
        } else {
            System.out.println("Phone must be 10 number ");
            return false;
        }
        return true;
    }

    // name [2] 纯英文 可重复 无空格
    public boolean checkName(String name) {
        if (Pattern.matches("[a-zA-Z]{1,15}", name.trim())) {
            return true;

        }
        return false;
    }

    // password [3] == password [4]
    public boolean checkPass(String pass1, String pass2) {
        if (pass1.equals(pass2)) {
            return true;
        }
        return false;

    }


    // 检查用户是否为管理员， true是管理员
    public boolean whetherAdm(int uid) {
        for (Usr u : usrs) {
            if (u.getUsrId() == uid && u.getUsrType() == 1)
                return true;
        }
        return false;
    }

    // 生成新的user id
    public int genId() {
        int temp = 1;
        for (Usr u : usrs) {
            if (u.getUsrId() == temp)
                temp += 1;
            else
                return temp;
        }
        return temp;
    }

    //通过user的id获取他在list中的index
    public int getUsrById(int uid) {
        for (Usr u : usrs) {
            if (uid == u.getUsrId())
                return usrs.indexOf(u);
        }
        return -1;
    }

    public int getCurrentUsrId() {
        return currentUsrId;
    }

    public void setCurrentUsrId(int currentUsrId) {
        this.currentUsrId = currentUsrId;
    }

}