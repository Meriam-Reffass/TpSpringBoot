package inpt.sud.springbackendtp
import inpt.sud.springbackendtp.data.Category
import inpt.sud.springbackendtp.data.Product
import inpt.sud.springbackendtp.dao.CategoryRepository
import inpt.sud.springbackendtp.dao.ProductRepository
import inpt.sud.springbackendtp.entities.ProductProjection
import net.bytebuddy.utility.RandomString
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.data.rest.core.config.RepositoryRestConfiguration
import java.util.*
import java.util.function.Consumer
@SpringBootApplication
class SpringbackendApplication : CommandLineRunner {
    @Autowired
    lateinit var productRepository: ProductRepository

    @Autowired
    lateinit var categoryRepository: CategoryRepository

    @Autowired
    lateinit var repositoryRestConfiguration: RepositoryRestConfiguration

    @Throws(Exception::class)
    override fun run(vararg args: String) {
        repositoryRestConfiguration!!.exposeIdsFor(Product::class.java, Category::class.java)
        repositoryRestConfiguration.projectionConfiguration.addProjection(ProductProjection::class.java)
        categoryRepository!!.save(Category(null, "Computers", null, null))
        categoryRepository!!.save(Category(null, "Printers", null, null))
        categoryRepository!!.save(Category(null, "Smartphones", null, null))
        val rnd = Random()
        categoryRepository!!.findAll().forEach(Consumer { category: Category? ->
            for (i in 0..9) {
                val p = Product()
                p.name = RandomString.make(10)
                p.currentPrice = ((100 + rnd.nextInt(10000)).toDouble())
                p.available = (rnd.nextBoolean())
                p.promotion = (rnd.nextBoolean())
                p.selected = (rnd.nextBoolean())
                p.category = (category)
                p.photoName = ("unknown.png")
                productRepository!!.save(p)
            }
        })
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(SpringbackendApplication::class.java, *args)
        }
    }
}