package com.example.popularlibs.users

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.popularlibs.App
import com.example.popularlibs.R
import com.example.popularlibs.data.GitHubUser
import com.example.popularlibs.databinding.ViewUsersBinding
import com.example.popularlibs.recycler.UsersAdapter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UsersFragment : MvpAppCompatFragment(R.layout.view_users), UsersView,
    UsersAdapter.OnUserClickListener {

    private val presenter: UsersPresenter by moxyPresenter {
        UsersPresenter().apply {
            App.instance.component.inject(this)
        }
    }

    private val usersAdapter = UsersAdapter(this)
    private lateinit var viewBinding: ViewUsersBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = ViewUsersBinding.bind(view)
        viewBinding.usersRecycler.adapter = usersAdapter
    }

    override fun showUsers(users: List<GitHubUser>) {
        usersAdapter.submitList(users)
    }

    override fun showError(message: String) {
        requireActivity().let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Ошибка!")
                .setMessage(message)
                .setPositiveButton("ОК") { dialog, _ ->
                    dialog.cancel()
                }
            builder.create().show()
        }
    }

    override fun setProgressBarVisibility(isVisible: Boolean) {
        val visibility = if (isVisible) {
            View.VISIBLE
        } else {
            View.GONE
        }
        viewBinding.includeLoadingLayout.loadingLayout.visibility = visibility
    }

    override fun onUserPicked(user: GitHubUser) {
        presenter.goToNextScreen(user.login!!)
    }

    companion object {
        fun newInstance(): Fragment = UsersFragment()
    }
}