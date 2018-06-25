package repository

import entity.FullParameters
import entity.HttpResponse

class PostRepository private constructor() {
    companion object : BaseRepository() {

        fun getAllPosts(fullParameters: FullParameters):HttpResponse {
            return super.execute(fullParameters)
        }

        fun getSinglePosts(fullParameters: FullParameters):HttpResponse {
            return super.execute(fullParameters)
        }
    }


}