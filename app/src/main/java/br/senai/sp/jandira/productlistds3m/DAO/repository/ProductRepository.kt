package br.senai.sp.jandira.productlistds3m.DAO.repository


import android.content.Context
import br.senai.sp.jandira.productlistds3m.DAO.ProductDB
import br.senai.sp.jandira.productlistds3m.model.Product

class ProductRepository(context: Context) {
    private val db = ProductDB.getDatabase(context).productDao()
    fun getProductList(): List<Product> {
        return db.getAllProduct()
    }

    fun saveProductList(product: Product) {
        db.saveProduct(product)
    }

}
