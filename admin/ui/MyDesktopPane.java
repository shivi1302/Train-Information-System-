/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.ui;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

/**
 *
 * @author Amar
 */
public class MyDesktopPane extends JDesktopPane {
    Image wallimage;
    public MyDesktopPane() {
        wallimage=new ImageIcon(getClass().getResource("/admin/ui/walltrain1.png")).getImage();
    }
    protected void paintComponent(Graphics g){
        if(wallimage!=null){
            g.drawImage(wallimage,0,0,getWidth(),getHeight(), this);
        }else{
            super.paintComponent(g);
        }
        }
    }
    

