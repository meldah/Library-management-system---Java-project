
package mainlibrary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ViewAllStudents extends javax.swing.JFrame {

    
    public ViewAllStudents() throws SQLException {
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        initComponents();
        DefaultTableModel model;
        model = (DefaultTableModel) jTable1.getModel();

        try(Connection Con = DB.getConnection()) 
        {
            PreparedStatement ps=Con.prepareStatement("select * from Users",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs= ps.executeQuery();
            
            ResultSetMetaData rsmd = rs.getMetaData();
  
            int colnum=rsmd.getColumnCount();
        
            String Row[];
            Row = new String[colnum];
            while(rs.next())
            {
                for(int i=1;i<=colnum;i++)
                {
                    Row[i-1]=rs.getString(i);
                }
                model.addRow(Row);
            }
            
            Con.close();
            
        }
        catch(Exception e){System.out.println(e);
    }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup3 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        exitBtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        userNameRadio = new javax.swing.JRadioButton();
        searchField = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        userEmailRadio = new javax.swing.JRadioButton();
        all = new javax.swing.JRadioButton();
        clearBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "User ID", "UserPass", "RegDate", "UserName", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel1.setText("Читатели");

        exitBtn.setText("Затвори");
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });

        userNameRadio.setText("Потребителско име");
        userNameRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameRadioActionPerformed(evt);
            }
        });

        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });

        searchBtn.setText("Търси");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        userEmailRadio.setText("Email");
        userEmailRadio.setToolTipText("");
        userEmailRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userEmailRadioActionPerformed(evt);
            }
        });

        all.setText("Всички");
        all.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allActionPerformed(evt);
            }
        });

        clearBtn.setText("Изчисти");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(958, 958, 958)
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchBtn)
                        .addGap(18, 18, 18)
                        .addComponent(clearBtn))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(524, 524, 524)
                        .addComponent(userNameRadio)
                        .addGap(42, 42, 42)
                        .addComponent(userEmailRadio)
                        .addGap(359, 359, 359)
                        .addComponent(all)))
                .addContainerGap(752, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userNameRadio)
                    .addComponent(userEmailRadio)
                    .addComponent(all))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBtn)
                    .addComponent(clearBtn))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(698, 698, 698)
                        .addComponent(exitBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1464, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(673, 673, 673)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(exitBtn)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed

        this.dispose();
    }//GEN-LAST:event_exitBtnActionPerformed

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
       
    }//GEN-LAST:event_searchFieldActionPerformed

    private void userNameRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameRadioActionPerformed
        
        userEmailRadio.setSelected(false);
        all.setSelected(false);
    }//GEN-LAST:event_userNameRadioActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed

        DefaultTableModel model;
        model = (DefaultTableModel) jTable1.getModel();
        while(model.getRowCount()>0)
        {
            model.removeRow(model.getRowCount()-1);
        }
        if(userNameRadio.isSelected())
        {   
            String Search = "%"+searchField.getText()+"%";
            try(Connection Con = DB.getConnection()) 
            {
                PreparedStatement ps=Con.prepareStatement("select * from Users where UserName like ?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                ps.setString(1, Search);
                ResultSet rs= ps.executeQuery();

                ResultSetMetaData rsmd = rs.getMetaData();

                int colnum=rsmd.getColumnCount();
                String Row[] = new String[colnum];
                while(rs.next())
                {
                    for(int i=1;i<=colnum;i++)
                    {
                        Row[i-1]=rs.getString(i);
                    }
                    model.addRow(Row);
                }
                int rowcount = model.getRowCount();
                System.out.println(rowcount);
                if(rowcount==0)
                {
                    String NoRow[];
                    NoRow = new String[7];
                    NoRow[1]="Няма";
                    NoRow[2]="резултат!";
                    NoRow[0]="";
                    NoRow[3]="";
                    NoRow[4]="";
                    NoRow[5]="";
                    NoRow[6]="";
                    model.addRow(NoRow);
                }
                 
                Con.close();
            }
            catch(Exception e)
            {
                System.out.println(e);
            } 
        }
        else if(userEmailRadio.isSelected())
        {
            String Search = "%"+searchField.getText()+"%";
            try(Connection Con = DB.getConnection()) 
            {
                PreparedStatement ps=Con.prepareStatement("select * from Users where Email like ?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                ps.setString(1, Search);
                ResultSet rs= ps.executeQuery();

                ResultSetMetaData rsmd = rs.getMetaData();
  
                int colnum=rsmd.getColumnCount();
            
                String Row[];
                Row = new String[colnum];
                while(rs.next())
                {
                    for(int i=1;i<=colnum;i++)
                    {
                        Row[i-1]=rs.getString(i);
                    }
                    model.addRow(Row);
                }
                int rowcount = model.getRowCount();
                System.out.println(rowcount);
                if(rowcount==0)
                {
                    String NoRow[];
                    NoRow = new String[7];
                    NoRow[1]="Няма";
                    NoRow[2]="резултат!";
                    NoRow[0]="";
                    NoRow[3]="";
                    NoRow[4]="";
                    NoRow[5]="";
                    NoRow[6]="";
                    model.addRow(NoRow);
                
                
                }
                Con.close();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }       
        else
        {    
            JOptionPane.showMessageDialog(ViewAllStudents.this, "Изберете Име или Имейл!","Грешка!", JOptionPane.ERROR_MESSAGE);
        }           
    }//GEN-LAST:event_searchBtnActionPerformed

    private void userEmailRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userEmailRadioActionPerformed

        userNameRadio.setSelected(false);
        all.setSelected(false);
    }//GEN-LAST:event_userEmailRadioActionPerformed

    private void allActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allActionPerformed

          userNameRadio.setSelected(false);
          userEmailRadio.setSelected(false);
          searchField.setText("");
          DefaultTableModel model;
        model = (DefaultTableModel) jTable1.getModel();
          while(model.getRowCount()>0)
          {
            model.removeRow(model.getRowCount()-1);
          }
        try(Connection Con = DB.getConnection()) 
        {
            PreparedStatement ps=Con.prepareStatement("select * from Users",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs= ps.executeQuery();
            
           ResultSetMetaData rsmd = rs.getMetaData();
  
            int colnum=rsmd.getColumnCount();
            String Row[];
            Row = new String[colnum];
            while(rs.next()){
                for(int i=1;i<=colnum;i++){
                    Row[i-1]=rs.getString(i);
                    }
                 model.addRow(Row);
            }

           Con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }//GEN-LAST:event_allActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        searchField.setText("");
    }//GEN-LAST:event_clearBtnActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewAllStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewAllStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewAllStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewAllStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ViewAllStudents().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ViewAllStudents.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton all;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JButton clearBtn;
    private javax.swing.JButton exitBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchField;
    private javax.swing.JRadioButton userEmailRadio;
    private javax.swing.JRadioButton userNameRadio;
    // End of variables declaration//GEN-END:variables


}
