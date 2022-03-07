package inpt.sud.springbackendtp.controllers

import inpt.sud.springbackendtp.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
@RestController
class ProductController {
    @Autowired
    lateinit var productService: ProductService;
    @ResponseBody
    @RequestMapping(
        value = ["/photoProduct/{id:.+}"],
        method = [RequestMethod.GET],
        consumes = [MediaType.ALL_VALUE],
        produces = [MediaType.IMAGE_PNG_VALUE]
    )
    fun getImage(@PathVariable("id") id: Long?): ResponseEntity<ByteArray> {
        var image: ByteArray = ProductService.getImage(id)
        return ResponseEntity.ok(image)
    }
}



