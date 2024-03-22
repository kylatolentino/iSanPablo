package com.app.isanpablo.ui.ela
import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.app.isanpablo.R
import com.app.isanpablo.databinding.GovernmentElaBinding
import com.app.isanpablo.ui.government.GovernmentFragment

class ElaFragment : Fragment() {

    private var _binding: GovernmentElaBinding? = null
    private val binding get() = _binding!!

    private lateinit var downloader: AndroidDownloader
    private lateinit var downloadCompletedReceiver: DownloadCompletedReceiver

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = GovernmentElaBinding.inflate(inflater, container, false)
        val root: View = binding.root

        downloader = AndroidDownloader(requireContext())
        downloadCompletedReceiver = DownloadCompletedReceiver()

        val progressBar = binding.progressBar
        progressBar.visibility = View.VISIBLE

        // Register the BroadcastReceiver to listen for download completion
        requireContext().registerReceiver(downloadCompletedReceiver, IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE))

        downloader.downloadFile("https://www.sanpablocity.gov.ph/docs/ELA 2016-2019 (final).docx")


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Unregister the BroadcastReceiver to avoid memory leaks
        requireContext().unregisterReceiver(downloadCompletedReceiver)
        _binding = null
    }

    inner class DownloadCompletedReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            if (intent?.action == DownloadManager.ACTION_DOWNLOAD_COMPLETE) {
                val id = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1L)
                if (id != -1L) {
                    Toast.makeText(requireContext(), "Download completed", Toast.LENGTH_SHORT).show()
                    // Hide the progress bar or update UI as needed
                    binding.progressBar.visibility = View.GONE
                    val fragmentManager = requireActivity().supportFragmentManager
                    val transaction = fragmentManager.beginTransaction()
                    transaction.replace(R.id.nav_host_fragment_content_main,GovernmentFragment())
                    transaction.addToBackStack(null)
                    transaction.commit()
                }
            }
        }
    }
}
