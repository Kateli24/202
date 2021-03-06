package gui;

import dao.ProductDao;
import domain.Product;
import gui.helpers.SimpleListModel;
import java.util.Collection;
import java.util.TreeSet;
import javax.swing.JOptionPane;

/**
 *
 * @author liji8162
 */
public class ViewProductDialog extends javax.swing.JDialog {

	private final ProductDao productDao;
	SimpleListModel viewProductsModel = new SimpleListModel();
	SimpleListModel categoryFilter = new SimpleListModel();

	/**
	 * Creates new form ViewProductDialog
	 */
	public ViewProductDialog(java.awt.Frame parent, boolean modal, ProductDao productDao) {
		super(parent, modal);
		this.productDao = productDao;
		initComponents();
		/**
		 * the default displays in JList component
		 */

		this.viewProductsModel.updateItems(productDao.getProducts());
		this.currentProductList.setModel(viewProductsModel);
		/**
		 * the default displays in category filter(combo box)
		 */
		Collection<String> allCatogories = productDao.getCategories();
		this.categoryFilter.updateItems(allCatogories);
		this.comboFilter.setModel(categoryFilter);
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
      jLabel2 = new javax.swing.JLabel();
      jLabel3 = new javax.swing.JLabel();
      txtSearchId = new javax.swing.JTextField();
      buttonSearch = new javax.swing.JButton();
      comboFilter = new javax.swing.JComboBox<>();

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
      editButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            editButtonActionPerformed(evt);
         }
      });

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

      jLabel2.setText("Search by ID:");
      jLabel2.setName("jLabel2"); // NOI18N

      jLabel3.setText("Category Filter:");
      jLabel3.setName("jLabel3"); // NOI18N

      txtSearchId.setName("txtSearchId"); // NOI18N

      buttonSearch.setText("Search");
      buttonSearch.setName("buttonSearch"); // NOI18N
      buttonSearch.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            buttonSearchActionPerformed(evt);
         }
      });

      comboFilter.setName("comboFilter"); // NOI18N
      comboFilter.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            comboFilterActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.CENTER, layout.createSequentialGroup()
            .addGap(124, 124, 124)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
               .addComponent(jLabel3)
               .addComponent(jLabel2))
            .addGap(32, 32, 32)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(txtSearchId)
               .addComponent(comboFilter, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGap(32, 32, 32)
            .addComponent(buttonSearch)
            .addGap(112, 112, 112))
         .addGroup(javax.swing.GroupLayout.Alignment.CENTER, layout.createSequentialGroup()
            .addGap(75, 75, 75)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
               .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addComponent(jScrollPane1)
               .addGroup(layout.createSequentialGroup()
                  .addComponent(editButton, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                  .addGap(85, 85, 85)
                  .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                  .addGap(77, 77, 77)
                  .addComponent(closeButton, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)))
            .addGap(85, 85, 85))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(3, 3, 3)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(txtSearchId, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(buttonSearch)
               .addComponent(jLabel2))
            .addGap(16, 16, 16)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel3)
               .addComponent(comboFilter))
            .addGap(18, 18, 18)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
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
		boolean isEmpty = currentProductList.isSelectionEmpty();
		if (!isEmpty) {
			int result = JOptionPane.showConfirmDialog(this, "Are you sure that you "
					  + "want to delete this product?");
			if (result == JOptionPane.YES_OPTION) {
				Product copyOfProductList = (Product) currentProductList.getSelectedValue();
				productDao.deleteProduct(copyOfProductList);
				this.viewProductsModel.updateItems(productDao.getProducts());
			}
		}

   }//GEN-LAST:event_deleteButtonActionPerformed

   private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
		boolean isEmpty = currentProductList.isSelectionEmpty();
		if (!isEmpty) {
			Product copyOfProductList2 = (Product) currentProductList.getSelectedValue();
			ProductDialog currentProductDialog = new ProductDialog(this, true, copyOfProductList2, productDao);
			currentProductDialog.setVisible(true);
			this.viewProductsModel.updateItems(productDao.getProducts());
   }//GEN-LAST:event_editButtonActionPerformed
	}
   private void buttonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSearchActionPerformed
		Integer searchId = new Integer(txtSearchId.getText());
		Product searchProduct = productDao.findProduct(searchId);
		viewProductsModel.updateItems(searchProduct);


   }//GEN-LAST:event_buttonSearchActionPerformed

   private void comboFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboFilterActionPerformed
		String seletedCategory = (String) comboFilter.getSelectedItem();

		this.viewProductsModel.updateItems(productDao.productsByCategory(seletedCategory));
   }//GEN-LAST:event_comboFilterActionPerformed

	/*JList by default holds strings, went to properties to change the generics*/
   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton buttonSearch;
   private javax.swing.JButton closeButton;
   private javax.swing.JComboBox<String> comboFilter;
   private javax.swing.JList<Product> currentProductList;
   private javax.swing.JButton deleteButton;
   private javax.swing.JButton editButton;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JTextField txtSearchId;
   // End of variables declaration//GEN-END:variables
}
