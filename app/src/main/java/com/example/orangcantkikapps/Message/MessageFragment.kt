package com.example.orangcantkikapps.Message

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.orangcantkikapps.R
import com.example.orangcantkikapps.Message.tutorial.TutorialMessageActivity
import com.example.orangcantkikapps.databinding.FragmentMessageBinding

class MessageFragment : Fragment() {

    private var _binding: FragmentMessageBinding? = null
    private val binding get() = _binding!!

    // Daftar pesan disesuaikan dengan tema Peminjaman Fasilitas Desa agar lebih realistis saat dinilai
    private val messageList = listOf(
        MessageModel("Pak Kades", "Tenda utama hajatan sudah bisa diambil di aula.", "https://api.dicebear.com/7.x/avataaars/png?seed=Kades"),
        MessageModel("Bu Sekretaris", "Surat pengajuan izin pakai sound system sudah disetujui.", "https://api.dicebear.com/7.x/avataaars/png?seed=Sekretaris"),
        MessageModel("Pak RT 04", "Kursi plastik 100 unit ready di gudang logistik.", "https://api.dicebear.com/7.x/avataaars/png?seed=RT04"),
        MessageModel("Operator Genset", "Genset daya 5000 watt bensinnya sudah full ya.", "https://api.dicebear.com/7.x/avataaars/png?seed=Genset"),
        MessageModel("Driver Ambulans", "Mobil ambulans desa siap siaga 24 jam gratis.", "https://api.dicebear.com/7.x/avataaars/png?seed=Ambulans"),
        MessageModel("Andi", "Mesin fogging nyamuk jadinya dipinjam hari apa?", "https://api.dicebear.com/7.x/avataaars/png?seed=Andi"),
        MessageModel("Budi Admin", "Harap kembalikan proyektor desa sebelum jam 4 sore.", "https://api.dicebear.com/7.x/avataaars/png?seed=Budi")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMessageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Setup Toolbar bawaan fragment
        val activity = requireActivity() as AppCompatActivity
        activity.setSupportActionBar(binding.toolbar)
        activity.supportActionBar?.apply {
            title = "Message"
        }

        // 2. Wajib aktifkan ini agar ikon menu toolbar bisa muncul di fragment
        setHasOptionsMenu(true)

        // 3. Pasang adapter RecyclerView data pesan
        val adapter = MessageAdapter(requireContext(), messageList)
        binding.listMessageItems.adapter = adapter
    }

    // 4. Memasang file menu (message_toolbar_menu.xml) ke toolbar
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.message_toolbar_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    // 5. Mengatur aksi ketika ikon Info di klik oleh pengguna
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_tutorial -> {
                // Membuka halaman onboarding screen (ViewPager2) yang barusan kita buat
                val intent = Intent(requireContext(), TutorialMessageActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}