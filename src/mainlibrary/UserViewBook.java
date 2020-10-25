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


public class UserViewBook extends javax.swing.JFrame {

    public UserViewBook() throws SQLException {
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        
        initComponents();
        DefaultTableModel model;
        model = (DefaultTableModel) jTable1.getModel();
        try(Connection Con = DB.getConnection()) {
            PreparedStatement ps=Con.prepareStatement("select Books.BookID, Books.BookName,Books.Genre,Books.Author,Books.Publisher, Books.RowN,Books.Shelf, IssuedBook.UserID from Books left outer join IssuedBook on Books.BookID= IssuedBook.BookID;",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs= ps.executeQuery();
            
           ResultSetMetaData rsmd = rs.getMetaData();
  
            int colnum=rsmd.getColumnCount();
        
            
            String Row[];
            String Check="";
            Row = new String[colnum];
            while(rs.next()){
                for(int i=1;i<=colnum;i++){
                    if(i==colnum)
                    {
                        if(rs.getString(i)==null)
                            Row[i-1]="Не е заета!";
                        else
                            Row[i-1]="Заета!";
                        System.out.println(rs.getString(i));
                    }
                  else
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
        exitbtn = new javax.swing.JButton();
        nameRadio = new javax.swing.JRadioButton();
        authorRadio = new javax.swing.JRadioButton();
        all = new javax.swing.JRadioButton();
        notIssued = new javax.swing.JRadioButton();
        searchField = new javax.swing.JTextField();
        search = new javax.swing.JButton();
        showALL = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Book ID", "Name", "Genre", "Author", "Publisher", "Shelf", "Row", "Available"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false,  false,false
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
        jLabel1.setText("Всички книги");

        exitbtn.setText("Затвори");
        exitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitbtnActionPerformed(evt);
            }
        });

        nameRadio.setText("Име");
        nameRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameRadioActionPerformed(evt);
            }
        });

        authorRadio.setText("Автор");
        authorRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                authorRadioActionPerformed(evt);
            }
        });

        all.setText("Всички");
        all.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allActionPerformed(evt);
            }
        });

        notIssued.setText("Незаети");
        notIssued.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notIssuedActionPerformed(evt);
            }
        });

        search.setText("Търси");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        showALL.setText("Покажи всички");
        showALL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showALLActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(search)
                .addGap(18, 18, 18)
                .addComponent(showALL)
                .addGap(161, 161, 161))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(698, 698, 698)
                        .addComponent(exitbtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1464, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(452, 452, 452)
                        .addComponent(nameRadio)
                        .addGap(30, 30, 30)
                        .addComponent(authorRadio)
                        .addGap(308, 308, 308)
                        .addComponent(all)
                        .addGap(40, 40, 40)
                        .addComponent(notIssued))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(657, 657, 657)
                        .addComponent(jLabel1)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameRadio)
                    .addComponent(authorRadio)
                    .addComponent(all)
                    .addComponent(notIssued))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search)
                    .addComponent(showALL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(exitbtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitbtnActionPerformed

        this.dispose();
    }//GEN-LAST:event_exitbtnActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed

        if(searchField.getText()=="")
      JOptionPane.showMessageDialog(UserViewBook.this, "Полето за търсене е празно!","Грешка при търсене!", JOptionPane.ERROR_MESSAGE);

        if(!all.isSelected())
            if(!notIssued.isSelected())
            all.setEnabled(true);
        
        int flag=0;
        if(all.isSelected())
            flag=0;
        if(notIssued.isSelected())
            flag=1;
        DefaultTableModel model;
        model = (DefaultTableModel) jTable1.getModel();
        while(model.getRowCount()>0)
            model.removeRow(model.getRowCount()-1);
        if(nameRadio.isSelected())
        {

            String Search = "%"+searchField.getText()+"%";
        try(Connection Con = DB.getConnection()) {
            PreparedStatement ps=Con.prepareStatement("select A.BookID, A.BookName,A.Genre,A.Author,A.Publisher, A.RowN,A.Shelf, IssuedBook.UserID from (select * from Books where BookName like ?) as A left outer join IssuedBook on A.BookID= IssuedBook.BookID",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ps.setString(1, Search);
            ResultSet rs= ps.executeQuery();
            
           ResultSetMetaData rsmd = rs.getMetaData();
  
            int colnum=rsmd.getColumnCount();
            
            String Row[];
            Row = new String[colnum];
            while(rs.next()){
                for(int i=1;i<=colnum;i++){
                    if(i==colnum)
                    {
                        if(rs.getString(i)==null)
                        {
                            Row[i-1]="Не е заета!";
                            model.addRow(Row);
                        }
                        else
                        {
                            if(flag==1)
                                continue;
                            Row[i-1]="Заета";
                            model.addRow(Row);
                            
                        }
                                             
                        System.out.println(rs.getString(i));
                    }
                  else
                    {
                    Row[i-1]=rs.getString(i);
                    }                    
                }
        
               
            }
            int rowcount = model.getRowCount();
             System.out.println(rowcount);
            if(rowcount==0)
            {
                String NoRow[];
                NoRow = new String[7];
                NoRow[3]="Няма";
                NoRow[4]="резултат!";
                NoRow[0]="";
                NoRow[1]="";
                NoRow[2]="";
                NoRow[5]="";
                NoRow[6]="";
                model.addRow(NoRow);
                
                
            }

            
           Con.close();
        }catch(Exception e){System.out.println(e);
    } }
        
        else if(authorRadio.isSelected())
        {
            
            String Search = "%"+searchField.getText()+"%";
        try(Connection Con = DB.getConnection()) {
            PreparedStatement ps=Con.prepareStatement("select A.BookID, A.BookName,A.Genre,A.Author,A.Publisher, A.RowN,A.Shelf, IssuedBook.UserID from (select * from Books where Author like ?) as A left outer join IssuedBook on A.BookID= IssuedBook.BookID",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ps.setString(1, Search);
            ResultSet rs= ps.executeQuery();
            
           ResultSetMetaData rsmd = rs.getMetaData();
  
            int colnum=rsmd.getColumnCount();
            

            String Row[];
            Row = new String[colnum];
            while(rs.next()){
                for(int i=1;i<=colnum;i++){
                    if(i==colnum)
                    {
                        if(rs.getString(i)==null)
                        {
                            Row[i-1]="Не е заета!";
                            model.addRow(Row);
                        }
                        else
                        {
                            if(flag==1)
                                continue;
                            Row[i-1]="Заета!";
                            model.addRow(Row);
                        }
                        System.out.println(rs.getString(i));
                    }
                  else
                    Row[i-1]=rs.getString(i);
                    }
          
            }
            int rowcount = model.getRowCount();
             System.out.println(rowcount);
            if(rowcount==0)
            {
                String NoRow[];
                NoRow = new String[7];
                NoRow[3]="Няма";
                NoRow[4]="резултат!";
                NoRow[0]="";
                NoRow[1]="";
                NoRow[2]="";
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
            
				JOptionPane.showMessageDialog(UserViewBook.this, "Изберете име или автор!","Грешка!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_searchActionPerformed

    private void authorRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_authorRadioActionPerformed
        
        nameRadio.setSelected(false);
    }//GEN-LAST:event_authorRadioActionPerformed

    private void nameRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameRadioActionPerformed
        
        authorRadio.setSelected(false);
    }//GEN-LAST:event_nameRadioActionPerformed

    private void allActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allActionPerformed
        
        notIssued.setSelected(false);
      
    }//GEN-LAST:event_allActionPerformed

    private void notIssuedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notIssuedActionPerformed
        
        all.setSelected(false);
        
    }//GEN-LAST:event_notIssuedActionPerformed

    private void showALLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showALLActionPerformed

        authorRadio.setSelected(false);
        nameRadio.setSelected(false);
          DefaultTableModel model;
        model = (DefaultTableModel) jTable1.getModel();
         while(model.getRowCount()>0)
            model.removeRow(model.getRowCount()-1);
         
         
         if(!all.isSelected()&&!notIssued.isSelected())
         {
             all.setSelected(true);
         }
         
         
         int flag=0;
         if(all.isSelected())
             flag=0;
         if(notIssued.isSelected())
             flag=1;

        try(Connection Con = DB.getConnection()) {
            PreparedStatement ps=Con.prepareStatement("select Books.BookID, Books.BookName,Books.Genre,Books.Author,Books.Publisher, Books.RowN,Books.Shelf, IssuedBook.UserID from Books left outer join IssuedBook on Books.BookID= IssuedBook.BookID;",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs= ps.executeQuery();
            
           ResultSetMetaData rsmd = rs.getMetaData();
  
            int colnum=rsmd.getColumnCount();
        
            
            String Row[];
            String Check="";
            Row = new String[colnum];
            while(rs.next()){
                for(int i=1;i<=colnum;i++){
                    if(i==colnum)
                    {
                         if(rs.getString(i)==null)
                        {
                            Row[i-1]="Не е заета!";
                            model.addRow(Row);
                        }
                        else
                        {
                            if(flag==1)
                                continue;
                            Row[i-1]="Заета!";
                            model.addRow(Row);
                        }
                        System.out.println(rs.getString(i));
                    }
                  else
                    Row[i-1]=rs.getString(i);
            
                    }
                  
            }
   
           Con.close();
        }catch(Exception e){System.out.println(e);
    }
    }//GEN-LAST:event_showALLActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserViewBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserViewBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserViewBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserViewBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new UserViewBook().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(UserViewBook.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton all;
    private javax.swing.JRadioButton authorRadio;
    private javax.swing.JButton exitbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton nameRadio;
    private javax.swing.JRadioButton notIssued;
    private javax.swing.JButton search;
    private javax.swing.JTextField searchField;
    private javax.swing.JButton showALL;
    // End of variables declaration//GEN-END:variables


}
