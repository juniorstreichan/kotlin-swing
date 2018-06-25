package business

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import entity.FullParameters
import entity.PostEntity
import entity.HttpResponse
import infra.EndpointConstants
import infra.OperationMethod
import repository.PostRepository

class PostBusiness {

    fun getAllPosts(): List<PostEntity> {
        val url: String = EndpointConstants.BASE.URL + EndpointConstants.POST.ALL_POSTS

        val fullParameters = FullParameters(url, OperationMethod.GET)

        val response = PostRepository.getAllPosts(fullParameters)


        return Gson().fromJson<List<PostEntity>>(
                response.jsonResponse,
                object : TypeToken<List<PostEntity>>() {}.type
        )
    }

    fun getSinglePosts(id: Int): PostEntity {
        val url: String = EndpointConstants.BASE.URL + EndpointConstants.POST.SINGLE_POSTS

        val fullParameters = FullParameters(url, OperationMethod.GET, mapOf(Pair("id", id.toString())))

        val response = PostRepository.getAllPosts(fullParameters)

        return Gson().fromJson<List<PostEntity>>(
                response.jsonResponse,
                object : TypeToken<List<PostEntity>>() {}.type
        )[0]
    }
}