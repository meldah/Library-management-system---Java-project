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


public class ViewAllIssuedBooks extends javax.swing.JFrame {

   
    public ViewAllIssuedBooks() throws SQLException {
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        
        initComponents();
        DefaultTableModel model;
        model = (DefaultTableModel) jTable1.getModel();

        try(Connection Con = DB.getConnection()) {
        PreparedStatement ps=Con.prepareStatement("select IssuedBook.BookID,IssuedBook.UserID,Books.BookName , IssuedBook.IssueDate, IssuedBook.ReturnDate from Books,IssuedBook where Books.BookID=IssuedBook.BookID;",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
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
        }catch(Exception e){System.out.println(e);
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        exitBtn = new javax.swing.JButton();
        nameRadio = new javax.swing.JRadioButton();
        bookIDRadio = new javax.swing.JRadioButton();
        all = new javax.swing.JRadioButton();
        searchField = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        userIDRadio = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Book ID","User ID", "Book Name", "Issued Date", "Return Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jTable1.setRowHeight(20);
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel1.setText("Заети книги");

        exitBtn.setText("Затвори");
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });

        nameRadio.setText("Име");
        nameRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameRadioActionPerformed(evt);
            }
        });

        bookIDRadio.setText("ID на книга");
        bookIDRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookIDRadioActionPerformed(evt);
            }
        });

        all.setText("Всички");
        all.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allActionPerformed(evt);
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

        userIDRadio.setText("ID на читател");
        userIDRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userIDRadioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(698, 698, 698)
                        .addComponent(exitBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(642, 642, 642)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(365, 365, 365)
                        .addComponent(nameRadio)
                        .addGap(47, 47, 47)
                        .addComponent(bookIDRadio)
                        .addGap(43, 43, 43)
                        .addComponent(userIDRadio)
                        .addGap(247, 247, 247)
                        .addComponent(all)))
                .addContainerGap(649, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(searchBtn)
                        .addGap(464, 464, 464))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1575, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameRadio)
                    .addComponent(bookIDRadio)
                    .addComponent(all)
                    .addComponent(userIDRadio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBtn))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(exitBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        
        this.dispose();
        LibrarianSuccess.ThisLogined.setVisible(true);
    }//GEN-LAST:event_exitBtnActionPerformed

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        
    }//GEN-LAST:event_searchFieldActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        
        
        DefaultTableModel model;
        model = (DefaultTableModel) jTable1.getModel();
        while(model.getRowCount()>0)
        model.removeRow(model.getRowCount()-1);
        if(nameRadio.isSelected())
        {
       
            String Search = "%"+searchField.getText()+"%";
            try(Connection Con = DB.getConnection()) {
            PreparedStatement ps=Con.prepareStatement("select IssuedBook.BookID,IssuedBook.UserID,Books.BookName , IssuedBook.IssueDate, IssuedBook.ReturnDate from Books,IssuedBook where Books.BookID=IssuedBook.BookID and Books.BookName like ?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ps.setString(1, Search);
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
        }catch(Exception e){System.out.println(e);
            } 
    }
    else if(bookIDRadio.isSelected())
    {

            String Search = searchField.getText();
            int BookIDV;
            BookIDV = Integer.parseInt(Search);
            try(Connection Con = DB.getConnection()) {
            PreparedStatement ps=Con.prepareStatement("select IssuedBook.BookID,IssuedBook.UserID,Books.BookName , IssuedBook.IssueDate, IssuedBook.ReturnDate from Books,IssuedBook where Books.BookID=IssuedBook.BookID and IssuedBook.BookID=?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ps.setInt(1,BookIDV);
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
            int rowcount = model.getRowCount();
             System.out.println(rowcount);
            if(rowcount==0)
            {
                String NoRow[];
                NoRow = new String[7];
                NoRow[1]="Няма";
                NoRow[2]="резулат!";
                NoRow[0]="";
                NoRow[3]="";
                NoRow[4]="";
                NoRow[5]="";
                NoRow[6]="";
                model.addRow(NoRow);  
            }
        
           Con.close();
        }catch(Exception e){System.out.println(e);
            }
    }
    else if(userIDRadio.isSelected())
    {
            
            String Search = searchField.getText();
            int UserIDV;
            UserIDV = Integer.parseInt(Search);
            try(Connection Con = DB.getConnection()) {
            PreparedStatement ps=Con.prepareStatement("select IssuedBook.BookID,IssuedBook.UserID,Books.BookName , IssuedBook.IssueDate, IssuedBook.ReturnDate from Books,IssuedBook where Books.BookID=IssuedBook.BookID and IssuedBook.UserID=?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ps.setInt(1,UserIDV);
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
            }catch(Exception e){System.out.println(e);
                }
        }       
        else
        {         
            JOptionPane.showMessageDialog(ViewAllIssuedBooks.this, "Изберете Име или Автор!","Грешка!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_searchBtnActionPerformed

    private void bookIDRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookIDRadioActionPerformed
       
        nameRadio.setSelected(false);
        all.setSelected(false);
        userIDRadio.setSelected(false);
    }//GEN-LAST:event_bookIDRadioActionPerformed

    private void nameRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameRadioActionPerformed
        
        bookIDRadio.setSelected(false);
        all.setSelected(false);
        userIDRadio.setSelected(false);
        
    }//GEN-LAST:event_nameRadioActionPerformed

    private void allActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allActionPerformed
       
        searchField.setText("");
        DefaultTableModel model;
        model = (DefaultTableModel) jTable1.getModel();
        while(model.getRowCount()>0)
            model.removeRow(model.getRowCount()-1);
          try(Connection Con = DB.getConnection()) {
            PreparedStatement ps=Con.prepareStatement("select IssuedBook.BookID,IssuedBook.UserID,Books.BookName , IssuedBook.IssueDate, IssuedBook.ReturnDate from Books,IssuedBook where Books.BookID=IssuedBook.BookID;",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
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
        }catch(Exception e){System.out.println(e);
        }
    }//GEN-LAST:event_allActionPerformed

    private void userIDRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userIDRadioActionPerformed

        all.setSelected(false);
        nameRadio.setSelected(false);
        bookIDRadio.setSelected(false);    
    }//GEN-LAST:event_userIDRadioActionPerformed

    
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewAllIssuedBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewAllIssuedBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewAllIssuedBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewAllIssuedBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ViewAllIssuedBooks().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ViewAllIssuedBooks.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton all;
    private javax.swing.JRadioButton bookIDRadio;
    private javax.swing.JButton exitBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton nameRadio;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchField;
    private javax.swing.JRadioButton userIDRadio;
    // End of variables declaration//GEN-END:variables


}
