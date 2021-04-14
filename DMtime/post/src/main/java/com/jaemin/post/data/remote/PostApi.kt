package com.jaemin.post.data.remote


import com.jaemin.posts.data.dto.request.PatchedPostRequest
import com.jaemin.posts.data.dto.request.WrittenPostRequest
import com.jaemin.posts.data.dto.response.PostResponse
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.*

interface PostApi {

    @GET("board/posts/{post-id}")
    fun getPost(@Path("post-id") postId: Int): Single<PostResponse>

    @PATCH("board/posts/{post-id}")
    fun patchPost(
        @Path("post-id") postId: Int,
        @Body PatchedPostRequest: PatchedPostRequest
    ): Completable

    @GET("board/posts")
    fun writePost(@Body writtenPostRequest: WrittenPostRequest): Completable

}