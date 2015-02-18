/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainPage.java
 *
 * Created on Jan 27, 2012, 2:05:29 PM
 */


package compression;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

/**
 *
 * @author ankita
 */
public class MainPage extends javax.swing.JFrame {

    private int progress = 0;
    private int waitTime = 7;


    public MainPage() {
        initComponents();
        centerWindow();
        jProgressBar1.setValue(0);


               
        Border border = BorderFactory.createEtchedBorder(Color.darkGray, Color.LIGHT_GRAY);
        jProgressBar1.setStringPainted(true);
    	jProgressBar1.setBorder(border);
        jProgressBar1.setOpaque(true);
        doSplashStuff();

    }
    void centerWindow(){
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();

        setLocation((screensize.width / 2) - (getSize().width / 2),
                    (screensize.height / 2) - (getSize().height / 2));
		}
    public void doSplashStuff(){

		final int pause = waitTime;


		final Runnable updateRunner = new Runnable() {
			public void run(){
				jProgressBar1.setValue(progress);
				}
		};


		final Runnable closerRunner = new Runnable()
		{
		public void run() {
			//setVisible(false);
			dispose();
		}
		};

		Runnable waitRunner = new Runnable() {
			public void run() {
				try {
					int sec = pause;
					for(int i = 0;i<sec;i++){
						progress += Math.round(Math.random()*(200/sec) + 1);
						progress = Math.min(100,progress);
						if(i >= sec - 1) progress = 100;
						SwingUtilities.invokeLater(updateRunner);
						Thread.sleep(1000);

						}
					//Thread.sleep(1000); //one more for luck ;)
					SwingUtilities.invokeAndWait(closerRunner);
                                        
                                        new Welcome_1().setVisible(true);
                                        setVisible(false);
                                        
				}catch(Exception e){}
			}

		};


		Thread splashThread = new Thread(waitRunner, "SplashThread");
		splashThread.start();
	}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Welcome To POWERDESK...");
        setBackground(new java.awt.Color(204, 204, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        setForeground(new java.awt.Color(0, 0, 0));
        setName(""); // NOI18N
        setResizable(false);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        jPanel1.setFont(new java.awt.Font("Comic Sans MS", 1, 18));

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compression/Resources/Files In A Single Software.jpg"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Monotype Corsiva", 1, 72)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 255, 255));
        jLabel2.setText("   POWERDESK");
        jLabel2.setDebugGraphicsOptions(javax.swing.DebugGraphics.FLASH_OPTION);
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel2.setIconTextGap(7);

        jProgressBar1.setBackground(new java.awt.Color(204, 204, 204));
        jProgressBar1.setForeground(new java.awt.Color(0, 0, 0));
        jProgressBar1.setToolTipText("Loading Modules");
        jProgressBar1.setAutoscrolls(true);
        jProgressBar1.setBorder(new javax.swing.border.MatteBorder(null));
        jProgressBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        jProgressBar1.setName(""); // NOI18N
        jProgressBar1.setOpaque(true);
        jProgressBar1.setStringPainted(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(jLabel1)
                .addContainerGap(159, Short.MAX_VALUE))
            .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(75, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPage().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables

}
