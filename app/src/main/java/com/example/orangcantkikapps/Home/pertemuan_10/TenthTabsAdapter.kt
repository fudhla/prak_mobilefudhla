package com.example.orangcantkikapps.Home.pertemuan_10

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class TenthTabsAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    // 1. Ubah jumlah total tab dari 2 menjadi 3
    override fun getItemCount(): Int = 3

    // 2. Tambahkan posisi ke-2 untuk memanggil TabCFragment
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TabAFragment()
            1 -> TabBFragment()
            2 -> TabCFragment() // Menampilkan fragment isi RecyclerView
            else -> throw IllegalStateException("Posisi tidak valid")
        }
    }
}