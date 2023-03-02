package br.senai.sp.jandira.productlistds3m.DAO

import android.content.Context
import androidx.compose.runtime.rememberUpdatedState
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.senai.sp.jandira.productlistds3m.model.Product


@Database(entities = [Product::class], version = 1)
abstract class ProductDB : RoomDatabase() {

    abstract fun productDao(): ProductDAO

    companion object {
        private lateinit var instance: ProductDB

        fun getDatabase(context: Context): ProductDB {
            // Verificar se a instancia já foi criada
            if (!::instance.isInitialized) {
                instance = Room.databaseBuilder(
                    context,
                    ProductDB::class.java,
                    "db_product_list"
                )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance

        }
    }

}