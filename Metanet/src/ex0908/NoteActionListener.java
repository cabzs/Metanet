package ex0908;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
 
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
 
public class NoteActionListener implements ActionListener {
    // 멤버변수
    private Notepad frm;
    String cmd;
    // 생성자
    public NoteActionListener(Notepad n) {
        this.frm = n;
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        cmd = e.getActionCommand();
        switch (cmd) {
 
        case "새파일":
            frm.newFile();
            break;
        case "열기":
            frm.openFile();
            break;
        case "저장":
            if(frm.fileName.equals("")) { //다른이름으로 저장과 일반 저장을 구분하기 위함, 처음 실행시 일반저장버튼을 눌렀을때 chooser가 열리도록 함
                   int ret = frm.chooser.showSaveDialog(null);
                   
                   if(ret != frm.chooser.APPROVE_OPTION) {
                      JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다!", "경고", JOptionPane.WARNING_MESSAGE);
                      return;
                   }
                   
                   frm.fileName = frm.chooser.getSelectedFile().getPath();
                }
                frm.saveFile(frm.ta.getText()); //저장
                
                break;
        case "다른이름으로저장": //무조건 chooser로 다이얼로그 열어서 저장
                int ret = frm.chooser.showSaveDialog(null);
                if (ret == JFileChooser.APPROVE_OPTION) {
                    frm.fileName = frm.chooser.getSelectedFile().getPath();
                    frm.saveFile(frm.ta.getText());
                }
                
            break;
        case "종료":
            //frm.windowClosing(null);
            break;
        }
 
    }
 
}