package com.budakattusante.data.repository

import com.budakattusante.data.db.dao.ProductDao
import com.budakattusante.data.db.dao.TribalFamilyDao
import com.budakattusante.data.db.entity.Product
import com.budakattusante.data.db.entity.TribalFamily
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductRepository @Inject constructor(
    private val productDao: ProductDao,
    private val tribalFamilyDao: TribalFamilyDao
) {
    fun getAllProducts(): Flow<List<Product>> = productDao.getAllProducts()

    fun getProductsByCategory(category: String): Flow<List<Product>> =
        productDao.getProductsByCategory(category)

    fun searchProducts(query: String): Flow<List<Product>> = productDao.searchProducts(query)

    fun getLowStockProducts(): Flow<List<Product>> = productDao.getLowStockProducts()

    suspend fun getProductById(id: Int): Product? = productDao.getProductById(id)

    suspend fun insertProduct(product: Product): Long = productDao.insertProduct(product)

    suspend fun updateProduct(product: Product) = productDao.updateProduct(product)

    suspend fun deleteProduct(product: Product) = productDao.deleteProduct(product)

    suspend fun reduceStock(productId: Int, quantity: Int) =
        productDao.reduceStock(productId, quantity)

    suspend fun getProductCount(): Int = productDao.getProductCount()

    suspend fun getFamilyById(id: Int): TribalFamily? = tribalFamilyDao.getFamilyById(id)
}
