package com.budakattusante.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.budakattusante.data.db.dao.*
import com.budakattusante.data.db.entity.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Main Room database for Budakattu Sante.
 * Seeds default data (categories, tribal families, products, admin user)
 * on first app launch.
 */
@Database(
    entities = [User::class, Product::class, Order::class, TribalFamily::class, Category::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun productDao(): ProductDao
    abstract fun orderDao(): OrderDao
    abstract fun tribalFamilyDao(): TribalFamilyDao
    abstract fun categoryDao(): CategoryDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "budakattusante_db"
                )
                    .fallbackToDestructiveMigration()
                    .addCallback(object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            // Seed initial data on first create
                            CoroutineScope(Dispatchers.IO).launch {
                                INSTANCE?.let { database ->
                                    seedDatabase(database)
                                }
                            }
                        }
                    })
                    .build()
                INSTANCE = instance
                instance
            }
        }

        // --------------- SEED DATA ---------------
        private suspend fun seedDatabase(database: AppDatabase) {

            // 1. Categories
            val categories = listOf(
                Category(1, "Forest Produce", "ic_forest"),
                Category(2, "Handicrafts", "ic_handicraft"),
                Category(3, "Herbal Products", "ic_herb"),
                Category(4, "Grains & Seeds", "ic_grain"),
                Category(5, "Honey & Sweets", "ic_honey")
            )
            categories.forEach { database.categoryDao().insertCategory(it) }

            // 2. Tribal Families
            val families = listOf(
                TribalFamily(1, "Gondi Family", "Ramu Gondi", "Abujhmarh", "Gond", "9876543210"),
                TribalFamily(2, "Madia Clan", "Sita Madia", "Narayanpur", "Madia", "9876543211"),
                TribalFamily(3, "Bhil Family", "Kiran Bhil", "Dantewada", "Bhil", "9876543212"),
                TribalFamily(4, "Korku Family", "Mohan Korku", "Melghat", "Korku", "9876543213"),
                TribalFamily(5, "Baiga Clan", "Devi Baiga", "Baigatown", "Baiga", "9876543214"),
                TribalFamily(6, "Chenchu Family", "Ramaiah Chenchu", "Nallamala", "Chenchu", "9876543215"),
                TribalFamily(7, "Toda Family", "Pari Toda", "Nilgiris", "Toda", "9876543216"),
                TribalFamily(8, "Warli Family", "Anita Warli", "Dahanu", "Warli", "9876543217")
            )
            families.forEach { database.tribalFamilyDao().insertTribalFamily(it) }

            // 3. Default leader account
            database.userDao().insertUser(
                User(
                    name = "Cooperative Leader",
                    phone = "9999999999",
                    village = "Abujhmarh",
                    password = "admin123",
                    role = "leader"
                )
            )

            // 4. Tribal Products (27 items)
            val products = listOf(
                Product(1, "Wild Forest Honey", "Pure raw honey collected from wild beehives deep in the Chhattisgarh forests. Rich in antioxidants and natural enzymes. A traditional staple of Gondi families for generations.", "Honey & Sweets", "img_honey", 450.0, 400.0, 50, "All Season", 1, "Abujhmarh", "Wild Forest Honey from Abujhmarh village. Pure raw honey at four hundred fifty rupees per kilogram. Rich in antioxidants and natural enzymes, collected by the Gondi family."),
                Product(2, "Bamboo Basket", "Handwoven bamboo basket crafted by Madia artisans. Perfect for storage and home decoration. Each basket is unique and made with traditional weaving patterns.", "Handicrafts", "img_basket", 280.0, 250.0, 30, "All Season", 2, "Narayanpur", "Handwoven bamboo basket by Madia artisans from Narayanpur. Price two hundred eighty rupees. Traditional patterns, durable and eco-friendly."),
                Product(3, "Forest Turmeric", "Organic wild turmeric harvested from forest floors. Higher curcumin content than farmed variety. Used in Ayurvedic medicine, cooking, and beauty rituals.", "Herbal Products", "img_turmeric", 180.0, 160.0, 75, "Winter", 1, "Abujhmarh", "Forest turmeric from Abujhmarh. One hundred eighty rupees per hundred grams. High curcumin content. Natural and organic, harvested from wild forest floors."),
                Product(4, "Mahua Flower", "Dried Mahua flowers with sweet aroma. Used in traditional sweets, medicines, and tribal rituals. Collected during the spring season when flowers are in full bloom.", "Forest Produce", "img_mahua", 120.0, 100.0, 100, "Spring", 3, "Dantewada", "Dried Mahua flowers from Dantewada forests. One hundred twenty rupees per kilogram. Used in traditional sweets and tribal medicines."),
                Product(5, "Amla Powder", "Sun-dried Indian gooseberry ground to fine powder. Rich in Vitamin C, used for hair care, digestion, and boosting immunity. Prepared by Korku women using traditional methods.", "Herbal Products", "img_amla", 200.0, 180.0, 60, "Winter", 4, "Melghat", "Amla powder by Korku women from Melghat. Two hundred rupees per two hundred grams. Rich in Vitamin C, natural immunity booster."),
                Product(6, "Tamarind Block", "Raw tamarind from ancient forest trees, naturally seedless and tangy. Used in chutneys, curries, and medicinal preparations across tribal kitchens.", "Forest Produce", "img_tamarind", 90.0, 80.0, 120, "Summer", 5, "Baigatown", "Tamarind block from Baigatown forests. Ninety rupees per kilogram. Naturally tangy from ancient forest trees, great for cooking and medicine."),
                Product(7, "Herbal Hair Oil", "A blend of forest herbs, amla, and coconut oil. Traditional recipe passed down by Chenchu tribal healers. Promotes hair growth and prevents premature greying.", "Herbal Products", "img_hairoil", 350.0, 310.0, 40, "All Season", 6, "Nallamala", "Herbal hair oil by Chenchu healers from Nallamala. Three hundred fifty rupees per two hundred milliliters. Natural herbs promote hair growth and prevent greying."),
                Product(8, "Tribal Brass Necklace", "Handcrafted brass necklace with traditional Toda motifs. Each piece is individually hammered and shaped by Toda artisans. A unique piece of wearable tribal art.", "Handicrafts", "img_necklace", 800.0, 700.0, 15, "All Season", 7, "Nilgiris", "Tribal brass necklace by Toda artisans from Nilgiris. Eight hundred rupees. Handcrafted with traditional motifs, unique wearable art."),
                Product(9, "Kodo Millet", "Ancient grain grown in hill terraces without chemicals. Gluten-free, high in fiber and minerals. A traditional dietary staple of tribal communities, excellent for diabetics.", "Grains & Seeds", "img_millet", 60.0, 55.0, 200, "Monsoon", 2, "Narayanpur", "Kodo millet from Narayanpur hill terraces. Sixty rupees per kilogram. Ancient grain, gluten-free, high fiber, suitable for diabetics."),
                Product(10, "Bamboo Shoot Pickle", "Freshly preserved bamboo shoots in mustard oil and forest spices. Made using a traditional Gond recipe. Excellent accompaniment with rice and roti.", "Forest Produce", "img_pickle", 150.0, 130.0, 80, "Monsoon", 1, "Abujhmarh", "Bamboo shoot pickle using Gond recipe. One hundred fifty rupees per five hundred grams. Traditional and spicy, great with rice and roti."),
                Product(11, "Neem Leaf Powder", "Dried neem leaves ground to fine powder. Antiseptic and antibacterial properties. Used for natural skin care routines and organic pest control in farms.", "Herbal Products", "img_neem", 80.0, 70.0, 90, "Summer", 4, "Melghat", "Neem leaf powder from Melghat forests. Eighty rupees per hundred grams. Natural antiseptic, used in skin care and organic farming."),
                Product(12, "Warli Painting", "Authentic Warli tribal painting on handmade paper. Depicts scenes of daily tribal life, nature cycles, and harvest festivals. Each painting is an original one-of-a-kind artwork.", "Handicrafts", "img_painting", 1200.0, 1000.0, 8, "All Season", 8, "Dahanu", "Warli painting by Anita Warli from Dahanu. Twelve hundred rupees. Authentic tribal art depicting nature and village life. Each piece is unique."),
                Product(13, "Shisham Wooden Spoon Set", "Set of 5 handcarved cooking spoons made from seasoned Shisham wood. Smooth food-safe finish, naturally antibacterial. Carved by skilled Bhil artisans.", "Handicrafts", "img_spoons", 320.0, 290.0, 25, "All Season", 3, "Dantewada", "Shisham wooden spoon set by Bhil artisans from Dantewada. Three hundred twenty rupees for a set of five. Food-safe, durable, naturally antibacterial."),
                Product(14, "Jamun Fruit Powder", "Spray-dried black plum powder. Helps control blood sugar levels and improves digestion. Seasonal harvest from wild Jamun trees found in deep forests.", "Herbal Products", "img_jamun", 240.0, 210.0, 55, "Summer", 6, "Nallamala", "Jamun powder from Nallamala forests. Two hundred forty rupees per hundred grams. Controls blood sugar naturally, improves digestion."),
                Product(15, "Ragi Flour", "Stone-ground finger millet flour. High in calcium and iron. A traditional food of tribal communities, excellent for growing children and elderly people.", "Grains & Seeds", "img_ragi", 70.0, 65.0, 180, "Monsoon", 5, "Baigatown", "Ragi flour from Baigatown. Seventy rupees per kilogram. Stone-ground, high calcium and iron. Traditional and nutritious for all ages."),
                Product(16, "Beeswax Candles", "Pure natural beeswax candles with calming herbal fragrance. Long-burning, smokeless, and chemical-free. Handmade by Gondi beekeepers from hive remnants.", "Honey & Sweets", "img_candles", 180.0, 160.0, 45, "All Season", 1, "Abujhmarh", "Beeswax candles by Gondi beekeepers. One hundred eighty rupees for a set of six. Natural herbal fragrance, smokeless and long-burning."),
                Product(17, "Forest Mushroom", "Sun-dried forest mushrooms collected from monsoon forests. Rich in protein, vitamins, and umami flavor. Excellent in soups, gravies, and rice dishes.", "Forest Produce", "img_mushroom", 300.0, 270.0, 35, "Monsoon", 2, "Narayanpur", "Dried forest mushrooms from Narayanpur. Three hundred rupees per two hundred grams. Rich in protein, great for soups and gravies."),
                Product(18, "Lac Bangles", "Colorful traditional lac bangles made with natural mineral dyes. Handmade by Madia artisans using a technique passed down through generations.", "Handicrafts", "img_bangles", 150.0, 130.0, 60, "All Season", 2, "Narayanpur", "Lac bangles by Madia artisans from Narayanpur. One hundred fifty rupees per set of twelve. Colorful traditional designs with natural mineral dyes."),
                Product(19, "Ashwagandha Root", "Whole dried ashwagandha roots from forest herbs. A powerful adaptogen that relieves stress and boosts natural energy. Sustainably collected from Korku forests.", "Herbal Products", "img_ashwagandha", 280.0, 250.0, 40, "Winter", 4, "Melghat", "Ashwagandha roots from Melghat forests. Two hundred eighty rupees per hundred grams. Natural stress reliever and energy booster, sustainably harvested."),
                Product(20, "Char Seeds", "Wild Char tree seeds used for oil extraction. The oil has a high smoke point, making it suitable for deep frying. A prized forest resource of Dantewada tribes.", "Grains & Seeds", "img_char", 100.0, 90.0, 70, "Summer", 3, "Dantewada", "Char seeds from Dantewada forests. One hundred rupees per kilogram. High smoke-point oil source, prized forest resource."),
                Product(21, "Tribal Handloom Saree", "Handwoven cotton saree featuring traditional Warli motifs in natural dyes. Comfortable for all seasons. Each saree takes three days to weave by hand.", "Handicrafts", "img_saree", 2500.0, 2200.0, 10, "All Season", 8, "Dahanu", "Handloom saree with Warli motifs from Dahanu. Two thousand five hundred rupees. Three days to weave by hand, natural dyes, comfortable for all seasons."),
                Product(22, "Mahua Laddoo", "Traditional sweet made from Mahua flowers and jaggery. A festival delicacy of the Baiga tribe with no artificial preservatives. Naturally sweet and aromatic.", "Honey & Sweets", "img_laddoo", 200.0, 180.0, 65, "Spring", 5, "Baigatown", "Mahua laddoo by Baiga tribe from Baigatown. Two hundred rupees per kilogram. Traditional festival sweet, naturally sweet and aromatic, no preservatives."),
                Product(23, "Jackfruit Chips", "Crispy jackfruit chips fried in forest oil with natural spices. A seasonal snack from tribal forests. Light, crunchy, and naturally flavored without artificial colors.", "Forest Produce", "img_jackfruit", 120.0, 100.0, 90, "Summer", 6, "Nallamala", "Jackfruit chips from Nallamala forests. One hundred twenty rupees per two hundred grams. Crispy seasonal snack, natural spices, no artificial colors."),
                Product(24, "Bamboo Lamp Stand", "Decorative lamp stand handcrafted from seasoned bamboo with traditional Madia design patterns. A stylish and eco-friendly home decor piece.", "Handicrafts", "img_lampstand", 550.0, 500.0, 12, "All Season", 2, "Narayanpur", "Bamboo lamp stand by Madia artisans from Narayanpur. Five hundred fifty rupees. Eco-friendly, traditional Madia patterns, stylish home decor."),
                Product(25, "Soapnut Powder", "Dried soapnut shells ground to powder. A natural hair wash and detergent alternative. Gentle on skin, fully biodegradable, and free from harmful chemicals.", "Herbal Products", "img_soapnut", 90.0, 80.0, 110, "Winter", 7, "Nilgiris", "Soapnut powder from Nilgiris forests. Ninety rupees per two hundred grams. Natural hair wash and detergent, gentle on skin, biodegradable."),
                Product(26, "Wild Forest Rice", "Handpicked wild forest rice with earthy aromatic flavor. Unpolished and naturally nutritious. A traditional food staple of the Chenchu tribe.", "Grains & Seeds", "img_wildrice", 85.0, 75.0, 150, "Monsoon", 6, "Nallamala", "Wild forest rice from Nallamala. Eighty five rupees per kilogram. Unpolished, nutritious, earthy flavor. Traditional staple of the Chenchu tribe."),
                Product(27, "Gond Art Print", "High-quality print of original Gond artwork. Vibrant colors depicting forest animals, birds, and tribal village life. Ready to frame, an ideal gift and decor piece.", "Handicrafts", "img_gondart", 450.0, 400.0, 20, "All Season", 1, "Abujhmarh", "Gond art print from Abujhmarh. Four hundred fifty rupees. Vibrant depiction of forest animals and tribal life. Ready to frame, ideal as a gift.")
            )
            products.forEach { database.productDao().insertProduct(it) }
        }
    }
}
