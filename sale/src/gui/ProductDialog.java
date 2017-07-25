package gui;

import java.math.BigDecimal;
import domain.Product;
import dao.ProductList;
import java.util.ArrayList;

/**
 *
 * @author liji8162
 */
public class ProductDialog extends javax.swing.JDialog {
	private ProductList myProductList = new ProductList();

	/**
	 * Creates new form ProductDialog
	 */
	public ProductDialog(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
		comboCategory.setEditable(true);
	}
	
//	public ArrayList<Product> getProductList(){
//		return myProductList.getProducts();
//	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      jLabel1 = new javax.swing.JLabel();
      jLabel2 = new javax.swing.JLabel();
      jLabel3 = new javax.swing.JLabel();
      jLabel4 = new javax.swing.JLabel();
      jLabel5 = new javax.swing.JLabel();
      jLabel6 = new javax.swing.JLabel();
      txtID = new javax.swing.JTextField();
      txtName = new javax.swing.JTextField();
      txtPrice = new javax.swing.JTextField();
      txtQuantity = new javax.swing.JTextField();
      jScrollPane1 = new javax.swing.JScrollPane();
      txtDescription = new javax.swing.JTextArea();
      saveButton = new javax.swing.JButton();
      cancelButton = new javax.swing.JButton();
      comboCategory = new javax.swing.JComboBox<>();

      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

      jLabel1.setText("ID:");
      jLabel1.setName("jLabel1"); // NOI18N

      jLabel2.setText("Name:");
      jLabel2.setName("jLabel2"); // NOI18N

      jLabel3.setText("Description:");
      jLabel3.setName("jLabel3"); // NOI18N

      jLabel4.setText("Category:");
      jLabel4.setName("jLabel4"); // NOI18N

      jLabel5.setText("Price:");
      jLabel5.setName("jLabel5"); // NOI18N

      jLabel6.setText("Quantity:");
      jLabel6.setName("jLabel6"); // NOI18N

      txtID.setName("txtID"); // NOI18N

      txtName.setName("txtName"); // NOI18N

      txtPrice.setName("txtPrice"); // NOI18N

      txtQuantity.setName("txtQuantity"); // NOI18N

      jScrollPane1.setName("jScrollPane1"); // NOI18N

      txtDescription.setColumns(20);
      txtDescription.setRows(5);
      txtDescription.setName("txtDescription"); // NOI18N
      jScrollPane1.setViewportView(txtDescription);

      saveButton.setText("Save");
      saveButton.setName("saveButton"); // NOI18N
      saveButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            saveButtonActionPerformed(evt);
         }
      });

      cancelButton.setText("Cancel");
      cancelButton.setName("cancelButton"); // NOI18N
      cancelButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            cancelButtonActionPerformed(evt);
         }
      });

      comboCategory.setName("comboCategory"); // NOI18N
      comboCategory.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            comboCategoryActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGap(33, 33, 33)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
               .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
               .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
               .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
               .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
               .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
            .addGap(102, 102, 102)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(txtName)
               .addComponent(txtPrice)
               .addComponent(txtQuantity)
               .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
               .addComponent(txtID)
               .addComponent(comboCategory, 0, 100, Short.MAX_VALUE))
            .addGap(154, 154, 154))
         .addGroup(layout.createSequentialGroup()
            .addGap(72, 72, 72)
            .addComponent(saveButton)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(cancelButton)
            .addGap(84, 84, 84))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel1)
               .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel2)
               .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addGap(26, 26, 26)
                  .addComponent(jLabel3)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                  .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGap(18, 18, 18)))
            .addGap(6, 6, 6)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel4)
               .addComponent(comboCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(30, 30, 30)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jLabel5))
            .addGap(28, 28, 28)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jLabel6))
            .addGap(37, 37, 37)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(saveButton)
               .addComponent(cancelButton))
            .addGap(32, 32, 32))
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

   private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
      	
		/**convert values to right formats*/
		Integer id = new Integer(txtID.getText());
		BigDecimal price = new BigDecimal(txtPrice.getText());
		Integer quantity = new Integer(txtQuantity.getText());
		
		/**create an instance of product to store all the values held 
		 * by text fields.*/
		Product product = new Product();
		product.setId(id);
		product.setName(txtName.getText());
		product.setDescription(txtDescription.getText());
		product.setCategory((String)comboCategory.getSelectedItem());
		product.setPrice(price);
		product.setQuantity(quantity);
		/**store this instance of product into myProductList*/
		myProductList.addProduct(product);
		
		
		
		
		
		
   }//GEN-LAST:event_saveButtonActionPerformed

   private void comboCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCategoryActionPerformed
      // TODO add your handling code here:
   }//GEN-LAST:event_comboCategoryActionPerformed

   private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
      // TODO add your handling code here:
		dispose();
   }//GEN-LAST:event_cancelButtonActionPerformed

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
			java.util.logging.Logger.getLogger(ProductDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(ProductDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(ProductDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(ProductDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the dialog */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				ProductDialog dialog = new ProductDialog(new javax.swing.JFrame(), true);
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
   private javax.swing.JButton cancelButton;
   private javax.swing.JComboBox<String> comboCategory;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JLabel jLabel4;
   private javax.swing.JLabel jLabel5;
   private javax.swing.JLabel jLabel6;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JButton saveButton;
   private javax.swing.JTextArea txtDescription;
   private javax.swing.JTextField txtID;
   private javax.swing.JTextField txtName;
   private javax.swing.JTextField txtPrice;
   private javax.swing.JTextField txtQuantity;
   // End of variables declaration//GEN-END:variables
}
