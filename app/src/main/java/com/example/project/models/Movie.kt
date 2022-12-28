
class Movie(private var Name: String, private var Image: Int, private var Description: String, private var Price: String) {

    fun getName(): String {
        return Name
    }

    fun setName(Name: String) {
        this.Name = Name
    }

    fun getImage(): Int
    {
        return Image
    }

    fun setImage(Image: Int) {
        this.Image = Image
    }

    fun getDescription(): String {
        return Description
    }

    fun setDescription(Description: String) {
        this.Description = Description
    }

    fun getPrice(): String {
        return Price
    }

    fun setPrice(Price: String) {
        this.Price = Price
    }
}
