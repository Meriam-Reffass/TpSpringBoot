package inpt.sud.springbackendtp.data

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import lombok.ToString
import java.io.Serializable
import javax.persistence.*

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
class Category : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    var name: String? = null
    var description: String? = null

    @OneToMany(mappedBy = "category")
    var products: Collection<Product>? = null

    constructor(id: Long?, name: String?, description: String?, products: Collection<Product>?){
        this.id = id
        this.name = name
        this.description = description
        this.products = products
    }
}

