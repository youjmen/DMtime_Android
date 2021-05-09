package com.jaemin.features.domain.usecase

import com.jaemin.base.UseCase
import com.jaemin.features.domain.entity.Posts
import com.jaemin.features.domain.repository.PostsRepository
import io.reactivex.rxjava3.core.Single

class GetMyWroteCommentPostsUseCase(private val postsRepository: PostsRepository) : UseCase<Int, Posts>(){
    override fun build(data: Int): Single<Posts> =
        postsRepository.getMyWroteCommentPosts(data)
}