package gui;
import dao.ProductList;
import domain.Product;
import gui.helpers.SimpleListModel;
import java.util.Collection;




/**
 *
 * @author liji8162
 */
public class ViewProductDialog extends javax.swing.JDialog {
	/**this instance of list from dao package is the list holds all the 
	 * product objects that typed by users
	 * since the collection of Product is static, we can refer it in the entire
	 * system  */
	private ProductList myProductList = new ProductList();
	SimpleListModel viewProductsModel  = new SimpleListModel();
	/**the instance of the list is just an object. if we get the products that 
	 * users typed in the system, normally users add new product one by one,
	 * so we update the product one by one using update method in SimpleListModel
	 * object.*/
	Collection<Product> getProductList = myProductList.getProducts();
	
	/**
	 * Creates new form ViewProductDialog
	 */
	public ViewProductDialog(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
		
		this.viewProductsModel.updateItems(getProductList);
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
      deleteButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            deleteButtonActionPerformed(evt);
         }
      });

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
            .addGap(30, 30, 30)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
               .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addComponent(jScrollPane1)
               .addGroup(layout.createSequentialGroup()
                  .addComponent(editButton, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                  .addGap(85, 85, 85)
                  .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                  .addGap(77, 77, 77)
                  .addComponent(closeButton, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)))
            .addGap(130, 130, 130))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGap(299, 299, 299))
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                  .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGap(18, 18, 18)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(closeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addComponent(editButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

   private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
      
		dispose();
   }//GEN-LAST:event_closeButtonActionPerformed

   private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
      Product copyOfProductList = (Product)currentProductList.getSelectedValue();
		myProductList.deleteProduct(copyOfProductList);
		this.viewProductsModel.updateItems(getProductList);
		
		
		
   }//GEN-LAST:event_deleteButtonActionPerformed

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

	/*JList by default holds strings, went to properties to change the generics*/
   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton closeButton;
   private javax.swing.JList<Product> currentProductList;
   private javax.swing.JButton deleteButton;
   private javax.swing.JButton editButton;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JScrollPane jScrollPane1;
   // End of variables declaration//GEN-END:variables
}
