package inpt.sud.springbackendtp.entities

import inpt.sud.springbackendtp.data.Product
import org.springframework.data.rest.core.config.Projection

@Projection(name = "P1", types = [Product::class])
interface ProductProjection {
    val currentPrice: Double
}