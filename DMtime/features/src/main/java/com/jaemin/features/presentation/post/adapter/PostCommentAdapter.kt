package com.jaemin.features.presentation.post.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jaemin.features.databinding.ItemCommentBinding
import com.jaemin.features.databinding.ItemReplyCommentBinding
import com.jaemin.features.domain.entity.Comment
import com.jaemin.features.presentation.post.contract.CommentsContract

class PostCommentAdapter(
    private val commentsPresenter: CommentsContract.Presenter,
    private val comments: MutableList<Comment> = mutableListOf()
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            0 -> CommentViewHolder(ItemCommentBinding.inflate(inflater, parent, false))
            else -> ReplyCommentViewHolder(ItemReplyCommentBinding.inflate(inflater, parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is CommentViewHolder -> holder.bind(comments[position])
            is ReplyCommentViewHolder -> holder.bind(comments[position])
            else-> return
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (comments[position].upperCommentId == null) {
            0
        } else {
            1
        }
    }

    fun updateItems(items : List<Comment>){
        comments.clear()
        comments.run {
            clear()
            addAll(items)
        }
        notifyDataSetChanged()

    }

    override fun getItemCount(): Int = comments.size


}

class CommentViewHolder(private val binding: ItemCommentBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(comment : Comment) {
        binding.commentWriterTv.text = comment.writer.username
        binding.commentContentTv.text = comment.content
        binding.commentTimeTv.text = comment.wroteDatetime

//        binding.commentAddTv.setOnClickListener {
//            binding.root.addView()
//
//        }
    }


}

class ReplyCommentViewHolder(private val binding: ItemReplyCommentBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(comment: Comment) {
        binding.commentWriterTv.text = comment.writer.username
        binding.commentContentTv.text = comment.content
        binding.commentTimeTv.text = comment.wroteDatetime
    }

}