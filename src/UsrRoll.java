import java.io.*;
import java.util.ArrayList;

/**
 * @author Fanchao & Zhitao
 */
public class UsrRoll {
    ArrayList<Usr> usrRoll = new ArrayList<>();

    public UsrRoll() {
        loadUsr();
    }

    public ArrayList<Usr> getUsrRoll() {
        return usrRoll;
    }

    public void setUsrRoll(ArrayList<Usr> usrRoll) {
        this.usrRoll = usrRoll;
    }

    /**
     * load all user form file to user roll list
     */
    public void loadUsr() {
        ArrayList<Usr> usrList = new ArrayList<>();
        /* File file = new File("Usr.txt"); */
        // 还需要测试打包后的class名该选择什么 （现在暂定UserRoll，可以找到src下文件
        File file = new File(UsrRoll.class.getResource("Usr.txt").getFile());
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = reader.readLine()) != null) {

                //System.out.print(line); 查看是否load进去了

                String[] usrInfo = line.split(",");
                Usr usr = new Usr(Integer.parseInt(usrInfo[0]), Integer.parseInt(usrInfo[1]), Integer.parseInt(usrInfo[3]), usrInfo[2], usrInfo[4], usrInfo[5]);
                usrList.add(usr);
            }
            setUsrRoll(usrList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * write user form memory to file
     * @param usrr
     */
    public void writeUsr(UsrRoll usrr) {
        try {
            File file = new File(UsrRoll.class.getResource("Usr.txt").getFile());
            PrintStream ps = new PrintStream(new FileOutputStream(file));
            ps.println("");
            for (Usr user : usrr.getUsrRoll()) {
                ps.append(user.getUsrId() + "," + user.getUsrType() + "," + user.getUsrName() + "," + user.getUsrPhone() + "," + user.getEmail() + "," + user.getPassword());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}