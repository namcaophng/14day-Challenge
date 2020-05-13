package com.sunasterisk.a14day_challenge.ui.home

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.sunasterisk.a14day_challenge.R
import com.sunasterisk.a14day_challenge.ui.edit.EditFragment
import com.sunasterisk.a14day_challenge.ui.listExercise.ListExercisesActivity
import com.sunasterisk.a14day_challenge.ui.login.LoginActivity
import com.sunasterisk.a14day_challenge.ui.process.ProcessActivity
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        registerListeners()
    }

    private fun registerListeners() {
        buttonContinueChallenge.setOnClickListener(this)
        buttonMyProcess.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.buttonContinueChallenge -> changeToListExerciseScreen()
            R.id.buttonMyProcess -> changeToProcessScreen()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        when (item.itemId) {
            R.id.buttonSignOut -> changeToLoginScreen()
            R.id.buttonEditInfo -> changeToEditScreen()
        }
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.home_menu, menu)
    }

    private fun changeToListExerciseScreen() {
        context?.let {
            startActivity(ListExercisesActivity.getIntent(it))
        }
    }

    private fun changeToProcessScreen() {
        context?.let {
            startActivity(ProcessActivity.getIntent(it))
        }
    }

    private fun changeToLoginScreen() {
        context?.let {
            startActivity(LoginActivity.getIntent(it))
        }
    }

    private fun changeToEditScreen() {
        val fragmentTrans = fragmentManager?.beginTransaction()
        fragmentTrans?.run {
            replace(R.id.fragment_container, EditFragment.newInstance())
            commit()
        }
    }
}
