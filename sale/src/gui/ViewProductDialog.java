package gui;
import domain.Product;
import gui.helpers.SimpleListModel;
import java.util.ArrayList;


/**
 *
 * @author liji8162
 */
public class ViewProductDialog extends javax.swing.JDialog {
	
	SimpleListModel viewProductsModel  = new SimpleListModel();
	//ArrayList<Product> currentProductList = myProductList.getProduct();
	
	
	
	
	
	
	
	
	
	
			  

	/**
	 * Creates new form ViewProductDialog
	 */
	public ViewProductDialog(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
		
		//this.viewProductsModel.updateItems(.getProductList());
		this.currentProductList.setModel(viewProductsModel);
		
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      jScrollPane1 = new javax.swing.JScrollPane();
      currentProductList = new javax.swing.JList<>();
      jLabel1 = new javax.swing.JLabel();
      editButton = new javax.swing.JButton();
      deleteButton = new javax.swing.JButton();
      closeButton = new javax.swing.JButton();

      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

      jScrollPane1.setName("jScrollPane1"); // NOI18N

      currentProductList.setModel(new javax.swing.AbstractListModel<String>() {
         String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
         public int getSize() { return strings.length; }
         public String getElementAt(int i) { return strings[i]; }
      });
      currentProductList.setName("currentProductList"); // NOI18N
      jScrollPane1.setViewportView(currentProductList);

      jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
      jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
      jLabel1.setText("View Products");
      jLabel1.setName("jLabel1"); // NOI18N

      editButton.setText("Edit");
      editButton.setName("editButton"); // NOI18N

      deleteButton.setText("Delete");
      deleteButton.setName("deleteButton"); // NOI18N

      closeButton.setText("Close");
      closeButton.setName("closeButton"); // NOI18N
      closeButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            closeButtonActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addGap(30, 30, 30)
                  .addComponent(editButton)
                  .addGap(85, 85, 85)
                  .addComponent(deleteButton)
                  .addGap(81, 81, 81)
                  .addComponent(closeButton))
               .addGroup(layout.createSequentialGroup()
                  .addGap(122, 122, 122)
                  .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(31, Short.MAX_VALUE))
         .addComponent(jScrollPane1)
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(closeButton)
               .addComponent(deleteButton)
               .addComponent(editButton)))
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

   private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
      // TODO add your handling code here:
		dispose();
   }//GEN-LAST:event_closeButtonActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(ViewProductDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(ViewProductDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(ViewProductDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(ViewProductDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the dialog */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				ViewProductDialog dialog = new ViewProductDialog(new javax.swing.JFrame(), true);
				dialog.addWindowListener(new java.awt.event.WindowAdapter() {
					@Override
					public void windowClosing(java.awt.event.WindowEvent e) {
						System.exit(0);
					}
				});
				dialog.setVisible(true);
			}
		});
	}

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton closeButton;
   private javax.swing.JList<String> currentProductList;
   private javax.swing.JButton deleteButton;
   private javax.swing.JButton editButton;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JScrollPane jScrollPane1;
   // End of variables declaration//GEN-END:variables
}
