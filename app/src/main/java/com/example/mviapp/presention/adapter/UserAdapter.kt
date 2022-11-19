package com.example.mviapp.presention.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mviapp.databinding.ItemUserBinding
import com.example.mviapp.domain.model.User


class UserAdapter() :
        ListAdapter<User, UserAdapter.UserViewHolder>(
            UserDiffCallback()
        ) {

        private val differ: AsyncListDiffer<User> =
            AsyncListDiffer(this, UserDiffCallback())
        private var selectedItem = - 1

        var UserList: List<User>
            get() = differ.currentList
            set(value) = differ.submitList(value)

        class UserDiffCallback : DiffUtil.ItemCallback<User>() {
            override fun areItemsTheSame(
                oldItem: User,
                newItem: User
            ): Boolean {
                return oldItem.hashCode() == newItem.hashCode()
            }

            override fun areContentsTheSame(
                oldItem: User,
                newItem: User
            ): Boolean {
                return oldItem.hashCode() == newItem.hashCode()
            }
        }

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): UserViewHolder {
            val binding =
                ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return UserViewHolder(binding)
        }

        override fun onBindViewHolder(
            holder: UserViewHolder,
            position: Int
        ) {
            val userItem = UserList[position]
            holder.bind(userItem, position)
        }

        override fun getItemCount(): Int {
            return UserList.size
        }


        inner class UserViewHolder(val binding: ItemUserBinding) :
            RecyclerView
            .ViewHolder(binding.root.rootView) {


            fun bind(
                user: User,
                position: Int
            ) {

                binding.textView2.text = user.firstName +" "+ user.lastName

                binding.root.rootView.setOnClickListener {
                    onItemClickListener?.let {
                        it(user, position)
                    }


                }
            }


        }

        private var onItemClickListener: ((User, Int) -> Unit)? = null
        fun setOnItemClickListener(listener: (User, Int) -> Unit) {
            onItemClickListener = listener
        }
    }



