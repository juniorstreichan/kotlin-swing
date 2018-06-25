import business.PostBusiness
import ui.PostListForm

fun main(args: Array<String>) {
    try {
        println(PostBusiness().getAllPosts())
        PostListForm()
    } catch (ex: Exception) {
        println(ex.message)
        ex.printStackTrace()
    } catch (ex: RuntimeException) {
        println(ex.message)
        ex.printStackTrace()
    }
}