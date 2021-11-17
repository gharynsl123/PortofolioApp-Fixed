package com.example.portofolio.ui

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.browser.customtabs.CustomTabsIntent
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.portofolio.data.PortofolioData
import com.example.portofolio.R
import com.example.portofolio.adapter.RVAndroidAdapter
import com.example.portofolio.databinding.FragmentAndroidBinding


private const val PORTOFOLIO_LINK = "https://gharyn-portfolio.netlify.app/"

class AndroidFragment : Fragment() {
    private var _binding: FragmentAndroidBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAndroidBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val androidAdapter = RVAndroidAdapter()
        androidAdapter.setData(PortofolioData.listAppAndroid)

        androidAdapter.onItemClicked = { selectedData ->
            CustomTabsIntent.Builder().build()
                .launchUrl(requireContext(), Uri.parse(selectedData.link))
        }

        with(binding.rvAndroid) {
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            adapter = androidAdapter
        }

        binding.btnAndroid.text = getString(
            R.string.app_android_btn,
            PortofolioData.listAppAndroid.size.toString()
        )

        binding.txtDokumentasi.setOnClickListener {
            CustomTabsIntent.Builder().build()
                .launchUrl(requireContext(), Uri.parse(PORTOFOLIO_LINK))
        }
    }
}