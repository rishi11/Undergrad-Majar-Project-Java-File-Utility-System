/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AllFiles.java
 *
 * Created on Apr 14, 2012, 2:17:53 PM
 */

package compression;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.awt.Desktop;
import java.io.File;

public class AllFiles extends javax.swing.JFrame {
 String[] str=new String[100];
    /** Creates new form AllFiles */
    public AllFiles() {
        initComponents();
        centerWindow();
    }
void centerWindow(){
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();

        setLocation((screensize.width / 2) - (getSize().width / 2),
                    (screensize.height / 2) - (getSize().height / 2));
		}

	/**
	 * This will retrieve a list of all files from current
	 * folder and all sub folders
	 *
	 * @param rootDir - path of the starting directory
	 * @return A list of Files
	 */
	public static ArrayList<File> retriveAllFiles( String rootDir){
    	ArrayList<File> tempList = new ArrayList<File>();
    	File theRootDir = new File(rootDir);

       //Retrieve all folders (current and any sub)
    	ArrayList<File> folders = getAllDir(theRootDir);

    	//For all of the folders
    	for (int i = 0; i < folders.size(); i++) {

    		//Get all the files in the folder
            File[] currentFile = folders.get(i).listFiles();
            for (int k = 0; k < currentFile.length; k++) {

            	//If the current file isn't a directory
            	//Add it to the list of all files
            	if( currentFile[k].isDirectory() == false){
            		tempList.add(currentFile[k]);
            	}
            }
        }
    	return tempList;
    }

	/**
	 * This will retrieve a list of files from only the current
	 * directory
	 *
	 * @param rootDir - path of the starting directory
	 * @return A list of Files
	 */
	public static ArrayList<File> retriveFiles (String rootDir){
		File f = new File( rootDir );
		ArrayList<File> temp = new ArrayList<File>();
		File[] currentFile = f.listFiles();
        for (int k = 0; k < currentFile.length; k++) {
        	//If the current file isn't a directory
        	//Add it to the list of all files
        	if( currentFile[k].isDirectory() == false){
        		temp.add(currentFile[k]);
        	}
        }
		return temp;
	}

	/**
	 * Will iterate through all directories gathering all folders & sub folders
	 *
	 * @param rootURL - starting File
	 * @return A list of ALL folders inside of the root URL
	 */
    private static ArrayList<File> getAllDir(File rootURL) {

        ArrayList<File> temp = new ArrayList<File>(), //This will hold our queued folders
                		fill = new ArrayList<File>(), //List of end results
                		subs = new ArrayList<File>(); //Sub folders

        //Add our initial to start search (Breadth First Search)
        temp.add(rootURL);
        while (!temp.isEmpty()) {

        	//Dequeue Folder
            File next = temp.remove(0);

            //Add it to the return list if not done so already and not blank
            if (!fill.contains(next) && !next.getAbsolutePath().equals("")) {
                fill.add(next);
            }

            //Get sub folders
            subs = getSubs(next);

            //for each folder, add it to temp if not done so already
            for (File s : subs) {
                if (!temp.contains(s)) {
                    temp.add(s);
                }
            }
            //clear for next iteration
            subs.clear();
        }
        return fill;
    }

    /**
     * This method will retrieve all the sub folders from the current directory
     * that was passed in
     * @param cur - Current directory that the user is in
     * @return A list of folders
     */
    private static ArrayList<File> getSubs(File cur) {

    	//Get a list of all the files in folder
        ArrayList<File> temp = new ArrayList<File>();
        File[] fileList = cur.listFiles();

        //for each file in the folder
        for (int i = 0; i < fileList.length; i++) {

        	//If the file is a Directory(folder) add it to return, if not done so already
            File choose = fileList[i];
            if ( choose.isDirectory() && !temp.contains(choose)) {
                temp.add(choose);
            }
        }
        return temp;
    }



    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("POWERDESK----File Finder");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Monotype Corsiva", 1, 78));
        jLabel1.setForeground(new java.awt.Color(153, 255, 255));
        jLabel1.setText("POWERDESK");

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 18));
        jLabel2.setForeground(new java.awt.Color(255, 204, 204));
        jLabel2.setText("Directory :");

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 18));
        jLabel3.setForeground(new java.awt.Color(255, 204, 204));
        jLabel3.setText("File Name :");

        jButton3.setFont(new java.awt.Font("SansSerif", 0, 18));
        jButton3.setText("Search");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "C:\\\\", "D:\\\\", "E:\\\\", "F:\\\\", "G:\\\\", "H:\\\\", "I:\\\\" }));
            jComboBox1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jComboBox1ActionPerformed(evt);
                }
            });

            jLabel5.setFont(new java.awt.Font("SansSerif", 0, 18));
            jLabel5.setForeground(new java.awt.Color(255, 204, 204));
            jLabel5.setText("Drive :");

            jLabel6.setBackground(new java.awt.Color(0, 51, 51));
            jLabel6.setForeground(new java.awt.Color(204, 0, 0));

            jLabel7.setFont(new java.awt.Font("SansSerif", 0, 18));
            jLabel7.setForeground(new java.awt.Color(255, 204, 204));
            jLabel7.setText("Search Results :");

            jLabel8.setFont(new java.awt.Font("Monotype Corsiva", 1, 36));
            jLabel8.setForeground(new java.awt.Color(204, 204, 255));
            jLabel8.setText("FILE FINDER");

            jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compression/Resources/FileSearch.jpg"))); // NOI18N

            jButton1.setFont(new java.awt.Font("SansSerif", 0, 18));
            jButton1.setText("Back");
            jButton1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton1ActionPerformed(evt);
                }
            });

            jButton2.setFont(new java.awt.Font("SansSerif", 0, 18));
            jButton2.setText("Clear");
            jButton2.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton2ActionPerformed(evt);
                }
            });

            jList1.setForeground(new java.awt.Color(255, 102, 102));
            jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
            jScrollPane2.setViewportView(jList1);

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(22, 22, 22)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
                                            .addGap(48, 48, 48))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel7))
                                            .addGap(18, 18, 18)))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(63, 63, 63)
                                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButton2)
                                            .addGap(27, 27, 27))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, 342, Short.MAX_VALUE)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE))
                                            .addContainerGap())
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                                                .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE))
                                            .addContainerGap())))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(67, 67, 67)
                                    .addComponent(jLabel8)
                                    .addContainerGap())))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(71, 71, 71))))
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(32, 32, 32)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(51, 51, 51)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(46, 46, 46)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(41, 41, 41)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(35, 35, 35)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton3)
                                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addComponent(jLabel7)))
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(200, 200, 200))
            );

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    if(jTextField1.getText().equals("")|| jTextField2.getText().equals("")){
                
                 JOptionPane.showMessageDialog((Container)null,"Enter all Fields","",JOptionPane.OK_OPTION);
    
    }        
    else{
                String startingPath = jComboBox1.getSelectedItem().toString();
		String DirToBeSearched="";



		DirToBeSearched = startingPath+jTextField1.getText();



		String FileToBeSearched=new String();
		FileToBeSearched= jTextField2.getText();

		ArrayList<File> newList = AllFiles.retriveAllFiles(DirToBeSearched);
                int ctr=0,i=0;
		for( File f: newList){

			

			if(FileToBeSearched.equalsIgnoreCase(f.getName())||f.getName().matches(".*"+FileToBeSearched+".*"))
				{      
//					jTextArea1.append("File Found..........\n");
//                                      jTextArea1.append( f.getName() + ": " + f.getPath() +"\n");
                                        str[ctr]=f.getName() + ": " + f.getPath();
                                        jList1.setListData(str);
                                        ctr++;
                                        jList1.setSelectedIndex(0);
                        }
                       
                }
                if(jList1.getSelectedValue()==null){
                    str[0]="SORRY!!!!!  File not found.....";
                    jList1.setListData(str);                }




//                if(jTextArea1.getText().equals(""))
//                            {
//                                        jTextArea1.append("SORRY!!! File not found.....\n");
//                             }
    }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
new Welcome_1().setVisible(true);
this.setVisible(false);// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        for(int i=0;i<100;i++){str[i]="";}
        jTextField1.setText("");
        jTextField2.setText("");
         jList1.setListData(str);
      //  jTextArea1.setText("");        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AllFiles().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

}
