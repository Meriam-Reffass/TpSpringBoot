package inpt.sud.springbackendtp.service

import org.springframework.stereotype.Service
import java.io.File
import java.io.IOException
import java.nio.file.Files

@Service
object ProductService {
    fun getImage(id: Long?): ByteArray {
        val userHomeDir = System.getProperty("user.home")
        val image = File("$userHomeDir/ecom/products", "Unknown.png")
        var fileContent = ByteArray(0)
        try {
            fileContent = Files.readAllBytes(image.toPath())
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return fileContent
    }
}