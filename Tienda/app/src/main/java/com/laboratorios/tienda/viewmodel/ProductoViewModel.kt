package com.laboratorios.tienda.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.laboratorios.tienda.model.Producto

class ProductoViewModel : ViewModel() {
    private val _allProducts = mutableStateListOf(
        Producto(1,"Camisa cuello V","Ropa",15.00,"Linda camisa negra cuello en v para caballero","https://pierrecardinca.com/large/PVS-00066C.webp"),
        Producto(2,"Camiseta Polo","Ropa",20.00,"Linda camisa celeste para cabllera tipo Polo","https://sv.kennethcolelatino.com/cdn/shop/products/KCOI23POL-08-02-SKY_BLUE-1.jpg?v=1705510261"),
        Producto(3,"Camisa Manga Corta","Ropa",16.99,"Camisa Caterpillar para mujer celeste","https://caterpillarsv.com/cdn/shop/files/300789890_1024x1024.jpg?v=1740777467"),
        Producto(4,"Zapatos Vans","Calzado",75.00,"Zapatos Vans botines clasicos color negro","https://vansec.vteximg.com.br/arquivos/ids/164573-1200-1200/VN000D5F6BT-1-.jpg"),
        Producto(5,"Zapatos Nike","Calzado",95.99,"Zapatos Nike color rosa para mujer","https://static.nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/99120a42-1aba-4630-ab54-3362666e3714/W+NIKE+DUNK+LOW+NEXT+NATURE.png"),
        Producto(6,"Reloj Citizen","Joyeria",313.50,"Reloj Citizen para hombre 3 manecillas","https://i.ebayimg.com/thumbs/images/g/VT4AAOSw6NhkuDrA/s-l1200.jpg"),
        Producto(7,"CadenaGLAMIRA","Joyeria",1619.00,"Cadena de oro de 14K para mujer","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQr3pQf-_rMYqtGxI56Nyc3GpvZC9ABl1x5jA&s"),
        Producto(8,"Bocina JBL FLIP 6","Electronica",115.00,"Bocina JBL FLIP 6 Bluetooth azul","https://www.officedepot.com.sv/medias/37440-2.jpg-1200ftw?context=bWFzdGVyfHJvb3R8MzI4OTYxfGltYWdlL2pwZWd8YURsakwyZ3hOeTh4TVRrek5UYzBNREV3TURZek9DOHpOelEwTUMweUxtcHdaMTh4TWpBd1puUjN8NTRiMTdkMjViOTI4OTRkNGFiYmI5MDVkMTFhN2Y3MzdkMWI1MzJmZjY5MGMzMDlkZTIxM2I5ZmFiMjIzYTBhMg"),
        Producto(9,"Teclado Logitech","Electronica",50.00,"Teclado compacto color blanco bluetooth","https://thumb.pccomponentes.com/w-530-530/articles/26/268279/4155-logitech-k380-teclado-bluetooth-multi-device-blanco-caracteristicas.jpg")
    )

    var searchQuery by mutableStateOf("")
        private set

    val filteredProducts: List<Producto>
        get() = _allProducts.filter {
            it.name.contains(searchQuery, ignoreCase = true) ||
                    it.category.contains(searchQuery, ignoreCase = true)
        }

    fun onSearchQueryChange(newQuery: String) {
        searchQuery = newQuery
    }

    fun getProductById(id: Int): Producto? {
        return _allProducts.find { it.id == id }
    }

    fun addToCart(productId: Int) {
        _allProducts.find { it.id == productId }?.addedToCart = true
    }

    fun getCartItems(): List<Producto> {
        return _allProducts.filter { it.addedToCart }
    }
}