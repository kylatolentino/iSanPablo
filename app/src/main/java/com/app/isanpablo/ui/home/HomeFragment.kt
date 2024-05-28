package com.app.isanpablo.ui.home

import android.app.Dialog
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.app.AlertDialog
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.MediaController
import android.widget.TextView
import android.widget.VideoView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.app.isanpablo.CombinedAdapter
import com.app.isanpablo.R
import com.app.isanpablo.databinding.FragmentHomeBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import kotlin.math.abs


class HomeFragment : Fragment() {
    private lateinit var tourismViewPager2: ViewPager2
    private lateinit var combinedAdapter: CombinedAdapter
    private lateinit var combinedAdapter2: CombinedAdapter
    private lateinit var eventsViewPager2: ViewPager2
    var url = "https://worldtimeapi.org/api/timezone/Asia/Manila"
    private var _binding: FragmentHomeBinding? = null
    private val updateTimeRunnable = object : Runnable {
        override fun run() {
            updateClock()
            updateTimeHandler.postDelayed(this, 1000) // Update every second
        }
    }
    private val updateTimeHandler = Handler(Looper.getMainLooper())

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        updateTimeHandler.postDelayed(updateTimeRunnable, 0)

        setUpViews()
        setUpTransformer()
        setUpClickListeners()
        updateTimeHandler.postDelayed(updateTimeRunnable, 0)

        // It calls the text and image from the array of the Tourism screens.
        // When the picture in the carousel was clicked, a dialog box will appear containing this text and image.
        combinedAdapter.viewPager2ClickListener = object : CombinedAdapter.ViewPager2ClickListener {
            override fun onItemClick(item: Pair<Int, String>) {
                val context = tourismViewPager2.context

                // This is the layout used for the dialog box
                val dialogView = LayoutInflater.from(context).inflate(R.layout.home_news_1, null)

                val dialog = AlertDialog.Builder(context)
                    .setView(dialogView)
                    .create()
                dialog.window?.setBackgroundDrawableResource(R.drawable.shape_rounded_dialog_border)
                // Initialize views in the dialog layout
                val imageViewItemDialog = dialogView.findViewById<ImageView>(R.id.imageView24)
                val textViewItemTitle = dialogView.findViewById<TextView>(R.id.textView555)

                // Set image and text
                imageViewItemDialog.setImageResource(item.first)
                textViewItemTitle.text = item.second

                dialog.show()
            }

        }

        // It calls the text and image from the array of the Events screens.
        // When the picture in the carousel was clicked, a dialog box will appear containing this text and image.
        combinedAdapter2.viewPager2ClickListener = object : CombinedAdapter.ViewPager2ClickListener {
            override fun onItemClick(item: Pair<Int, String>) {
                val context = tourismViewPager2.context

                // It is the same layout used in the Tourism screen.
                val dialogView = LayoutInflater.from(context).inflate(R.layout.home_news_1, null)

                val dialog = AlertDialog.Builder(context)
                    .setView(dialogView)
                    .create()
                dialog.window?.setBackgroundDrawableResource(R.drawable.shape_rounded_dialog_border)
                // Initialize views in the dialog layout
                val imageViewItemDialog = dialogView.findViewById<ImageView>(R.id.imageView24)
                val textViewItemTitle = dialogView.findViewById<TextView>(R.id.textView555)

                // Set image and text
                imageViewItemDialog.setImageResource(item.first)
                textViewItemTitle.text = item.second

                dialog.show()
            }

        }

        return binding.root
    }

    // It is the function used to display the video of San Pablo Hymn.
    private fun showVideo() {
        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.videohymn)
        val mediaController = MediaController(requireContext())

        // The video will appear as a dialog box.
        val dialogVideoView = dialog.findViewById<VideoView>(R.id.videoView2)
        mediaController.setAnchorView(dialogVideoView)

        // The link to the video is stored in the raw folder.
        val videoPath = "android.resource://" + requireContext().packageName + "/" + R.raw.videohymn
        val uri = Uri.parse(videoPath)
        dialogVideoView.setMediaController(mediaController) // Set MediaController before setting the video URI
        dialogVideoView.setVideoURI(uri)
        dialogVideoView.start()
        dialog.show()
    }
    private fun setUpViews() {
        // It displays the image and text from the array of the Tourism screens.
        tourismViewPager2 = binding.tourismViewPager2

        val combinedList = listOf(
            R.drawable.pic_sampaloc_lake to "Sampaloc Lake",
            R.drawable.pic_sm_sanpablo to "SM San Pablo",
            R.drawable.pic_sanpablo_church to "San Pablo Church",
            R.drawable.pic_city_hall to "San Pablo City Hall"
        )

        combinedAdapter = CombinedAdapter(combinedList, tourismViewPager2)
        tourismViewPager2.adapter = combinedAdapter
        tourismViewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                updateTimeHandler.removeCallbacks(updateTimeRunnable)
                updateTimeHandler.postDelayed(updateTimeRunnable, 2000)
            }
        })

        // It displays the image and text from the array of the Events screens.
        eventsViewPager2 = binding.eventsViewPager2

        val combinedList2 = listOf(
            R.drawable.pic_news1 to "Blessing in City Transport Terminal",
            R.drawable.pic_news2 to "854 Bikers lumahok sa 10km Fun Bike",
            R.drawable.pic_news3 to "Prime-HRM Members Pagkilala sa Pagtataas ng Watawat",
            R.drawable.pic_news4 to "Nagpulong ang miyembro ng City DRRMC"
        )

        combinedAdapter2 = CombinedAdapter(combinedList2, eventsViewPager2)
        eventsViewPager2.adapter = combinedAdapter2
        eventsViewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                updateTimeHandler.removeCallbacks(updateTimeRunnable)
                updateTimeHandler.postDelayed(updateTimeRunnable, 2000)
            }
        })
    }

    // It determines the appearance or size of the carousel of the Events and Tourism
    private fun setUpTransformer() {
        val transformer = CompositePageTransformer().apply {
            addTransformer(MarginPageTransformer(50))
            addTransformer { page, position ->
                val r = 1 - abs(position)
                page.scaleX = 0.95f + r * 0.05f
            }
        }
        tourismViewPager2.setPageTransformer(transformer)
        eventsViewPager2.setPageTransformer(transformer)
    }

    private fun setUpClickListeners() {

        // When the logo of PAGASA was clicked, it will open the website of PAGASA.
        binding.imageView6.setOnClickListener {
            val url = "https://www.pagasa.dost.gov.ph/"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

        // It shows the buttons for the Jobs, Services, and Business screens.
        binding.btnJobs.setOnClickListener {
            findNavController().navigate(R.id.nav_home_jobs)
        }
        binding.btnServices.setOnClickListener {
            findNavController().navigate(R.id.nav_home_services)
        }
        binding.btnBusiness2.setOnClickListener {
            findNavController().navigate(R.id.nav_home_business)
        }

        // It navigates the Tourism and Events screenn when the "View All" button is clicked.
        binding.btnViewSanPablo.setOnClickListener {
            findNavController().navigate(R.id.nav_tourism)
        }
        binding.btnViewAllAnnounce.setOnClickListener {
            findNavController().navigate(R.id.nav_home_announcement)
        }
        binding.videoView.setOnClickListener {
            showVideo()
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        updateTimeHandler.removeCallbacks(updateTimeRunnable)
        _binding = null
    }

    // It updates the date, time, and day of the calendar.
    private fun updateClock() {
        val calendar = Calendar.getInstance()
        val dateFormat = SimpleDateFormat("LLLL dd yyyy", Locale.getDefault())
        val timeFormat = SimpleDateFormat("hh:mm:ss a", Locale.getDefault())
        val dayFormat = SimpleDateFormat("EEEE", Locale.getDefault())

        val date = dateFormat.format(calendar.time)
        val time = timeFormat.format(calendar.time)
        val day = dayFormat.format(calendar.time)

        binding.textdate.text = date
        binding.texttime.text = time
        binding.textday.text = day
    }

    override fun onPause() {
        super.onPause()
        updateTimeHandler.removeCallbacks(runnable)
    }

    override fun onResume() {
        super.onResume()
        updateTimeHandler.postDelayed(runnable, 2000)
    }

    private val runnable = Runnable {
        tourismViewPager2.currentItem = (tourismViewPager2.currentItem + 1) % combinedAdapter.itemCount
        eventsViewPager2.currentItem = (eventsViewPager2.currentItem + 1) % combinedAdapter2.itemCount
    }
}