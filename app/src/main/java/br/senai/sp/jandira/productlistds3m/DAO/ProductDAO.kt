package br.senai.sp.jandira.productlistds3m.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import br.senai.sp.jandira.productlistds3m.model.Product


@Dao
interface ProductDAO {

    @Insert
    fun saveProduct (product: Product) : Long

    @Delete
    fun deleteProduct(product: Product) : Int


    @Query("SELECT * FROM tbl_product ORDER BY id ASC")
    fun getAllProduct() : List<Product>


}