package com.example.orangcantkikapps.Home.pertemuan_10

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class TenthTabsAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    // 1. Ubah jumlah total tab menjadi 2
    override fun getItemCount(): Int = 2

    // 2. Hapus baris TabCFragment
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TabAFragment()
            1 -> TabBFragment()
            else -> throw IllegalStateException("Posisi tidak valid")
        }
    }
}