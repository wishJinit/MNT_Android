package com.example.mnt_android.view.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.mnt_android.R
import com.example.mnt_android.databinding.FragmentJoinroom2Binding
import com.example.mnt_android.util.TAG_IS_MANAGER
import com.example.mnt_android.util.TAG_ROOM_ID
import com.example.mnt_android.viewmodel.JoinRoomViewModel
import kotlinx.android.synthetic.main.fragment_joinroom2.*

class JoinRoomFragment2 : Fragment()
{
    lateinit var joinRoomViewModel: JoinRoomViewModel
    lateinit var binding: FragmentJoinroom2Binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_joinroom2,container,false)

        joinRoomViewModel=(activity as JoinRoomActivity).joinRoomViewModel

        binding.joinRoomViewModel = joinRoomViewModel
        binding.joinRoomActivity=(activity as JoinRoomActivity)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setEventListener()
    }

    private fun setEventListener() {
        bu_lookparticipant_joinroom2.setOnClickListener {
            val intent = Intent(context, ApplicantListActivity::class.java)
            intent.putExtra(TAG_IS_MANAGER, 0)
            intent.putExtra(TAG_ROOM_ID, joinRoomViewModel.roomInfo.num.value)
            context?.startActivity(intent)
        }
    }
}