import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class keylogCLIENT extends JFrame{
    private JTextArea txt;
    private JButton btn;
    private JScrollPane scroll;

    
    public keylogCLIENT(){
        super("KEYSTROKE");
        setSize(500, 480);     
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        btn = new JButton("CLEAN");
        btn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                txt.setText("");
            }
        });
  
        btn.setBounds(380, 400, 50, 30);
        add(btn);        
        txt = new JTextArea();
        btn = new JButton("HOOK");

        btn.setBounds(10, 400, 100, 30);
        add(btn);
        scroll = new JScrollPane(txt);
        scroll.setBounds(10, 10, 470, 380);

        add(scroll);
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                // dispose();
                // OutputStream outToServer = client.getOutputStream();
                // DataOutputStream out = new DataOutputStream(outToServer);
                // out.writeUTF("KEYLOG");
            }
        });

        btn.setBounds(100, 400, 100, 30);
        add(btn);        
        txt = new JTextArea();
        btn = new JButton("UNHOOK");

        btn.setBounds(150, 400, 100, 30);
        add(btn);
        scroll = new JScrollPane(txt);
        scroll.setBounds(10, 10, 470, 380);

        add(scroll);
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose();
            }
        });

        btn.setBounds(200, 400, 100, 30);
        add(btn);        
        txt = new JTextArea();
        btn = new JButton("PRINT");

        btn.setBounds(280, 400, 100, 30);
        add(btn);
        scroll = new JScrollPane(txt);
        scroll.setBounds(10, 10, 470, 380);

        add(scroll);
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    File myObj = new File("fileKeyLog.txt"); // lấy địa chỉ fileKeyLog của server để chạy
                    Scanner myReader = new Scanner(myObj);
                    while (myReader.hasNextLine()) {
                      String data = myReader.nextLine();
                      //System.out.println(data); // in ra màn hình
                      txt.append(data +"\t \n");
                    }
                    myReader.close();
                  } catch (FileNotFoundException agr) {
                    System.out.println("An error occurred.");
                    agr.printStackTrace();
                  }
            }
        });

        setLayout(null);
        setVisible(true);
    }

    

    public static void main(String[] args){
        new keylogCLIENT();
    }
}
