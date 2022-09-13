package ex0908;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Notepad extends JFrame {

	 public JTextArea ta = new JTextArea();
	    JFileChooser chooser = new JFileChooser();
	    JMenuBar mb = new JMenuBar();
	    String fileName = "";
	    // 생성자
	    public Notepad() {
	        
	        this.setTitle("Notepad");
	        this.setSize(500, 500);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
	        // 2. 메뉴생성
	        String[] smenu = { "파일" };
	        JMenu[] mfile = new JMenu[10];
	        for (int i = 0; i < smenu.length; i++) {
	            mfile[i] = new JMenu(smenu[i]);
	            mb.add(mfile[i]);
	        }
	 
	 
	        String[] ScrItem = { "새파일", "열기", "저장", "다른이름으로저장", "종료" };
	        JMenuItem[] item = new JMenuItem[5];
	        for (int i = 0; i < ScrItem.length; i++) {
	            item[i] = new JMenuItem(ScrItem[i]);
	            // 1. 이벤트 소스: JMenuItem
	            // 2. 이벤트 종류: ActionEvent
	            // 3. 리스너 구현: ActionListener - > 독립리스너
	            // 4. 리스너 연결
	            NoteActionListener nal = new NoteActionListener(this);
	            item[i].addActionListener(nal);
	            // 4. 메뉴바 설정
	            this.setJMenuBar(mb);
	            mfile[0].add(item[i]);
	 
	        }
	        
	        // 컴포넌트 추가
	        this.add(ta);
	 
	        this.setVisible(true);
	    }
	    /* 새파일 */
	    public void newFile() {
	        ta.setText("");
	    }
	 
	    /* 열기 */
	    public void openFile() {
	 
	        int ret = chooser.showOpenDialog(null);
	 
	        if (ret != JFileChooser.APPROVE_OPTION) {
	 
	            JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.", "경고", JOptionPane.WARNING_MESSAGE);
	            return;
	 
	        } else {
	            File inFile = chooser.getSelectedFile();
	            BufferedReader in;
	            try {
	                in = new BufferedReader(new FileReader(inFile));
	                String c;
	                ta.setText("");
	                while ((c = in.readLine()) != null) {
	                    ta.append(c + "\r\n");
	                }
	                in.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	 
	        }
	        fileName = chooser.getSelectedFile().toString();
	        setTitle(chooser.getSelectedFile().getName());
	    }
	 
	    /* 파일 저장 */
	    public void saveFile(String fn) {
	          BufferedWriter out = null;
	          File file = new File(fileName);
	          try {
	             out = new BufferedWriter(new FileWriter(file));
	             out.write(fn);
	             this.setTitle(file.getName());
	             out.close();
	          }
	          catch(IOException e) {
	             e.printStackTrace();
	          }
	       }
	 
	    
	    public static void main(String[] args) {
	        new Notepad();
	    }
	 
	}